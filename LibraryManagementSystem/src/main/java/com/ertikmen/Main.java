package com.ertikmen;

import com.ertikmen.repository.AddressRepository;
import com.ertikmen.repository.UserInformationRepository;
import com.ertikmen.repository.UsersRepository;
import com.ertikmen.repository.entity.Address;
import com.ertikmen.repository.entity.UserInformation;
import com.ertikmen.repository.entity.Users;

public class Main {
    public static void main(String[] args) {

        UsersRepository usersRepository=new UsersRepository();
        UserInformationRepository userInformationRepository=new UserInformationRepository();

        //Adres kayıt işlemi

        AddressRepository addressRepository=new AddressRepository();
        Address address= Address.builder().city("Ankara").country("Türkiye").build();
        addressRepository.save(address);

        UserInformation userInformation=UserInformation.builder().firstName("Mustafa").lastName("Öztürk").address(address).build();
        userInformationRepository.save(userInformation);

        Users user= Users.builder().password("123").username("musty")
                .userInformation(userInformation).build();
        usersRepository.save(user);

        Users user2=Users.builder().username("engin").password("123456").userInformation(userInformation).build();
        usersRepository.save(user2);

    }
}