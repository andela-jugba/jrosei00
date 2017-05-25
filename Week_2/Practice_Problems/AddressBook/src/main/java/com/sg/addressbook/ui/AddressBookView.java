/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookView {

    private UserIO io;

    public int printMenuAndSelection() {
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

    public void displayCreateAddressBanner() {
        io.print("=== Create Address ===");
    }

    public void displayCreateSuccessBanner() {
        io.print("Address successfully created. Please hit enter to continue");
    }

    public void displayAddressList(List<Address> AddressList) {
        for (Address currentAddress : AddressList) {
            io.print(currentAddress.getLastName() + ": "
                    + currentAddress.getFirstName() + " "
                    + currentAddress.getAddress()
                    + currentAddress.getZipCode());
        }
        io.print("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Addresses ===");
    }

    public void displayDisplayAddressBanner() {
        io.print("=== Display Address ===");
    }

    public String getLastNameChoice() {
        return io.readString("Please enter the last name");
    }

    public void displayAddress(Address address) {
        if (address != null) {
            io.print(address.getLastName());
            io.print(address.getFirstName() + " " + address.getAddress());
            io.print((Integer.toString(address.getZipCode())));
            io.print("");
        } else {
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveAddressBanner() {
        io.print("=== Remove Address ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Address successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Goodbye!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!");
    }

    public AddressBookView(UserIO io) {
        this.io = io;
    }
}
