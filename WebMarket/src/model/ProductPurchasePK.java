/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author user0
 */
@Embeddable
public class ProductPurchasePK implements Serializable {
	@Basic(optional = false)
        @Column(name = "PURCHASE_ID")
	private int purchaseId;
	@Basic(optional = false)
        @Column(name = "PRODUCT_ID")
	private int productId;

	public ProductPurchasePK() {
	}

	public ProductPurchasePK(int purchaseId, int productId) {
		this.purchaseId = purchaseId;
		this.productId = productId;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) purchaseId;
		hash += (int) productId;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ProductPurchasePK)) {
			return false;
		}
		ProductPurchasePK other = (ProductPurchasePK) object;
		if (this.purchaseId != other.purchaseId) {
			return false;
		}
		if (this.productId != other.productId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.ProductPurchasePK[ purchaseId=" + purchaseId + ", productId=" + productId + " ]";
	}
	
}
