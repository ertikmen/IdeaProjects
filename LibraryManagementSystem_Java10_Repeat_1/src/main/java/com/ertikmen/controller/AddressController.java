package com.ertikmen.controller;

import com.ertikmen.repository.entity.Address;
import com.ertikmen.service.AddressService;

public class AddressController {

    private AddressService addressService;

    public AddressController() {
        this.addressService = new AddressService();

    }

    public Address save(Address address){
        return  addressService.save(address);
    }
}
