/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

import com.sg.addressbook.dto.Address;

/**
 *
 * @author apprentice
 */
public class AddressBookView {
    
    UserIO io = new UserIOConsoleImpl();
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add Address");
        io.print("2. Remove Address");
        io.print("3. View Address");
        io.print("4. Find Address");
        io.print("5. Exit");
        
        return io.readInt("Please select from the above options.", 1, 5);
    }
    public Address getNewAddressInfo() {
        String lastName = io.readString("Please enter last name");
        String firstName = io.readString("Please enter first name");
        String address = io.readString("Please enter address");
        int zipCode = io.readInt("Please enter zip code");
        Address currentAddress = new Address(lastName);
        currentAddress.setFirstName(firstName);
        currentAddress.setAddress(address);
        currentAddress.setZipCode(zipCode);
        return currentAddress;
    }
    
    public void displayCreateAddresBanner() {
        io.print("=== Create Address ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.print("Address successfully created. Please hit enter to continue");
    }
}
