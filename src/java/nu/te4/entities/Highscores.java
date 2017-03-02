/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author guan97005
 */
@Entity
@Table(name = "highscores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Highscores.findAll", query = "SELECT h FROM Highscores h"),
    @NamedQuery(name = "Highscores.findByUserId", query = "SELECT h FROM Highscores h WHERE h.userId = :userId"),
    @NamedQuery(name = "Highscores.findByMaxPlateId", query = "SELECT h FROM Highscores h WHERE h.maxPlateId = :maxPlateId")})
public class Highscores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Column(name = "max(plate_id)")
    private Integer maxPlateId;

    public Highscores() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getMaxPlateId() {
        return maxPlateId;
    }

    public void setMaxPlateId(Integer maxPlateId) {
        this.maxPlateId = maxPlateId;
    }

    @Override
    public String toString() {
        return "nu.te4.entities.User[ id=" + userId + " ]";
    }
}
