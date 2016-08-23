/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.8.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2014
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package org.hoteia.qalingo.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hoteia.qalingo.core.domain.impl.DomainEntity;

@Entity
@Table(name="TECO_CUSTOMER_WISHLIST")
public class CustomerWishlist extends AbstractEntity<CustomerWishlist> implements DomainEntity {

	/**
	 * Generated UID
	 */
	private static final long serialVersionUID = -3836432112830050327L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Version
	@Column(name="VERSION", nullable=false) // , columnDefinition="int(11) default 1"
	private int version;
	
	@Column(name="POSITION", nullable=false) // , columnDefinition="int(11) default 0"
	private int position;
	
	@Column(name="PRODUCT_SKU_CODE")
	private String productSkuCode;
	
    @Column(name="CATALOG_CATEGORY_CODE")
    private String catalogCategoryCode;
	
	@Column(name="CUSTOMER_MARKET_AREA_ID")
	private Long customerMarketAreaId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_CREATE")
	private Date dateCreate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_UPDATE")
	private Date dateUpdate;
	
    public CustomerWishlist() {
        this.dateCreate = new Date();
        this.dateUpdate = new Date();
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getProductSkuCode() {
		return productSkuCode;
	}

	public void setProductSkuCode(String productSkuCode) {
		this.productSkuCode = productSkuCode;
	}

	public String getCatalogCategoryCode() {
        return catalogCategoryCode;
    }
	
	public void setCatalogCategoryCode(String catalogCategoryCode) {
        this.catalogCategoryCode = catalogCategoryCode;
    }
	
	public Long getCustomerMarketAreaId() {
		return customerMarketAreaId;
	}
	
	public void setCustomerMarketAreaId(Long customerMarketAreaId) {
		this.customerMarketAreaId = customerMarketAreaId;
	}
	
	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerMarketAreaId == null) ? 0 : customerMarketAreaId.hashCode());
        result = prime * result + ((dateCreate == null) ? 0 : dateCreate.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((productSkuCode == null) ? 0 : productSkuCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object sourceObj) {
        Object obj = deproxy(sourceObj);
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomerWishlist other = (CustomerWishlist) obj;
        if (customerMarketAreaId == null) {
            if (other.customerMarketAreaId != null)
                return false;
        } else if (!customerMarketAreaId.equals(other.customerMarketAreaId))
            return false;
        if (dateCreate == null) {
            if (other.dateCreate != null)
                return false;
        } else if (!dateCreate.equals(other.dateCreate))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (productSkuCode == null) {
            if (other.productSkuCode != null)
                return false;
        } else if (!productSkuCode.equals(other.productSkuCode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomerWishlist [id=" + id + ", version=" + version + ", position=" + position + ", productSkuCode=" + productSkuCode + ", customerMarketAreaId=" + customerMarketAreaId
                + ", dateCreate=" + dateCreate + ", dateUpdate=" + dateUpdate + "]";
    }

}