/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entitys.AsistenteEvento;
import entitys.Asistentes;
import entitys.Eventos;
import interfaces.AsistenteEventoFacadeLocal;
import interfaces.AsistentesFacadeLocal;
import interfaces.EventosFacadeLocal;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Leno
 */
@ManagedBean
@ViewScoped
public class ControllerEventos implements Serializable {

    @EJB
    private AsistenteEventoFacadeLocal asistenteEventoFacade;

    @EJB
    private AsistentesFacadeLocal asistentesFacade;

    @EJB
    private EventosFacadeLocal eventosFacade;

    private Asistentes asistentes;
    private Eventos eventos;

    private List<Asistentes> asistenteList;
    private List<Eventos> eventoList;
    private List<AsistenteEvento> asistenteEventoList;

    @ManagedProperty(value = "#{controllerSession}")
    private ControllerSession controllerSession;

    private boolean admin;

    /**
     * Creates a new instance of ControllerEventos
     */
    @PostConstruct
    public void init() {
        System.out.println("controllers.ControllerEventos.init()");
        eventoList = eventosFacade.findAll();
        asistenteList = asistentesFacade.findAll();
        asistenteEventoList = asistenteEventoFacade.findAll();
        asistentes = new Asistentes();
        eventos = new Eventos();
        asistentes = controllerSession.getAsistentes();
        if (asistentes != null) {
            System.out.println("No se nulo");
            eventoList = new LinkedList<>();
            if (!asistentes.getAdmin()) {
                System.out.println("User > "+asistentes.getCorreo());
                System.out.println("ID > "+asistentes.getId());
                for (AsistenteEvento ae : asistenteEventoFacade.findAll()) {
                    if (ae.getIdAsistente().equals(asistentes)) {
                        eventoList.add(ae.getIdEvento());
                    }
                }
            } else {
                System.out.println("Admin");
                eventoList = eventosFacade.findAll();
            }
        } else {
            asistentes = new Asistentes();
            System.err.println("Es Nulo");
        }

    }

    public AsistentesFacadeLocal getAsistentesFacade() {
        return asistentesFacade;
    }

    public void setAsistentesFacade(AsistentesFacadeLocal asistentesFacade) {
        this.asistentesFacade = asistentesFacade;
    }

    public EventosFacadeLocal getEventosFacade() {
        return eventosFacade;
    }

    public void setEventosFacade(EventosFacadeLocal eventosFacade) {
        this.eventosFacade = eventosFacade;
    }

    public Asistentes getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(Asistentes asistentes) {
        this.asistentes = asistentes;
    }

    public Eventos getEventos() {
        return eventos;
    }

    public void setEventos(Eventos eventos) {
        this.eventos = eventos;
        asistenteEventoList = new LinkedList<>();
        for (AsistenteEvento ae : asistenteEventoFacade.findAll()) {
            if (ae.getIdEvento().equals(eventos)) {
                asistenteEventoList.add(ae);
            }
        }
        System.out.println("Cantidad : " + asistenteEventoList.size());
    }

    public List<Asistentes> getAsistenteList() {
        return asistenteList;
    }

    public void setAsistenteList(List<Asistentes> asistenteList) {
        this.asistenteList = asistenteList;
    }

    public List<Eventos> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Eventos> eventoList) {
        this.eventoList = eventoList;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void nuevoEvento() {
        eventos = new Eventos();
    }

    public void nuevoAsistente() {
        asistentes = new Asistentes();
    }

    public void guardarAsistente() {
        asistentes.setAdmin(false);
        asistentesFacade.create(asistentes);
        asistenteList = asistentesFacade.findAll();
    }

    public void guardarEvento() {
        System.out.println("controllers.ControllerEventos.guardarEvento()");
        eventosFacade.create(eventos);
        eventoList = eventosFacade.findAll();
    }

    public void asignarOrQuitar(Asistentes item) {
        System.out.println("controllers.ControllerEventos.asignarOrQuitar()");
        System.out.println("Cantidad :" + asistenteEventoList.size());
        boolean esta = false;
        AsistenteEvento este = null;
        for (AsistenteEvento ae : asistenteEventoList) {
            if (ae.getIdAsistente().equals(item)) {
                esta = true;
                este = ae;
                break;
            }
        }
        System.out.println("Evento: " + eventos.getNombre());
        System.out.println("Asist: " + item.getNombre());

        if (esta) {
            System.out.println("Esta");
            asistenteEventoFacade.remove(este);
        } else {
            System.out.println("No esta");
            este = new AsistenteEvento();
            este.setIdAsistente(item);
            este.setIdEvento(eventos);
            asistenteEventoFacade.create(este);
        }

        setEventos(eventos);
    }

    public List<AsistenteEvento> getAsistenteEventoList() {
        return asistenteEventoList;
    }

    public void setAsistenteEventoList(List<AsistenteEvento> asistenteEventoList) {
        this.asistenteEventoList = asistenteEventoList;
    }

    public boolean findAsis(Asistentes a) {
        boolean esta = false;
        for (AsistenteEvento ae : asistenteEventoList) {
            if (ae.getIdAsistente().equals(a)) {
                esta = true;
                break;
            }
        }
        return esta;
    }

    public AsistenteEventoFacadeLocal getAsistenteEventoFacade() {
        return asistenteEventoFacade;
    }

    public void setAsistenteEventoFacade(AsistenteEventoFacadeLocal asistenteEventoFacade) {
        this.asistenteEventoFacade = asistenteEventoFacade;
    }

    public ControllerSession getControllerSession() {
        return controllerSession;
    }

    public void setControllerSession(ControllerSession controllerSession) {
        this.controllerSession = controllerSession;
    }

}
