/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface AddressBookDao {
    
    Address addAddress(String lastName, Address address);
    
    List<Address> getAllAddresses();
    
    Address getAddress(String lastName);
    
    Address removeAddress(String lastName);
    
}
