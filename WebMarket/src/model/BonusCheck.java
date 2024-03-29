/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Simos
 */
@Entity
@Table(name = "BONUS_CHECK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BonusCheck.findAll", query = "SELECT b FROM BonusCheck b"),
    @NamedQuery(name = "BonusCheck.findByCheckId", query = "SELECT b FROM BonusCheck b WHERE b.checkId = :checkId"),
    @NamedQuery(name = "BonusCheck.findByDateIn", query = "SELECT b FROM BonusCheck b WHERE b.dateIn = :dateIn"),
    @NamedQuery(name = "BonusCheck.findByAmount", query = "SELECT b FROM BonusCheck b WHERE b.amount = :amount")})
public class BonusCheck implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CHECK_ID")
    private Integer checkId;
    @Basic(optional = false)
    @Column(name = "DATE_IN")
    @Temporal(TemporalType.DATE)
    private Date dateIn;
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private float amount;
    @JoinColumn(name = "PURCHASE_ID", referencedColumnName = "PURCHASE_ID")
    @ManyToOne
    private Purchase purchaseId;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private Customer customerId;

    public BonusCheck() {
    }

    public BonusCheck(Integer checkId) {
        this.checkId = checkId;
    }

    public BonusCheck(Integer checkId, Date dateIn, float amount) {
        this.checkId = checkId;
        this.dateIn = dateIn;
        this.amount = amount;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        Integer oldCheckId = this.checkId;
        this.checkId = checkId;
        changeSupport.firePropertyChange("checkId", oldCheckId, checkId);
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        Date oldDateIn = this.dateIn;
        this.dateIn = dateIn;
        changeSupport.firePropertyChange("dateIn", oldDateIn, dateIn);
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        float oldAmount = this.amount;
        this.amount = amount;
        changeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public Purchase getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Purchase purchaseId) {
        Purchase oldPurchaseId = this.purchaseId;
        this.purchaseId = purchaseId;
        changeSupport.firePropertyChange("purchaseId", oldPurchaseId, purchaseId);
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        Customer oldCustomerId = this.customerId;
        this.customerId = customerId;
        changeSupport.firePropertyChange("customerId", oldCustomerId, customerId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkId != null ? checkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BonusCheck)) {
            return false;
        }
        BonusCheck other = (BonusCheck) object;
        if ((this.checkId == null && other.checkId != null) || (this.checkId != null && !this.checkId.equals(other.checkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BonusCheck[ checkId=" + checkId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
