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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductId", query = "SELECT p FROM Products p WHERE p.productId = :productId"),
    @NamedQuery(name = "Products.findByProductWeight", query = "SELECT p FROM Products p WHERE p.productWeight = :productWeight"),
    @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name"),
    @NamedQuery(name = "Products.findByDescription", query = "SELECT p FROM Products p WHERE p.description = :description"),
    @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price"),
    @NamedQuery(name = "Products.findByIdCategory", query = "SELECT p FROM Products p WHERE p.idCategory = :idCategory")})
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Product_Id")
    private Integer productId;
    @Basic(optional = false)
    @Column(name = "Product_Weight")
    private double productWeight;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "Price")
    private Integer price;
    @Column(name = "Id_Category")
    private Integer idCategory;
    @JoinColumn(name = "Id_Production", referencedColumnName = "Production_Id")
    @ManyToOne
    private Productions idProduction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProd")
    private Collection<OrderProducts> orderProductsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduct")
    private Collection<ReturnedProducts> returnedProductsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProd")
    private Collection<ClientProdPrices> clientProdPricesCollection;

    public Products() {
    }

    public Products(Integer productId) {
        this.productId = productId;
    }

    public Products(Integer productId, double productWeight, String name) {
        this.productId = productId;
        this.productWeight = productWeight;
        this.name = name;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Productions getIdProduction() {
        return idProduction;
    }

    public void setIdProduction(Productions idProduction) {
        this.idProduction = idProduction;
    }

    @XmlTransient
    public Collection<OrderProducts> getOrderProductsCollection() {
        return orderProductsCollection;
    }

    public void setOrderProductsCollection(Collection<OrderProducts> orderProductsCollection) {
        this.orderProductsCollection = orderProductsCollection;
    }

    @XmlTransient
    public Collection<ReturnedProducts> getReturnedProductsCollection() {
        return returnedProductsCollection;
    }

    public void setReturnedProductsCollection(Collection<ReturnedProducts> returnedProductsCollection) {
        this.returnedProductsCollection = returnedProductsCollection;
    }

    @XmlTransient
    public Collection<ClientProdPrices> getClientProdPricesCollection() {
        return clientProdPricesCollection;
    }

    public void setClientProdPricesCollection(Collection<ClientProdPrices> clientProdPricesCollection) {
        this.clientProdPricesCollection = clientProdPricesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
