/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package externalmodel;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author Simos
 */
@Entity
@Table(name = "EXTERNAL_BANK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExternalBank.findAll", query = "SELECT e FROM ExternalBank e"),
    @NamedQuery(name = "ExternalBank.findByBankId", query = "SELECT e FROM ExternalBank e WHERE e.bankId = :bankId"),
    @NamedQuery(name = "ExternalBank.findByName", query = "SELECT e FROM ExternalBank e WHERE e.name = :name")})
public class ExternalBank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BANK_ID")
    private Integer bankId;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "bank")
    private Collection<CreditCardAuthority> creditCardAuthorityCollection;

    public ExternalBank() {
    }

    public ExternalBank(Integer bankId) {
        this.bankId = bankId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<CreditCardAuthority> getCreditCardAuthorityCollection() {
        return creditCardAuthorityCollection;
    }

    public void setCreditCardAuthorityCollection(Collection<CreditCardAuthority> creditCardAuthorityCollection) {
        this.creditCardAuthorityCollection = creditCardAuthorityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankId != null ? bankId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExternalBank)) {
            return false;
        }
        ExternalBank other = (ExternalBank) object;
        if ((this.bankId == null && other.bankId != null) || (this.bankId != null && !this.bankId.equals(other.bankId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "externalmodel.ExternalBank[ bankId=" + bankId + " ]";
    }
    
}
