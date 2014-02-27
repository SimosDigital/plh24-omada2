/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.List;
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
 * @author user0
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
	@NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
	@NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName"),
	@NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM Customer c WHERE c.lastName = :lastName"),
	@NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address"),
	@NamedQuery(name = "Customer.findByPointsCardNumber", query = "SELECT c FROM Customer c WHERE c.pointsCardNumber = :pointsCardNumber"),
	@NamedQuery(name = "Customer.findByAvailablePoints", query = "SELECT c FROM Customer c WHERE c.availablePoints = :availablePoints"),
	@NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
	@NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
	@NamedQuery(name = "Customer.findByCreditCardNumber", query = "SELECT c FROM Customer c WHERE c.creditCardNumber = :creditCardNumber"),
	@NamedQuery(name = "Customer.findByCreditCardOwnerName", query = "SELECT c FROM Customer c WHERE c.creditCardOwnerName = :creditCardOwnerName"),
	@NamedQuery(name = "Customer.findByCreditCardCvv", query = "SELECT c FROM Customer c WHERE c.creditCardCvv = :creditCardCvv"),
	@NamedQuery(name = "Customer.findByCreditCardBank", query = "SELECT c FROM Customer c WHERE c.creditCardBank = :creditCardBank")})
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @Column(name = "CUSTOMER_ID")
	private Integer customerId;
	@Basic(optional = false)
        @Column(name = "FIRST_NAME")
	private String firstName;
	@Basic(optional = false)
        @Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "ADDRESS")
	private String address;
	@Basic(optional = false)
        @Column(name = "POINTS_CARD_NUMBER")
	private String pointsCardNumber;
	@Basic(optional = false)
        @Column(name = "AVAILABLE_POINTS")
	private int availablePoints;
	@Basic(optional = false)
        @Column(name = "PASSWORD")
	private String password;
	@Basic(optional = false)
        @Column(name = "EMAIL")
	private String email;
	@Column(name = "CREDIT_CARD_NUMBER")
	private String creditCardNumber;
	@Column(name = "CREDIT_CARD_OWNER_NAME")
	private String creditCardOwnerName;
	@Column(name = "CREDIT_CARD_CVV")
	private Integer creditCardCvv;
	@Column(name = "CREDIT_CARD_BANK")
	private String creditCardBank;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
	private List<BonusCheck> bonusCheckList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
	private List<Purchase> purchaseList;

	public Customer() {
	}

	public Customer(Integer customerId) {
		this.customerId = customerId;
	}

	public Customer(Integer customerId, String firstName, String lastName, String pointsCardNumber, int availablePoints, String password, String email) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pointsCardNumber = pointsCardNumber;
		this.availablePoints = availablePoints;
		this.password = password;
		this.email = email;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPointsCardNumber() {
		return pointsCardNumber;
	}

	public void setPointsCardNumber(String pointsCardNumber) {
		this.pointsCardNumber = pointsCardNumber;
	}

	public int getAvailablePoints() {
		return availablePoints;
	}

	public void setAvailablePoints(int availablePoints) {
		this.availablePoints = availablePoints;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardOwnerName() {
		return creditCardOwnerName;
	}

	public void setCreditCardOwnerName(String creditCardOwnerName) {
		this.creditCardOwnerName = creditCardOwnerName;
	}

	public Integer getCreditCardCvv() {
		return creditCardCvv;
	}

	public void setCreditCardCvv(Integer creditCardCvv) {
		this.creditCardCvv = creditCardCvv;
	}

	public String getCreditCardBank() {
		return creditCardBank;
	}

	public void setCreditCardBank(String creditCardBank) {
		this.creditCardBank = creditCardBank;
	}

	@XmlTransient
	public List<BonusCheck> getBonusCheckList() {
		return bonusCheckList;
	}

	public void setBonusCheckList(List<BonusCheck> bonusCheckList) {
		this.bonusCheckList = bonusCheckList;
	}

	@XmlTransient
	public List<Purchase> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(List<Purchase> purchaseList) {
		this.purchaseList = purchaseList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (customerId != null ? customerId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) object;
		if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Customer[ customerId=" + customerId + " ]";
	}
	
}
