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
@Table(name = "TypesEmps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypesEmps.findAll", query = "SELECT t FROM TypesEmps t"),
    @NamedQuery(name = "TypesEmps.findByTypesEmpId", query = "SELECT t FROM TypesEmps t WHERE t.typesEmpId = :typesEmpId"),
    @NamedQuery(name = "TypesEmps.findByType", query = "SELECT t FROM TypesEmps t WHERE t.type = :type"),
    @NamedQuery(name = "TypesEmps.findByTypeName", query = "SELECT t FROM TypesEmps t WHERE t.typeName = :typeName"),
    @NamedQuery(name = "TypesEmps.findByDescription", query = "SELECT t FROM TypesEmps t WHERE t.description = :description")})
public class TypesEmps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TypesEmp_Id")
    private Integer typesEmpId;
    @Basic(optional = false)
    @Column(name = "Type")
    private int type;
    @Basic(optional = false)
    @Column(name = "Type_Name")
    private String typeName;
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idType")
    private Collection<Employees> employeesCollection;

    public TypesEmps() {
    }

    public TypesEmps(Integer typesEmpId) {
        this.typesEmpId = typesEmpId;
    }

    public TypesEmps(Integer typesEmpId, int type, String typeName) {
        this.typesEmpId = typesEmpId;
        this.type = type;
        this.typeName = typeName;
    }

    public Integer getTypesEmpId() {
        return typesEmpId;
    }

    public void setTypesEmpId(Integer typesEmpId) {
        this.typesEmpId = typesEmpId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typesEmpId != null ? typesEmpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypesEmps)) {
            return false;
        }
        TypesEmps other = (TypesEmps) object;
        if ((this.typesEmpId == null && other.typesEmpId != null) || (this.typesEmpId != null && !this.typesEmpId.equals(other.typesEmpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TypesEmps[ typesEmpId=" + typesEmpId + " ]";
    }
    
}
