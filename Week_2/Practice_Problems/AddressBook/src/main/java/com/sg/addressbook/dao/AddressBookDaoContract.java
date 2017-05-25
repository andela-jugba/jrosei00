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
public interface AddressBookDaoContract {
    
    void add (Address address);
    
    List< Address> all();
    
    int count ();
    
    boolean delete (String lastName);
    
    List <Address> find (String lastName);
}
