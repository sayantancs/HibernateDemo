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
	private Address address;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getDescriptionl() {
		return description;
	}
	public void setDescriptionl(String descriptionl) {
		this.description = descriptionl;
	}
	
	
}
