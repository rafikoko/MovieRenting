package com.rental.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	private int addressId;
	private String address;
	private String address2;
	private int cityId;
	private String district;
	private Timestamp lastUpdate;
	private String phone;
	private String postalCode;
	private List<Customer> customers;
	private List<Store> stores;

	public Address() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_id", columnDefinition="SMALLINT")
	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	@Column(name="city_id", columnDefinition="SMALLINT")
	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}


	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}


	@Column(name="last_update")
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Column(name="postal_code")
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="address")
	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setAddress(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setAddress(null);

		return customer;
	}


	//bi-directional many-to-one association to Store
	@OneToMany(mappedBy="address")
	public List<Store> getStores() {
		return this.stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public Store addStore(Store store) {
		getStores().add(store);
		store.setAddress(this);

		return store;
	}

	public Store removeStore(Store store) {
		getStores().remove(store);
		store.setAddress(null);

		return store;
	}

}