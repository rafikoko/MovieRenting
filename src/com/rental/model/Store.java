package com.rental.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the store database table.
 * 
 */
@Entity
@NamedQuery(name="Store.findAll", query="SELECT s FROM Store s")
public class Store extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	private int storeId;
	private Timestamp lastUpdate;
	private byte managerStaffId;
	private String name;
	private Address address;

	public Store() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="store_id", columnDefinition="TINYINT")
	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}


	@Column(name="last_update")
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	@Column(name="manager_staff_id")
	public byte getManagerStaffId() {
		return this.managerStaffId;
	}

	public void setManagerStaffId(byte managerStaffId) {
		this.managerStaffId = managerStaffId;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="address_id")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}