
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import nu.te4.entities.Plate;
import nu.te4.entities.User;
import nu.te4.sessionbeans.PlateFacade;
import nu.te4.sessionbeans.UserFacade;
import nu.te4.support.BCrypt;

@Named
@SessionScoped
public class UserBean implements Serializable {

    private String name, password, hashedPassword;

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
    
    public static int username;
    public String authenticate() {
        List<User> user = userFacade.findWithName(name);
        User users = user.get(0);
        if (BCrypt.checkpw(password, users.getPassword())) {
            username = users.getId();
            //Den inloggades plates ligger här
            List<Plate> plates = plateFacade.findWithID(users.getId());
            for (Plate plate : plates) {
                System.out.println(plate.getPlatePK().getPlateId());
                System.out.println(plate.getNote());
            }
            //Den inloggades senaste plate hämtas
            List<Plate> maxPlate = plateFacade.findMaxPlate(users.getId());
            System.out.println("Max plate:" + maxPlate.get(0));
         

            System.out.println("Logged in");
            return "myPage";
        } else {
            System.out.println("Login does not work");
            return "index";
        }
    }

}
