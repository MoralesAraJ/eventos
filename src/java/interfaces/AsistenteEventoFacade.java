/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entitys.AsistenteEvento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Leno
 */
@Stateless
public class AsistenteEventoFacade extends AbstractFacade<AsistenteEvento> implements AsistenteEventoFacadeLocal {

    @PersistenceContext(unitName = "eventoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsistenteEventoFacade() {
        super(AsistenteEvento.class);
    }
    
}
