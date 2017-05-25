/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

import com.sg.addressbook.dao.AddressBookDaoContract;
import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface AddressBookServiceLayer {

    private AddressBookDaoContract dao;

    public AddressBookServiceLayer(AddressBookDaoContract dao) {
        this.dao = dao;
    }

    public ServiceResponse add(Address address) {
        ServiceResponse response = validate(address);
        if (response.isSuccess()) {
            dao.add(address);
        }
        return response;
    }

    public int count() {
        return dao.count();
    }

    public boolean delete(String lastName) {
        return dao.delete(lastName);
    }

    public List<Address> find(String lastName) {
        return dao.find(lastName);
    }

    private ServiceResponse validate(Address address) {
        if (address == null) {
            return new ServiceResponse(false, "Address cannot be null");
        }

        if (address.getLastName() == null || address.getLastName().isEmpty()) {
            return new ServiceResponse(false, "Last name is required");
        }

        return new ServiceResponse(true, null);
    }
}
