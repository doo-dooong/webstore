package com.ezen.webstore.domain;

import org.apache.tomcat.jni.Address;

import lombok.*;

@Getter @Setter
public class Customer {

	/**
	 * 
	 */

	private static final long serialVersionUID = -6826767593342468039L;
	private String customerId;
	private String name;
	private String address;
	private int noOfOrdersMade;
	private Address billingAddress;
	private String phoneNumber;
	private boolean wrongId = false;

	public Customer() {
		super();
		this.billingAddress = new Address();
	}

	public Customer(String customerId, String name) {
		this();
		this.customerId = customerId;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
