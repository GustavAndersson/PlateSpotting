/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nu.te4.entities.Highscores;

/**
 *
 * @author guan97005
 */
@Stateless
public class HighscoresFacade extends AbstractFacade<Highscores> {

    @PersistenceContext(unitName = "PlateSpottingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HighscoresFacade() {
        super(Highscores.class);
    }
    
}
