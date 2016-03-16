/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entitys.Asistentes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leno
 */
@Local
public interface AsistentesFacadeLocal {

    void create(Asistentes asistentes);

    void edit(Asistentes asistentes);

    void remove(Asistentes asistentes);

    Asistentes find(Object id);

    List<Asistentes> findAll();

    List<Asistentes> findRange(int[] range);

    int count();
    
}
