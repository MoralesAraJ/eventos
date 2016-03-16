/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoseAntonio
 */
@Entity
@Table(name = "asistente_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsistenteEvento.findAll", query = "SELECT a FROM AsistenteEvento a"),
    @NamedQuery(name = "AsistenteEvento.findById", query = "SELECT a FROM AsistenteEvento a WHERE a.id = :id")})
public class AsistenteEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_evento", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Eventos idEvento;
    @JoinColumn(name = "id_asistente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Asistentes idAsistente;

    public AsistenteEvento() {
    }

    public AsistenteEvento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Eventos getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Eventos idEvento) {
        this.idEvento = idEvento;
    }

    public Asistentes getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(Asistentes idAsistente) {
        this.idAsistente = idAsistente;
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
        if (!(object instanceof AsistenteEvento)) {
            return false;
        }
        AsistenteEvento other = (AsistenteEvento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.AsistenteEvento[ id=" + id + " ]";
    }
    
}
