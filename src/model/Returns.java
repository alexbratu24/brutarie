/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexandru
 */
@Entity
@Table(name = "Returns")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Returns.findAll", query = "SELECT r FROM Returns r"),
    @NamedQuery(name = "Returns.findByReturnId", query = "SELECT r FROM Returns r WHERE r.returnId = :returnId"),
    @NamedQuery(name = "Returns.findByIdClient", query = "SELECT r FROM Returns r WHERE r.idClient = :idClient"),
    @NamedQuery(name = "Returns.findByDate", query = "SELECT r FROM Returns r WHERE r.date = :date"),
    @NamedQuery(name = "Returns.findByDescription", query = "SELECT r FROM Returns r WHERE r.description = :description")})
public class Returns implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Return_Id")
    private Integer returnId;
    @Basic(optional = false)
    @Column(name = "Id_Client")
    private int idClient;
    @Basic(optional = false)
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReturn")
    private Collection<ReturnedProducts> returnedProductsCollection;

    public Returns() {
    }

    public Returns(Integer returnId) {
        this.returnId = returnId;
    }

    public Returns(Integer returnId, int idClient, Date date) {
        this.returnId = returnId;
        this.idClient = idClient;
        this.date = date;
    }

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    @XmlTransient
    public Collection<ReturnedProducts> getReturnedProductsCollection() {
        return returnedProductsCollection;
    }

    public void setReturnedProductsCollection(Collection<ReturnedProducts> returnedProductsCollection) {
        this.returnedProductsCollection = returnedProductsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (returnId != null ? returnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Returns)) {
            return false;
        }
        Returns other = (Returns) object;
        if ((this.returnId == null && other.returnId != null) || (this.returnId != null && !this.returnId.equals(other.returnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Returns[ returnId=" + returnId + " ]";
    }
    
}
