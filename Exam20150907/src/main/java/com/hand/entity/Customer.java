package com.hand.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Short customerId;
	private Short addressId;
	private Short storeId;
	private String firstName;
	private String lastName;
	private String email;
	private Boolean active;
	private Date createDate;
	private Date lastUpdate;
	private String address;
	private String store;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(Short customerId, String address, String firstName, String lastName, String email,
			Date lastUpdate) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.lastUpdate = lastUpdate;
		this.address = address;
	}

	/** full constructor */
	public Customer(Short addressId, Short storeId, String firstName, String lastName, String email, Boolean active,
			Date createDate, Date lastUpdate, String address, String store) {
		this.address = address;
		this.store = store;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.createDate = createDate;
		this.lastUpdate = lastUpdate;
		this.addressId = addressId;
		this.storeId = storeId;
	}

	// Property accessors

	public Short getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Short customerId) {
		this.customerId = customerId;
	}

	public Short getAddressId() {
		return addressId;
	}

	public void setAddressId(Short addressId) {
		this.addressId = addressId;
	}

	public Short getStoreId() {
		return storeId;
	}

	public void setStoreId(Short storeId) {
		this.storeId = storeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", addressId=" + addressId + ", storeId=" + storeId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", active=" + active
				+ ", createDate=" + createDate + ", lastUpdate=" + lastUpdate + ", address=" + address + ", store="
				+ store + "]";
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

}