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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@NamedQuery(name = "Customer.findByPointsCardNumber", query = "SELECT c FROM Customer c WHERE c.pointsCardNumber = :pointsCardNumber"),
	@NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName"),
	@NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM Customer c WHERE c.lastName = :lastName"),
	@NamedQuery(name = "Customer.findByAvailablePoints", query = "SELECT c FROM Customer c WHERE c.availablePoints = :availablePoints"),
	@NamedQuery(name = "Customer.findByChecksno", query = "SELECT c FROM Customer c WHERE c.checksno = :checksno"),
	@NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address")})
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "CUSTOMER_ID")
	private Integer customerId;
	@Basic(optional = false)
        @Column(name = "POINTS_CARD_NUMBER")
	private String pointsCardNumber;
	@Basic(optional = false)
        @Column(name = "FIRST_NAME")
	private String firstName;
	@Basic(optional = false)
        @Column(name = "LAST_NAME")
	private String lastName;
	@Basic(optional = false)
        @Column(name = "AVAILABLE_POINTS")
	private int availablePoints;
	@Column(name = "CHECKSNO")
	private Integer checksno;
	@Column(name = "ADDRESS")
	private String address;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Purchase> purchaseList;

	public Customer() {
	}

	public Customer(Integer customerId) {
		this.customerId = customerId;
	}

	public Customer(Integer customerId, String pointsCardNumber, String firstName, String lastName, int availablePoints) {
		this.customerId = customerId;
		this.pointsCardNumber = pointsCardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.availablePoints = availablePoints;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getPointsCardNumber() {
		return pointsCardNumber;
	}

	public void setPointsCardNumber(String pointsCardNumber) {
		this.pointsCardNumber = pointsCardNumber;
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

	public int getAvailablePoints() {
		return availablePoints;
	}

	public void setAvailablePoints(int availablePoints) {
		this.availablePoints = availablePoints;
	}

	public Integer getChecksno() {
		return checksno;
	}

	public void setChecksno(Integer checksno) {
		this.checksno = checksno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
