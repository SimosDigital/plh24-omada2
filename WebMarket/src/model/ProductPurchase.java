/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user0
 */
@Entity
@Table(name = "PRODUCT_PURCHASE")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "ProductPurchase.findAll", query = "SELECT p FROM ProductPurchase p"),
	@NamedQuery(name = "ProductPurchase.findByPurchaseId", query = "SELECT p FROM ProductPurchase p WHERE p.productPurchasePK.purchaseId = :purchaseId"),
	@NamedQuery(name = "ProductPurchase.findByProductId", query = "SELECT p FROM ProductPurchase p WHERE p.productPurchasePK.productId = :productId"),
	@NamedQuery(name = "ProductPurchase.findByQuantity", query = "SELECT p FROM ProductPurchase p WHERE p.quantity = :quantity")})
public class ProductPurchase implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected ProductPurchasePK productPurchasePK;
	@Basic(optional = false)
        @Column(name = "QUANTITY")
	private int quantity;
	@JoinColumn(name = "PURCHASE_ID", referencedColumnName = "PURCHASE_ID", insertable = false, updatable = false)
        @ManyToOne(optional = false)
	private Purchase purchase;
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", insertable = false, updatable = false)
        @ManyToOne(optional = false)
	private Product product;

	public ProductPurchase() {
	}

	public ProductPurchase(ProductPurchasePK productPurchasePK) {
		this.productPurchasePK = productPurchasePK;
	}

	public ProductPurchase(ProductPurchasePK productPurchasePK, int quantity) {
		this.productPurchasePK = productPurchasePK;
		this.quantity = quantity;
	}

	public ProductPurchase(int purchaseId, int productId) {
		this.productPurchasePK = new ProductPurchasePK(purchaseId, productId);
	}

	public ProductPurchasePK getProductPurchasePK() {
		return productPurchasePK;
	}

	public void setProductPurchasePK(ProductPurchasePK productPurchasePK) {
		this.productPurchasePK = productPurchasePK;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (productPurchasePK != null ? productPurchasePK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ProductPurchase)) {
			return false;
		}
		ProductPurchase other = (ProductPurchase) object;
		if ((this.productPurchasePK == null && other.productPurchasePK != null) || (this.productPurchasePK != null && !this.productPurchasePK.equals(other.productPurchasePK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.ProductPurchase[ productPurchasePK=" + productPurchasePK + " ]";
	}
	
}
