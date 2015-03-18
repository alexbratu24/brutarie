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
@Table(name = "OrderProducts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderProducts.findAll", query = "SELECT o FROM OrderProducts o"),
    @NamedQuery(name = "OrderProducts.findByOrderProductsid", query = "SELECT o FROM OrderProducts o WHERE o.orderProductsid = :orderProductsid"),
    @NamedQuery(name = "OrderProducts.findByQuantity", query = "SELECT o FROM OrderProducts o WHERE o.quantity = :quantity")})
public class OrderProducts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "OrderProducts_id")
    private Integer orderProductsid;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "Id_Order", referencedColumnName = "Order_Id")
    @ManyToOne(optional = false)
    private Order1 idOrder;
    @JoinColumn(name = "Id_Prod", referencedColumnName = "Product_Id")
    @ManyToOne(optional = false)
    private Products idProd;

    public OrderProducts() {
    }

    public OrderProducts(Integer orderProductsid) {
        this.orderProductsid = orderProductsid;
    }

    public OrderProducts(Integer orderProductsid, int quantity) {
        this.orderProductsid = orderProductsid;
        this.quantity = quantity;
    }

    public Integer getOrderProductsid() {
        return orderProductsid;
    }

    public void setOrderProductsid(Integer orderProductsid) {
        this.orderProductsid = orderProductsid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order1 getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Order1 idOrder) {
        this.idOrder = idOrder;
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
        hash += (orderProductsid != null ? orderProductsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderProducts)) {
            return false;
        }
        OrderProducts other = (OrderProducts) object;
        if ((this.orderProductsid == null && other.orderProductsid != null) || (this.orderProductsid != null && !this.orderProductsid.equals(other.orderProductsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.OrderProducts[ orderProductsid=" + orderProductsid + " ]";
    }
    
}
