
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import nu.te4.entities.Plate;
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
    
    @EJB
    PlateFacade plateFacade;
    
    @EJB
    UserFacade userFacade;
    
    public List<Plate> getPlates(){
        return plateFacade.findAll();
    }
}
