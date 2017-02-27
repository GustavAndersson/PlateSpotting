
import java.io.Serializable;
import java.util.Date;
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
public class PlateBean implements Serializable{
    
    private int userID, plateID;
    private String note;
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
    
    public List<Plate> getPlates(){      
        return plateFacade.findAll();
    }
    
    public String getUser(int id){
        return userFacade.find(id).getName();
    }
    
    public String savePlate(){
       PlatePK platePK = new PlatePK(userID, plateID);
       Plate plate = new Plate(platePK, date, note);
       User user = userFacade.find(userID);
      // platePK.setUserId(user);
       plateFacade.create(plate);
        
        return "index";
    }
}
