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
@Table(name = "Routes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Routes.findAll", query = "SELECT r FROM Routes r"),
    @NamedQuery(name = "Routes.findByRouteId", query = "SELECT r FROM Routes r WHERE r.routeId = :routeId"),
    @NamedQuery(name = "Routes.findByDescription", query = "SELECT r FROM Routes r WHERE r.description = :description")})
public class Routes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Route_Id")
    private Integer routeId;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRoute")
    private Collection<RouteClients> routeClientsCollection;

    public Routes() {
    }

    public Routes(Integer routeId) {
        this.routeId = routeId;
    }

    public Routes(Integer routeId, String description) {
        this.routeId = routeId;
        this.description = description;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeId != null ? routeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Routes)) {
            return false;
        }
        Routes other = (Routes) object;
        if ((this.routeId == null && other.routeId != null) || (this.routeId != null && !this.routeId.equals(other.routeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Routes[ routeId=" + routeId + " ]";
    }
    
}
