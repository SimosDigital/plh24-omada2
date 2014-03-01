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
 * @author Simos
 */
@Entity
@Table(name = "STORE_PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreProduct.findAll", query = "SELECT s FROM StoreProduct s"),
    @NamedQuery(name = "StoreProduct.findByProductStoreId", query = "SELECT s FROM StoreProduct s WHERE s.productStoreId = :productStoreId")})
public class StoreProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCT_STORE_ID")
    private Integer productStoreId;
    @JoinColumn(name = "STORE_ID", referencedColumnName = "STORE_ID")
    @ManyToOne(optional = false)
    private Store storeId;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    @ManyToOne(optional = false)
    private Product productId;

    public StoreProduct() {
    }

    public StoreProduct(Integer productStoreId) {
        this.productStoreId = productStoreId;
    }

    public Integer getProductStoreId() {
        return productStoreId;
    }

    public void setProductStoreId(Integer productStoreId) {
        this.productStoreId = productStoreId;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productStoreId != null ? productStoreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreProduct)) {
            return false;
        }
        StoreProduct other = (StoreProduct) object;
        if ((this.productStoreId == null && other.productStoreId != null) || (this.productStoreId != null && !this.productStoreId.equals(other.productStoreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.StoreProduct[ productStoreId=" + productStoreId + " ]";
    }
    
}
