/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findByClientId", query = "SELECT c FROM Clients c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "Clients.findByIdCategory", query = "SELECT c FROM Clients c WHERE c.idCategory = :idCategory"),
    @NamedQuery(name = "Clients.findByName", query = "SELECT c FROM Clients c WHERE c.name = :name"),
    @NamedQuery(name = "Clients.findByAddress", query = "SELECT c FROM Clients c WHERE c.address = :address"),
    @NamedQuery(name = "Clients.findByLocation", query = "SELECT c FROM Clients c WHERE c.location = :location"),
    @NamedQuery(name = "Clients.findByDescription", query = "SELECT c FROM Clients c WHERE c.description = :description")})
public class Clients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Client_Id")
    private Integer clientId;
    @Column(name = "Id_Category")
    private Integer idCategory;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "Location")
    private String location;
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<RouteClients> routeClientsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<ToCollect> toCollectCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<ClientProdPrices> clientProdPricesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<Collected> collectedCollection;

    public Clients() {
    }

    public Clients(Integer clientId) {
        this.clientId = clientId;
    }

    public Clients(Integer clientId, String name, String location) {
        this.clientId = clientId;
        this.name = name;
        this.location = location;
    }
    
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<RouteClients> getRouteClientsCollection() {
        return routeClientsCollection;
    }

    public void setRouteClientsCollection(Collection<RouteClients> routeClientsCollection) {
        this.routeClientsCollection = routeClientsCollection;
    }

    @XmlTransient
    public Collection<ToCollect> getToCollectCollection() {
        return toCollectCollection;
    }

    public void setToCollectCollection(Collection<ToCollect> toCollectCollection) {
        this.toCollectCollection = toCollectCollection;
    }

    @XmlTransient
    public Collection<ClientProdPrices> getClientProdPricesCollection() {
        return clientProdPricesCollection;
    }

    public void setClientProdPricesCollection(Collection<ClientProdPrices> clientProdPricesCollection) {
        this.clientProdPricesCollection = clientProdPricesCollection;
    }

    @XmlTransient
    public Collection<Collected> getCollectedCollection() {
        return collectedCollection;
    }

    public void setCollectedCollection(Collection<Collected> collectedCollection) {
        this.collectedCollection = collectedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
