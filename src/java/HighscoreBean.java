
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import nu.te4.entities.Highscores;
import nu.te4.entities.Plate;
import nu.te4.sessionbeans.HighscoresFacade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guan97005
 */
@Named
@SessionScoped
public class HighscoreBean implements Serializable{
    private int plate_id, user_id;

    public int getPlate_id() {
        return plate_id;
    }

    public void setPlate_id(int plate_id) {
        this.plate_id = plate_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    
    @EJB
    HighscoresFacade highscoresFacade;
    
        public List<Highscores> getHighscores(){  
        System.out.println(highscoresFacade.findAll());
        return highscoresFacade.findAll();
    }
}
