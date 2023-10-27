package com.ertikmen.service;

import com.ertikmen.repository.AddressRepository;
import com.ertikmen.repository.ICrud;
import com.ertikmen.repository.entity.Address;

import java.util.List;
import java.util.Optional;

public class AddressService implements ICrud<Address> {
    private AddressRepository AddressRepository;

    public AddressService() {
        this.AddressRepository = new AddressRepository();
    }

    @Override
    public Address save(Address address) {
        return AddressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        return AddressRepository.update(address);
    }

    @Override
    public void deleteById(Long id) {
        AddressRepository.deleteById(id);
    }

    @Override
    public List<Address> findAll() {
        return AddressRepository.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return AddressRepository.findById(id);
    }
}
