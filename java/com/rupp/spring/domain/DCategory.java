/***/
package com.rupp.spring.domain;

import java.util.Date;

/**
 * map to table test_table (id, message)
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2017
 */
public class DCustomer {
    private Long id;
    private String firstName;
    private Date dob;
    
    public DCustomer() {
        
    }
    public DCustomer(Long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param name the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the dob
     */
    public Date getDOB() {
        return dob;
    }
    /**
     * @param dob the dob to set
     */
    public void setDOB(Date dob) {
        this.dob = dob;
    }
    
    
}
