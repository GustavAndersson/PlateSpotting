
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import nu.te4.entities.Plate;
import nu.te4.entities.PlatePK;
import nu.te4.entities.User;
import nu.te4.sessionbeans.PlateFacade;
import nu.te4.sessionbeans.UserFacade;
import nu.te4.support.BCrypt;

@Named
@SessionScoped
public class UserBean implements Serializable {

    private String name, password, hashedPassword, note;
    private String date = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
    private List<Plate> myPlates;
    private int nextNumber;
    private int userID;

    public int getUserID() {
        return userID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNextNumber() {
        return nextNumber;
    }

    public List<Plate> getMyPlates() {
        return myPlates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @EJB
    UserFacade userFacade;

    @EJB
    PlateFacade plateFacade;

    public List<User> getUsers() {
        return userFacade.findAll();
    }

    public String createUser() {
        hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(null, name, hashedPassword);
        userFacade.create(user);
        return "index";
    }

    public String authenticate() {
        List<User> user = userFacade.findWithName(name);
        User users = user.get(0);
        if (BCrypt.checkpw(password, users.getPassword())) {
            //Den inloggades userID
            userID = user.get(0).getId();

            //Den inloggades plates ligger här
            myPlates = plateFacade.findWithID(users.getId());
            for (Plate plate : myPlates) {
                System.out.println(plate.getPlatePK().getPlateId());
                System.out.println(plate.getNote());
            }
            
            //Letar upp vilken platta användaren letar efter
            System.out.println("Sista plattan " + myPlates.get(myPlates.size() - 1).getPlatePK().getPlateId());
            nextNumber = myPlates.get(myPlates.size() - 1).getPlatePK().getPlateId();
            nextNumber = nextNumber + 1;

            System.out.println("Logged in");
            return "myPage";
        } else {
            System.out.println("Login does not work");
            return "index";
        }
    }

    public String savePlate() {
        PlatePK platePK = new PlatePK(nextNumber, userID);
        System.out.println("Din nya plattas nummer och userid" + platePK);
        Plate plate = new Plate(platePK, date, note);
        System.out.println("Din nya plattas egenskaper" + plate);
        plateFacade.create(plate);
        return "myPage";
    }

}
