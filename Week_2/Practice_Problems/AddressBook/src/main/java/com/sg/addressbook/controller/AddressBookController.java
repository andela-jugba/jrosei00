/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dto.Address;
import com.sg.addressbook.ui.AddressBookView;
import com.sg.addressbook.ui.UserIO;
import com.sg.addressbook.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookController {

    AddressBookView view;
    AddressBookDao dao;
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    createAddress();
                    break;
                case 2:
                    removeAddress();
                    break;
                case 3:
                    viewAddress();
                    break;
                case 4:
                    io.print("FIND ADDRESS");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndSelection();
    }

    private void createAddress() {
        view.displayCreateAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayCreateSuccessBanner();
    }

    private void listAddresses() {
        view.displayDisplayAllBanner();
        List<Address> AddressList = dao.getAllAddresses();
        view.displayAddressList(AddressList);
    }

    private void viewAddress() {
        view.displayDisplayAddressBanner();
        String lastName = view.getLastNameChoice();
        Address address = dao.getAddress(lastName);
        view.displayAddress(address);
    }

    private void removeAddress() {
        view.displayRemoveAddressBanner();
        String lastName = view.getLastNameChoice();
        dao.removeAddress(lastName);
        view.displayRemoveSuccessBanner();
    }

    public void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    public void exitMessage() {
        view.displayExitBanner();
    }

    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }
}
