/*******************************************************************************
 * Copyright 2019 ODTS
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.simplejava.customer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.simplejava.customer.Customer;

/***
 * 
 * @author Tanveer
 *
 */
@Repository
public class CustomerDao extends BaseDao {
	
	/***
	 * 
	 * @param emailId
	 * @return
	 */
	public Customer findByEmailId(String emailId) {
		String sqlId = "findCustomerByEmailId";
		return getSingleRowResult(sqlId,emailId);
	}
	
	public List<Customer> findByFirstName(Customer customer) {
		String sqlId = "findCustomerByFirstName";
		return getMultipleRowResult(sqlId,customer);
	}
	
	/***
	 * 
	 * @return
	 */
	public List<Customer> findAll(){
		String sqlId="findAllCustomers";
		return getMultipleRowResult(sqlId);
	}
	/***
	 * 
	 * @param addressBook
	 */
	public void saveCustomer(Customer customer) {
		String sqlId="insertCustomer";
		save(sqlId, customer);
	}
	
	public void updateCustomer(Customer customer) {
		String sqlId="updateCustomer";
		update(sqlId, customer);
		
	}
	
	public void deleteCustomer(Long id) {
		String sqlId="deleteCustomer";
		delete(sqlId, id);
		
	}
}
