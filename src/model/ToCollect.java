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
@Table(name = "ToCollect")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ToCollect.findAll", query = "SELECT t FROM ToCollect t"),
    @NamedQuery(name = "ToCollect.findByToCollectId", query = "SELECT t FROM ToCollect t WHERE t.toCollectId = :toCollectId"),
    @NamedQuery(name = "ToCollect.findByIdOrder", query = "SELECT t FROM ToCollect t WHERE t.idOrder = :idOrder"),
    @NamedQuery(name = "ToCollect.findByValue", query = "SELECT t FROM ToCollect t WHERE t.value = :value"),
    @NamedQuery(name = "ToCollect.findByDescription", query = "SELECT t FROM ToCollect t WHERE t.description = :description")})
public class ToCollect implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ToCollect_Id")
    private Integer toCollectId;
    @Column(name = "Id_Order")
    private Integer idOrder;
    @Basic(optional = false)
    @Column(name = "Value")
    private double value;
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "Id_Client", referencedColumnName = "Client_Id")
    @ManyToOne(optional = false)
    private Clients idClient;

    public ToCollect() {
    }

    public ToCollect(Integer toCollectId) {
        this.toCollectId = toCollectId;
    }

    public ToCollect(Integer toCollectId, double value) {
        this.toCollectId = toCollectId;
        this.value = value;
    }

    public Integer getToCollectId() {
        return toCollectId;
    }

    public void setToCollectId(Integer toCollectId) {
        this.toCollectId = toCollectId;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
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

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toCollectId != null ? toCollectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ToCollect)) {
            return false;
        }
        ToCollect other = (ToCollect) object;
        if ((this.toCollectId == null && other.toCollectId != null) || (this.toCollectId != null && !this.toCollectId.equals(other.toCollectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ToCollect[ toCollectId=" + toCollectId + " ]";
    }
    
}
