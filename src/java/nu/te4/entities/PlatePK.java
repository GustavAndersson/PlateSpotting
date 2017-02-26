/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author guan97005
 */
@Embeddable
public class PlatePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "plate_id")
    private int plateId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;

    public PlatePK() {
    }

    public PlatePK(int plateId, int userId) {
        this.plateId = plateId;
        this.userId = userId;
    }

    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) plateId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlatePK)) {
            return false;
        }
        PlatePK other = (PlatePK) object;
        if (this.plateId != other.plateId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nu.te4.entities.PlatePK[ plateId=" + plateId + ", userId=" + userId + " ]";
    }
    
}
