/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.sessionbeans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nu.te4.entities.Plate;

/**
 *
 * @author guan97005
 */
@Stateless
public class PlateFacade extends AbstractFacade<Plate> {

    @PersistenceContext(unitName = "PlateSpottingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlateFacade() {
        super(Plate.class);
    }

    public List findWithID(int id) {
        return em.createQuery(
                "SELECT p FROM Plate p WHERE p.platePK.userId = :id")
                .setParameter("id", id)
                .getResultList();
    }
    
    public List findMaxPlate(int id){
        return em.createQuery(
                "SELECT max(p.platePK.plateId) FROM Plate p WHERE p.platePK.userId = :id")
                .setParameter("id", id)
                .getResultList();
    }

}
