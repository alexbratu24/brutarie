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
@Table(name = "ReturnedProducts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReturnedProducts.findAll", query = "SELECT r FROM ReturnedProducts r"),
    @NamedQuery(name = "ReturnedProducts.findByRetProdId", query = "SELECT r FROM ReturnedProducts r WHERE r.retProdId = :retProdId"),
    @NamedQuery(name = "ReturnedProducts.findByQuantity", query = "SELECT r FROM ReturnedProducts r WHERE r.quantity = :quantity")})
public class ReturnedProducts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RetProd_Id")
    private Integer retProdId;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "Id_Product", referencedColumnName = "Product_Id")
    @ManyToOne(optional = false)
    private Products idProduct;
    @JoinColumn(name = "Id_Return", referencedColumnName = "Return_Id")
    @ManyToOne(optional = false)
    private Returns idReturn;

    public ReturnedProducts() {
    }

    public ReturnedProducts(Integer retProdId) {
        this.retProdId = retProdId;
    }

    public ReturnedProducts(Integer retProdId, int quantity) {
        this.retProdId = retProdId;
        this.quantity = quantity;
    }

    public Integer getRetProdId() {
        return retProdId;
    }

    public void setRetProdId(Integer retProdId) {
        this.retProdId = retProdId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Products idProduct) {
        this.idProduct = idProduct;
    }

    public Returns getIdReturn() {
        return idReturn;
    }

    public void setIdReturn(Returns idReturn) {
        this.idReturn = idReturn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (retProdId != null ? retProdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReturnedProducts)) {
            return false;
        }
        ReturnedProducts other = (ReturnedProducts) object;
        if ((this.retProdId == null && other.retProdId != null) || (this.retProdId != null && !this.retProdId.equals(other.retProdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ReturnedProducts[ retProdId=" + retProdId + " ]";
    }
    
}
