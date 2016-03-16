/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author r_mor_000
 */
@Entity
@Table(name = "asistentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistentes.findAll", query = "SELECT a FROM Asistentes a"),
    @NamedQuery(name = "Asistentes.findById", query = "SELECT a FROM Asistentes a WHERE a.id = :id"),
    @NamedQuery(name = "Asistentes.findByNombre", query = "SELECT a FROM Asistentes a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Asistentes.findByApellido", query = "SELECT a FROM Asistentes a WHERE a.apellido = :apellido"),
    @NamedQuery(name = "Asistentes.findByIdentificacion", query = "SELECT a FROM Asistentes a WHERE a.identificacion = :identificacion"),
    @NamedQuery(name = "Asistentes.findByCorreo", query = "SELECT a FROM Asistentes a WHERE a.correo = :correo"),
    @NamedQuery(name = "Asistentes.findByContrasena", query = "SELECT a FROM Asistentes a WHERE a.contrasena = :contrasena"),
    @NamedQuery(name = "Asistentes.findByCorreoAndCotrasena", query = "SELECT a FROM Asistentes a WHERE a.contrasena = :contrasena AND a.correo = :correo")
})
public class Asistentes implements Serializable {
    @Column(name = "admin")
    private Boolean admin;
    @OneToMany(mappedBy = "idAsistente", fetch = FetchType.EAGER)
    private List<AsistenteEvento> asistenteEventoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 50)
    @Column(name = "identificacion")
    private String identificacion;
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;
    @Size(max = 500)
    @Column(name = "contrasena")
    private String contrasena;

    public Asistentes() {
    }

    public Asistentes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistentes)) {
            return false;
        }
        Asistentes other = (Asistentes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Asistentes[ id=" + id + " ]";
    }


    @XmlTransient
    public List<AsistenteEvento> getAsistenteEventoList() {
        return asistenteEventoList;
    }

    public void setAsistenteEventoList(List<AsistenteEvento> asistenteEventoList) {
        this.asistenteEventoList = asistenteEventoList;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    
}
