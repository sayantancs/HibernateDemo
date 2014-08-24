package org.javabrains.sayantan.dto;

import java.util.Date;

import javax.persistence.*;

//@Entity (name="USER_DETAILS")
@Entity
@Table (name = "USER_DETAILS" )
public class UserDetails {
	@Id							// Primary key
	@GeneratedValue				// Auto increment primary key
	//@Column (name="USER_ID")
	private int userId;
	//@Column (name="USER_NAME")
	@Basic							// default, if @Transient, then do not persist
	private String name ;
	@Temporal (TemporalType.DATE) 	// can save time or timestamp too
	private Date joinDate ;
	@Embedded 
	@AttributeOverrides({
	@AttributeOverride (name="street", column=@Column(name="homeStreet")),
	@AttributeOverride (name="city", column=@Column(name="homeCity")),
	@AttributeOverride (name="pincode", column=@Column(name="homePincode")),
	@AttributeOverride (name="state", column=@Column(name="homeState")) 
	})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;
	
	/*  @Lob - Large Object */
	private String description;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String descriptionl) {
		this.description = descriptionl;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
}
