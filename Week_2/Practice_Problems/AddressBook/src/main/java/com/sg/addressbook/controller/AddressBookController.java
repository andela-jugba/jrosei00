/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoFileImpl;
import com.sg.addressbook.dto.Address;
import com.sg.addressbook.ui.AddressBookView;
import com.sg.addressbook.ui.UserIO;
import com.sg.addressbook.ui.UserIOConsoleImpl;

/**
 *
 * @author apprentice
 */
public class AddressBookController {

    AddressBookView view = new AddressBookView();
    private UserIO io = new UserIOConsoleImpl();
    AddressBookDao dao = new AddressBookDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            io.print("Main Menu");
            io.print("1. Add Address");
            io.print("2. Remove Address");
            io.print("3. View Addresses");
            io.print("4. Find Address");
            io.print("5. Exit");

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    io.print("ADD ADDRESS");
                    break;
                case 2:
                    io.print("REMOVE ADDRESS");
                    break;
                case 3:
                    io.print("VIEW ADDRESS");
                    break;
                case 4:
                    io.print("FIND ADDRESS");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
            io.print("GOOD BYE");
        }
        private int getMenuSelection() {
            return view.printMenuAndGetSelection();
        }
        
        private void createAddress() {
            view.displayCreateAddresBanner();
            Address newAddress = view.getNewAddressInfo();
            dao.addAddress(newAddress.getLastName(), newAddress);
            view.displayCreateSuccessBanner();
        }
    }
}
