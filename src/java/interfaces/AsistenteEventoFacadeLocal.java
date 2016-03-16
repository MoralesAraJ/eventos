/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entitys.AsistenteEvento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leno
 */
@Local
public interface AsistenteEventoFacadeLocal {

    void create(AsistenteEvento asistenteEvento);

    void edit(AsistenteEvento asistenteEvento);

    void remove(AsistenteEvento asistenteEvento);

    AsistenteEvento find(Object id);

    List<AsistenteEvento> findAll();

    List<AsistenteEvento> findRange(int[] range);

    int count();
    
}
