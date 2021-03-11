package com.shashank.bookstore.pojo;

public class Customer 
{
	private int custId;
	private String custFName;
	private String custLName;
	private String custEmailId;
	private String custMobileNo;
	private String custPassword;
	private String custAddress;
	
	//Empty Object 
	public Customer() {
	}
	// Object without custId
	public Customer(String custFName, String custLName, String custEmailId, String custMobileNo, String custPassword,
			String custAddress) {
		super();
		this.custFName = custFName;
		this.custLName = custLName;
		this.custEmailId = custEmailId;
		this.custMobileNo = custMobileNo;
		this.custPassword = custPassword;
		this.custAddress = custAddress;
	}
	//object with Id
	public Customer(int custId, String custFName, String custLName, String custEmailId, String custMobileNo,
			String custPassword, String custAddress) {
		super();
		this.custId = custId;
		this.custFName = custFName;
		this.custLName = custLName;
		this.custEmailId = custEmailId;
		this.custMobileNo = custMobileNo;
		this.custPassword = custPassword;
		this.custAddress = custAddress;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custFName=" + custFName + ", custLName=" + custLName + ", custEamilId="
				+ custEmailId + ", custMobileNo=" + custMobileNo + ", custPassword=" + custPassword + ", custAddress="
				+ custAddress + "]";
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustFName() {
		return custFName;
	}
	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}
	public String getCustLName() {
		return custLName;
	}
	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}
	
	public String getCustEmailId() {
		return custEmailId;
	}
	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}
	public String getCustMobileNo() {
		return custMobileNo;
	}
	public void setCustMobileNo(String custMobileNo) {
		this.custMobileNo = custMobileNo;
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
}
