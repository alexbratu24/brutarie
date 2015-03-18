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
@Table(name = "Order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByOrderId", query = "SELECT o FROM Order1 o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Order1.findByIdClient", query = "SELECT o FROM Order1 o WHERE o.idClient = :idClient"),
    @NamedQuery(name = "Order1.findByDateplaced", query = "SELECT o FROM Order1 o WHERE o.dateplaced = :dateplaced"),
    @NamedQuery(name = "Order1.findByValue", query = "SELECT o FROM Order1 o WHERE o.value = :value"),
    @NamedQuery(name = "Order1.findByDescription", query = "SELECT o FROM Order1 o WHERE o.description = :description"),
    @NamedQuery(name = "Order1.findByDatedelivery", query = "SELECT o FROM Order1 o WHERE o.datedelivery = :datedelivery")})
public class Order1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Order_Id")
    private Integer orderId;
    @Basic(optional = false)
    @Column(name = "Id_Client")
    private int idClient;
    @Basic(optional = false)
    @Column(name = "Date_placed")
    @Temporal(TemporalType.DATE)
    private Date dateplaced;
    @Basic(optional = false)
    @Column(name = "Value")
    private double value;
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "Date_delivery")
    @Temporal(TemporalType.DATE)
    private Date datedelivery;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrder")
    private Collection<OrderProducts> orderProductsCollection;

    public Order1() {
    }

    public Order1(Integer orderId) {
        this.orderId = orderId;
    }

    public Order1(Integer orderId, int idClient, Date dateplaced, double value, Date datedelivery) {
        this.orderId = orderId;
        this.idClient = idClient;
        this.dateplaced = dateplaced;
        this.value = value;
        this.datedelivery = datedelivery;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Date getDateplaced() {
        return dateplaced;
    }

    public void setDateplaced(Date dateplaced) {
        this.dateplaced = dateplaced;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatedelivery() {
        return datedelivery;
    }

    public void setDatedelivery(Date datedelivery) {
        this.datedelivery = datedelivery;
    }

    @XmlTransient
    public Collection<OrderProducts> getOrderProductsCollection() {
        return orderProductsCollection;
    }

    public void setOrderProductsCollection(Collection<OrderProducts> orderProductsCollection) {
        this.orderProductsCollection = orderProductsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Order1[ orderId=" + orderId + " ]";
    }
    
}
