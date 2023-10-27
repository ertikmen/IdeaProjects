package com.ertikmen.service;

import com.ertikmen.model.Arac;
import com.ertikmen.repository.AracRepository;

import java.util.List;

public class AracService {

    private AracRepository aracRepository;

    public AracService() {
        this.aracRepository = new AracRepository();
    }

    public Arac aracOlustur(Arac arac) {
        return aracRepository.aracOlustur(arac);
    }

    public Arac aracAraById(Long id) {
        return aracRepository.aracAraById(id);
    }

    public List<Arac> kiradakiAraclar() {
        return aracRepository.kiradakiAraclar();
    }

    public List<Arac> musaitAraclar() {
        return aracRepository.musaitAracler();
    }
}
