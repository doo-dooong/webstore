package com.ezen.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Product implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -4677808004182465790L;
	private String productId;
	private String name;
	private BigDecimal unitPrice;
	private String unitPriceStr;
	private String description;
	private String manufacturer;
	private String category;
	private long unitsInStock;
	private long unitsInOrder;
	private boolean discontinued;
	private String condition;

	public Product() {
		super();
	}
	
	public Product(String productId, String name, BigDecimal unitPrice) {
		this.productId = productId;
		this.name = name;
		this.setUnitPrice(unitPrice);
	}

	// 여기 getters와 setters 를 추가
	
	
	
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
		DecimalFormat df = new DecimalFormat("#,###");
		this.unitPriceStr = df.format(unitPrice);
	} // https://stackoverflow.com/questions/26101918/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 :
				productId.hashCode());
		return result;
	}	
}
