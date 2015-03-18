/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexandru
 */
@Entity
@Table(name = "RouteClients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteClients.findAll", query = "SELECT r FROM RouteClients r"),
    @NamedQuery(name = "RouteClients.findByRouteClientId", query = "SELECT r FROM RouteClients r WHERE r.routeClientId = :routeClientId"),
    @NamedQuery(name = "RouteClients.findByOrderNr", query = "SELECT r FROM RouteClients r WHERE r.orderNr = :orderNr")})
public class RouteClients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RouteClient_Id")
    private Integer routeClientId;
    @Column(name = "Order_Nr")
    private Integer orderNr;
    @JoinColumn(name = "Id_Client", referencedColumnName = "Client_Id")
    @ManyToOne(optional = false)
    private Clients idClient;
    @JoinColumn(name = "Id_Route", referencedColumnName = "Route_Id")
    @ManyToOne(optional = false)
    private Routes idRoute;

    public RouteClients() {
    }

    public RouteClients(Integer routeClientId) {
        this.routeClientId = routeClientId;
    }

    public Integer getRouteClientId() {
        return routeClientId;
    }

    public void setRouteClientId(Integer routeClientId) {
        this.routeClientId = routeClientId;
    }

    public Integer getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(Integer orderNr) {
        this.orderNr = orderNr;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    public Routes getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Routes idRoute) {
        this.idRoute = idRoute;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeClientId != null ? routeClientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RouteClients)) {
            return false;
        }
        RouteClients other = (RouteClients) object;
        if ((this.routeClientId == null && other.routeClientId != null) || (this.routeClientId != null && !this.routeClientId.equals(other.routeClientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RouteClients[ routeClientId=" + routeClientId + " ]";
    }
    
}
