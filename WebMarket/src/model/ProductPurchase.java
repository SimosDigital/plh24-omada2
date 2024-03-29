/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Simos
 */
@Entity
@Table(name = "PRODUCT_PURCHASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductPurchase.findAll", query = "SELECT p FROM ProductPurchase p"),
    @NamedQuery(name = "ProductPurchase.findByProductPurchaseId", query = "SELECT p FROM ProductPurchase p WHERE p.productPurchaseId = :productPurchaseId"),
    @NamedQuery(name = "ProductPurchase.findByQuantity", query = "SELECT p FROM ProductPurchase p WHERE p.quantity = :quantity")})
public class ProductPurchase implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCT_PURCHASE_ID")
    private Integer productPurchaseId;
    @Basic(optional = false)
    @Column(name = "QUANTITY")
    private int quantity;
    @JoinColumn(name = "PURCHASE_ID", referencedColumnName = "PURCHASE_ID")
    @ManyToOne(optional = false)
    private Purchase purchaseId;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    @ManyToOne(optional = false)
    private Product productId;

    public ProductPurchase() {
    }

    public ProductPurchase(Integer productPurchaseId) {
        this.productPurchaseId = productPurchaseId;
    }

    public ProductPurchase(Integer productPurchaseId, int quantity) {
        this.productPurchaseId = productPurchaseId;
        this.quantity = quantity;
    }

    public Integer getProductPurchaseId() {
        return productPurchaseId;
    }

    public void setProductPurchaseId(Integer productPurchaseId) {
        Integer oldProductPurchaseId = this.productPurchaseId;
        this.productPurchaseId = productPurchaseId;
        changeSupport.firePropertyChange("productPurchaseId", oldProductPurchaseId, productPurchaseId);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        int oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public Purchase getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Purchase purchaseId) {
        Purchase oldPurchaseId = this.purchaseId;
        this.purchaseId = purchaseId;
        changeSupport.firePropertyChange("purchaseId", oldPurchaseId, purchaseId);
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        Product oldProductId = this.productId;
        this.productId = productId;
        changeSupport.firePropertyChange("productId", oldProductId, productId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productPurchaseId != null ? productPurchaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductPurchase)) {
            return false;
        }
        ProductPurchase other = (ProductPurchase) object;
        if ((this.productPurchaseId == null && other.productPurchaseId != null) || (this.productPurchaseId != null && !this.productPurchaseId.equals(other.productPurchaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProductPurchase[ productPurchaseId=" + productPurchaseId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
