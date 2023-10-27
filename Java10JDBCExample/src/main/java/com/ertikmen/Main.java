package com.ertikmen;
/*
futbolAppDb
--Futbolcu
--Takim
 */

import com.ertikmen.repository.FutbolcuRepository;
import com.ertikmen.repository.TakimRepository;
import com.ertikmen.repository.entity.Futbolcu;
import com.ertikmen.repository.entity.Takim;
import com.ertikmen.utility.ConnectionProvider;

public class Main {
    public static void main(String[] args) {

        Takim takim=Takim.builder().ad("Beşiktaş").build();
        Futbolcu futbolcu=Futbolcu.builder().ad("Mustafa").mevki("Defans").takim_id(takim.getId()).formaNo(3).build();

        ConnectionProvider connectionProvider=new ConnectionProvider();
        TakimRepository takimRepository=new TakimRepository(connectionProvider);
        FutbolcuRepository futbolcuRepository= new FutbolcuRepository(connectionProvider);
        takimRepository.save(takim);



    }
}
