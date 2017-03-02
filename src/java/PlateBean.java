
import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import nu.te4.entities.Plate;
import nu.te4.entities.PlatePK;
import nu.te4.entities.User;
import nu.te4.sessionbeans.PlateFacade;
import nu.te4.sessionbeans.UserFacade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@Named
@SessionScoped
public class PlateBean implements Serializable {

    private int userID, plateID;
    private String note;
    private String date = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPlateID() {
        return plateID;
    }

    public void setPlateID(int plateID) {
        this.plateID = plateID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @EJB
    PlateFacade plateFacade;

    @EJB
    UserFacade userFacade;

    public List<Plate> getPlates() {
        System.out.println("All plates " + plateFacade.findAll());
        return plateFacade.findAll();
    }

    public String getUser(int id) {
        return userFacade.find(id).getName();
    }

   /* public List<Plate> getHighscore() {
        System.out.println("Highscores");
        List<Plate> plates = new LinkedList<>();
        PlatePK platePK = new PlatePK(555, 666);
        Plate p = new Plate(platePK, "datum", "note");
        plates.add(p);
        try {
             plates = plateFacade.findHighscores();
        } catch (Exception e) {
            PlatePK platePK2 = new PlatePK(666, 777);
            Plate p2 = new Plate(platePK2, "datum", "SKITEN CRASHADE");
            plates.add(p2);
        }

        return plates; //plateFacade.findHighscores();
    } */
    
}
