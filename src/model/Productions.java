/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexandru
 */
@Entity
@Table(name = "Productions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productions.findAll", query = "SELECT p FROM Productions p"),
    @NamedQuery(name = "Productions.findByProductionId", query = "SELECT p FROM Productions p WHERE p.productionId = :productionId"),
    @NamedQuery(name = "Productions.findByName", query = "SELECT p FROM Productions p WHERE p.name = :name"),
    @NamedQuery(name = "Productions.findByDescription", query = "SELECT p FROM Productions p WHERE p.description = :description")})
public class Productions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Production_Id")
    private Integer productionId;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @OneToMany(mappedBy = "idProduction")
    private Collection<Products> productsCollection;

    public Productions() {
    }

    public Productions(Integer productionId) {
        this.productionId = productionId;
    }

    public Productions(Integer productionId, String name) {
        this.productionId = productionId;
        this.name = name;
    }

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productionId != null ? productionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productions)) {
            return false;
        }
        Productions other = (Productions) object;
        if ((this.productionId == null && other.productionId != null) || (this.productionId != null && !this.productionId.equals(other.productionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
