/***/
package com.rupp.spring.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * map to table test_table (id, message)
 * 
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2017
 */
public class DCustomer {
	public Long id;
	public String firstName;
	public String lastName;
	public String gender;
	public String email;
	public String phone;
	public String address;
	public Date dob;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	//gender
	private static Map<String, String> genderOptions = new HashMap<String, String>();
	public static Map<String, String> getGenderOptions() {
        if(genderOptions.size() == 0) {
	 	    genderOptions.put("M", "Male");
	 	    genderOptions.put("F", "Female");
        }
        return genderOptions;
	}
	//end gender
	
}
