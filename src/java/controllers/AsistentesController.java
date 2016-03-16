/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import recursos.Encrypt;
import entitys.Asistentes;
import interfaces.AsistentesFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import recursos.FacesUtil;

/**
 *
 * @author r_mor_000
 */
@ManagedBean
@ViewScoped
public class AsistentesController implements Serializable {

    /**
     * Creates a new instance of controllerAsistentes
     */
    @EJB
    private AsistentesFacadeLocal asistentesEJB;

    private Asistentes asistentes;

    @PostConstruct
    public void init() {

        setAsistentes(new Asistentes());
    }

    public void ingresarUsuario() {

        try {
            System.err.println("Iniciando Ingreso usuario");
            System.out.println("Conraseña :" + asistentes.getContrasena());
          //  asistentes.setContrasena(Encrypt.sha512(asistentes.getContrasena()));

            System.out.println("Encriptado :" + asistentes.getContrasena());
            System.out.println("Tamaño :" + asistentes.getContrasena().length());

            getAsistentesEJB().create(asistentes);
            FacesUtil.addInfoMessage("Ingreso Exitoso");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Ingreso fallido");
        }
    }

    /**
     * @return the asistentes
     */
    public Asistentes getAsistentes() {
        return asistentes;
    }

    /**
     * @param asistentes the asistentes to set
     */
    public void setAsistentes(Asistentes asistentes) {
        this.asistentes = asistentes;
    }

    /**
     * @return the asistentesEJB
     */
    public AsistentesFacadeLocal getAsistentesEJB() {
        return asistentesEJB;
    }

    /**
     * @param asistentesEJB the asistentesEJB to set
     */
    public void setAsistentesEJB(AsistentesFacadeLocal asistentesEJB) {
        this.asistentesEJB = asistentesEJB;
    }
    
    
}
