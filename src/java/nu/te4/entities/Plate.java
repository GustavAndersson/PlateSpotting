/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author guan97005
 */
@Entity
@Table(name = "plate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plate.findAll", query = "SELECT p FROM Plate p"),
    @NamedQuery(name = "Plate.findByPlateId", query = "SELECT p FROM Plate p WHERE p.platePK.plateId = :plateId"),
    @NamedQuery(name = "Plate.findByUserId", query = "SELECT p FROM Plate p WHERE p.platePK.userId = :userId"),
    @NamedQuery(name = "Plate.findByDate", query = "SELECT p FROM Plate p WHERE p.date = :date"),
    @NamedQuery(name = "Plate.findByNote", query = "SELECT p FROM Plate p WHERE p.note = :note")})
public class Plate implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlatePK platePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "note")
    private String note;

    public Plate() {
    }

    public Plate(PlatePK platePK) {
        this.platePK = platePK;
    }

    public Plate(PlatePK platePK, String date, String note) {
        this.platePK = platePK;
        this.date = date;
        this.note = note;
    }

    public Plate(int plateId, int userId) {
        this.platePK = new PlatePK(plateId, userId);
    }

    public PlatePK getPlatePK() {
        return platePK;
    }

    public void setPlatePK(PlatePK platePK) {
        this.platePK = platePK;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (platePK != null ? platePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plate)) {
            return false;
        }
        Plate other = (Plate) object;
        if ((this.platePK == null && other.platePK != null) || (this.platePK != null && !this.platePK.equals(other.platePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nu.te4.entities.Plate[ platePK=" + platePK + " ]";
    }
    
}
