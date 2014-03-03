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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Simos
 */
@Entity
@Table(name = "PURCHASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchase.findAll", query = "SELECT p FROM Purchase p"),
    @NamedQuery(name = "Purchase.findByPurchaseId", query = "SELECT p FROM Purchase p WHERE p.purchaseId = :purchaseId"),
    @NamedQuery(name = "Purchase.findByDatetime", query = "SELECT p FROM Purchase p WHERE p.datetime = :datetime"),
    @NamedQuery(name = "Purchase.findByAmount", query = "SELECT p FROM Purchase p WHERE p.amount = :amount"),
    @NamedQuery(name = "Purchase.findByPointsEarned", query = "SELECT p FROM Purchase p WHERE p.pointsEarned = :pointsEarned"),
    @NamedQuery(name = "Purchase.findByDelivery", query = "SELECT p FROM Purchase p WHERE p.delivery = :delivery")})
public class Purchase implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PURCHASE_ID")
    private Integer purchaseId;
    @Column(name = "DATETIME")
    @Temporal(TemporalType.DATE)
    private Date datetime;
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private float amount;
    @Basic(optional = false)
    @Column(name = "POINTS_EARNED")
    private int pointsEarned;
    @Basic(optional = false)
    @Column(name = "DELIVERY")
    private int delivery;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseId")
    private List<ProductPurchase> productPurchaseList;
    @OneToMany(mappedBy = "purchaseId")
    private List<BonusCheck> bonusCheckList;
    @JoinColumn(name = "STORE_ID", referencedColumnName = "STORE_ID")
    @ManyToOne(optional = false)
    private Store storeId;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private Customer customerId;

    public Purchase() {
    }

    public Purchase(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Purchase(Integer purchaseId, float amount, int pointsEarned, int delivery) {
        this.purchaseId = purchaseId;
        this.amount = amount;
        this.pointsEarned = pointsEarned;
        this.delivery = delivery;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        Integer oldPurchaseId = this.purchaseId;
        this.purchaseId = purchaseId;
        changeSupport.firePropertyChange("purchaseId", oldPurchaseId, purchaseId);
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        Date oldDatetime = this.datetime;
        this.datetime = datetime;
        changeSupport.firePropertyChange("datetime", oldDatetime, datetime);
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        float oldAmount = this.amount;
        this.amount = amount;
        changeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(int pointsEarned) {
        int oldPointsEarned = this.pointsEarned;
        this.pointsEarned = pointsEarned;
        changeSupport.firePropertyChange("pointsEarned", oldPointsEarned, pointsEarned);
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        int oldDelivery = this.delivery;
        this.delivery = delivery;
        changeSupport.firePropertyChange("delivery", oldDelivery, delivery);
    }

    @XmlTransient
    public List<ProductPurchase> getProductPurchaseList() {
        return productPurchaseList;
    }

    public void setProductPurchaseList(List<ProductPurchase> productPurchaseList) {
        this.productPurchaseList = productPurchaseList;
    }

    @XmlTransient
    public List<BonusCheck> getBonusCheckList() {
        return bonusCheckList;
    }

    public void setBonusCheckList(List<BonusCheck> bonusCheckList) {
        this.bonusCheckList = bonusCheckList;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        Store oldStoreId = this.storeId;
        this.storeId = storeId;
        changeSupport.firePropertyChange("storeId", oldStoreId, storeId);
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
        hash += (purchaseId != null ? purchaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) object;
        if ((this.purchaseId == null && other.purchaseId != null) || (this.purchaseId != null && !this.purchaseId.equals(other.purchaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Purchase[ purchaseId=" + purchaseId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
