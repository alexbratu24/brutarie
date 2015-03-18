/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexandru
 */
@Entity
@Table(name = "Collected")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collected.findAll", query = "SELECT c FROM Collected c"),
    @NamedQuery(name = "Collected.findByCollectedId", query = "SELECT c FROM Collected c WHERE c.collectedId = :collectedId"),
    @NamedQuery(name = "Collected.findByValue", query = "SELECT c FROM Collected c WHERE c.value = :value"),
    @NamedQuery(name = "Collected.findByDate", query = "SELECT c FROM Collected c WHERE c.date = :date"),
    @NamedQuery(name = "Collected.findByDescription", query = "SELECT c FROM Collected c WHERE c.description = :description")})
public class Collected implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Collected_Id")
    private Integer collectedId;
    @Basic(optional = false)
    @Column(name = "Value")
    private double value;
    @Basic(optional = false)
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "Id_Client", referencedColumnName = "Client_Id")
    @ManyToOne(optional = false)
    private Clients idClient;

    public Collected() {
    }

    public Collected(Integer collectedId) {
        this.collectedId = collectedId;
    }

    public Collected(Integer collectedId, double value, Date date) {
        this.collectedId = collectedId;
        this.value = value;
        this.date = date;
    }

    public Integer getCollectedId() {
        return collectedId;
    }

    public void setCollectedId(Integer collectedId) {
        this.collectedId = collectedId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectedId != null ? collectedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collected)) {
            return false;
        }
        Collected other = (Collected) object;
        if ((this.collectedId == null && other.collectedId != null) || (this.collectedId != null && !this.collectedId.equals(other.collectedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Collected[ collectedId=" + collectedId + " ]";
    }
    
}
