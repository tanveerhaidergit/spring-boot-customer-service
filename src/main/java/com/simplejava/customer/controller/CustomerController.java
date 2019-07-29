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
package com.simplejava.customer.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplejava.customer.Customer;
import com.simplejava.customer.service.CustomerService;

import lombok.extern.log4j.Log4j2;
/***
 *  Controller class
 * @author Tanveer
 *
 */
@Log4j2
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	/***
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path="",produces="application/json")
	public ResponseEntity<Customer> findAllCustomers(){
		List<Customer> customers = service.findAll();
		return new ResponseEntity(customers, HttpStatus.OK);
	}
	/***
	 * 
	 * @param emailId
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path="/{emailId}",produces="application/json")
	public ResponseEntity<Customer> findByEmailId(@PathVariable String emailId){
		log.info("Inside findByEmailId :"+emailId);
		Customer customerByEmailId = service.findByEmailId(emailId);
		return new ResponseEntity(customerByEmailId, HttpStatus.OK);
	}
	/***
	 * 
	 * @param firstName
	 * @param dateOfBirth
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path="/firstname",produces="application/json")
	public ResponseEntity<Customer> findByFirstName(@RequestParam("firstName") String firstName	){
		log.info("Inside findByFirstName :"+firstName);
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		List<Customer> customers = service.findByFirstName(customer);
		return new ResponseEntity(customers, HttpStatus.OK);
	}
	
	/***
	 * 
	 * @param addressParam
	 * @return
	 */
	@PostMapping(path="",consumes="application/json",produces="application/json")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customerParam){
		log.info("Inside createCustomer:"+ customerParam);
		service.createCustomer(customerParam);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(customerParam.getId()).toUri();
		log.info("Uri:"+location);
		return ResponseEntity.created(location).build();
		
	}
	/***
	 * 
	 * @param id
	 * @param addressParam
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(path="/{id}",consumes="application/json",produces="application/json")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customer){
		log.info("Inside updateCustomer method with id {} and body {}",id,customer );
		customer.setId(id);
		service.updateCustomer(customer);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	/***
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(path="/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Long id) {
		log.info("Inside deleteCustomer api with id" +id );
		service.deleteCustomer(id);
		return new ResponseEntity(id, HttpStatus.OK);
		
	}
	
}
