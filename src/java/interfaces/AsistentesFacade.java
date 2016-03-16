/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entitys.Asistentes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Leno
 */
@Stateless
public class AsistentesFacade extends AbstractFacade<Asistentes> implements AsistentesFacadeLocal {

    @PersistenceContext(unitName = "eventoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsistentesFacade() {
        super(Asistentes.class);
    }
    
}
