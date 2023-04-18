/**
 * 
 */
package com.nba.sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Suresh A K
 *
 */
@Entity
@Table(name = "recommendation")
public class Recommendation {
	
	@Id
	private String customerId;
	
	private String usecaseOne;
	private String usecaseTwo;
	private String usecaseThree;
	
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * @return the usecaseOne
	 */
	public String getUsecaseOne() {
		return usecaseOne;
	}
	
	/**
	 * @param usecaseOne the usecaseOne to set
	 */
	public void setUsecaseOne(String usecaseOne) {
		this.usecaseOne = usecaseOne;
	}
	
	/**
	 * @return the usecaseTwo
	 */
	public String getUsecaseTwo() {
		return usecaseTwo;
	}
	/**
	 * @param usecaseTwo the usecaseTwo to set
	 */
	public void setUsecaseTwo(String usecaseTwo) {
		this.usecaseTwo = usecaseTwo;
	}
	/**
	 * @return the usecaseThree
	 */
	public String getUsecaseThree() {
		return usecaseThree;
	}
	
	/**
	 * @param usecaseThree the usecaseThree to set
	 */
	public void setUsecaseThree(String usecaseThree) {
		this.usecaseThree = usecaseThree;
	}

}
