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
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import recursos.FacesUtil;

/**
 *
 * @author r_mor_000
 */
@ManagedBean(name = "controllerSession")
@SessionScoped
public class ControllerSession implements Serializable {

    /**
     * Creates a new instance of controllerAsistentes
     */
    @EJB
    AsistentesFacadeLocal asistentesEJB;

    private Asistentes asistentes;

    @PostConstruct
    public void init() {

        setAsistentes(new Asistentes());
    }

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

    public void login() {
        String url = "";
        try {
            System.err.println("Iniciando Ingreso usuario");
            System.out.println("Conraseña :" + asistentes.getContrasena());
            //  asistentes.setContrasena(Encrypt.sha512(asistentes.getContrasena()));

            System.out.println("Encriptado :" + asistentes.getContrasena());
            System.out.println("Tamaño :" + asistentes.getContrasena().length());

            Asistentes retorno = null;
            for (Asistentes s : asistentesEJB.findAll()) {
                if (s.getContrasena().equals(asistentes.getContrasena()) && s.getCorreo().equals(asistentes.getCorreo())) {
                    retorno = s;
                    break;
                }
            }
            if (retorno != null) {
                asistentes = retorno;
                FacesUtil.addInfoMessage("Ingreso Exitoso");
                url = "vistas/GestionEventos.xhtml";
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect(ec.getRequestContextPath() + "/faces/vistas/GestionEventos.xhtml");
            } else {
                FacesUtil.addErrorMessage("Correo o Contraseña no valido");
            }

        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Ingreso fallido");
        }

    }

}
