/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexandru
 */
@Entity
@Table(name = "HistoryLogs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoryLogs.findAll", query = "SELECT h FROM HistoryLogs h"),
    @NamedQuery(name = "HistoryLogs.findByHistoryLogId", query = "SELECT h FROM HistoryLogs h WHERE h.historyLogId = :historyLogId"),
    @NamedQuery(name = "HistoryLogs.findByDate", query = "SELECT h FROM HistoryLogs h WHERE h.date = :date"),
    @NamedQuery(name = "HistoryLogs.findByDescription", query = "SELECT h FROM HistoryLogs h WHERE h.description = :description")})
public class HistoryLogs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "HistoryLog_Id")
    private Integer historyLogId;
    @Basic(optional = false)
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "Id_User", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private Users idUser;

    public HistoryLogs() {
    }

    public HistoryLogs(Integer historyLogId) {
        this.historyLogId = historyLogId;
    }

    public HistoryLogs(Integer historyLogId, Date date, String description) {
        this.historyLogId = historyLogId;
        this.date = date;
        this.description = description;
    }

    public Integer getHistoryLogId() {
        return historyLogId;
    }

    public void setHistoryLogId(Integer historyLogId) {
        this.historyLogId = historyLogId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historyLogId != null ? historyLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoryLogs)) {
            return false;
        }
        HistoryLogs other = (HistoryLogs) object;
        if ((this.historyLogId == null && other.historyLogId != null) || (this.historyLogId != null && !this.historyLogId.equals(other.historyLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.HistoryLogs[ historyLogId=" + historyLogId + " ]";
    }
    
}
