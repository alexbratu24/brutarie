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
@Table(name = "ClientProdPrices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientProdPrices.findAll", query = "SELECT c FROM ClientProdPrices c"),
    @NamedQuery(name = "ClientProdPrices.findByClientProdPriceId", query = "SELECT c FROM ClientProdPrices c WHERE c.clientProdPriceId = :clientProdPriceId"),
    @NamedQuery(name = "ClientProdPrices.findByPrice", query = "SELECT c FROM ClientProdPrices c WHERE c.price = :price")})
public class ClientProdPrices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ClientProdPrice_Id")
    private Integer clientProdPriceId;
    @Basic(optional = false)
    @Column(name = "Price")
    private double price;
    @JoinColumn(name = "Id_Client", referencedColumnName = "Client_Id")
    @ManyToOne(optional = false)
    private Clients idClient;
    @JoinColumn(name = "Id_Prod", referencedColumnName = "Product_Id")
    @ManyToOne(optional = false)
    private Products idProd;

    public ClientProdPrices() {
    }

    public ClientProdPrices(Integer clientProdPriceId) {
        this.clientProdPriceId = clientProdPriceId;
    }

    public ClientProdPrices(Integer clientProdPriceId, double price) {
        this.clientProdPriceId = clientProdPriceId;
        this.price = price;
    }

    public Integer getClientProdPriceId() {
        return clientProdPriceId;
    }

    public void setClientProdPriceId(Integer clientProdPriceId) {
        this.clientProdPriceId = clientProdPriceId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    public Products getIdProd() {
        return idProd;
    }

    public void setIdProd(Products idProd) {
        this.idProd = idProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientProdPriceId != null ? clientProdPriceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientProdPrices)) {
            return false;
        }
        ClientProdPrices other = (ClientProdPrices) object;
        if ((this.clientProdPriceId == null && other.clientProdPriceId != null) || (this.clientProdPriceId != null && !this.clientProdPriceId.equals(other.clientProdPriceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ClientProdPrices[ clientProdPriceId=" + clientProdPriceId + " ]";
    }
    
}
