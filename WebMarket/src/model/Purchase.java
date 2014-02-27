/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user0
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
	private Serializable delivery;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase")
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

	public Purchase(Integer purchaseId, float amount, int pointsEarned, Serializable delivery) {
		this.purchaseId = purchaseId;
		this.amount = amount;
		this.pointsEarned = pointsEarned;
		this.delivery = delivery;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
	}

	public Serializable getDelivery() {
		return delivery;
	}

	public void setDelivery(Serializable delivery) {
		this.delivery = delivery;
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
		this.storeId = storeId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
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
	
}
