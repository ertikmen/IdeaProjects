package com.ertikmen.service;

import com.ertikmen.repository.UserInformationRepository;
import com.ertikmen.repository.ICrud;
import com.ertikmen.repository.entity.UserInformation;

import java.util.List;
import java.util.Optional;

public class UserInformationService implements ICrud<UserInformation> {
    private UserInformationRepository UserInformationRepository;

    public UserInformationService() {
        this.UserInformationRepository = new UserInformationRepository();
    }

    @Override
    public UserInformation save(UserInformation userInformation) {
        return UserInformationRepository.save(userInformation);
    }

    @Override
    public UserInformation update(UserInformation userInformation) {
        return UserInformationRepository.update(userInformation);
    }

    @Override
    public void deleteById(Long id) {
        UserInformationRepository.deleteById(id);
    }

    @Override
    public List<UserInformation> findAll() {
        return UserInformationRepository.findAll();
    }

    @Override
    public Optional<UserInformation> findById(Long id) {
        return UserInformationRepository.findById(id);
    }
}
