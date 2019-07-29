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
package com.simplejava.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplejava.customer.Customer;
import com.simplejava.customer.dao.CustomerDao;
/***
 * 
 * @author Owner
 *
 */
@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao dao;
	
	public List<Customer> findAll(){
		return dao.findAll();
	}
	
	public List<Customer> findByFirstName(Customer customer){
		return dao.findByFirstName(customer);
	}
	
	public Customer findByEmailId(String emailId) {
		return dao.findByEmailId(emailId);
	}
	
	public void createCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}
	
	public void updateCustomer(Customer customer) {
		dao.updateCustomer(customer);
	}
	
	public void deleteCustomer(Long id) {
		dao.deleteCustomer(id);
	}

}
