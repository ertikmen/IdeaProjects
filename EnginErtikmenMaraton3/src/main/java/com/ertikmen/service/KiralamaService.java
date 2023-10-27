package com.ertikmen.service;

import com.ertikmen.model.Arac;
import com.ertikmen.model.Kiralama;
import com.ertikmen.repository.KiralamaRepository;

import java.util.List;

public class KiralamaService {

    private KiralamaRepository kiralamaRepository;

    public KiralamaService() {
        this.kiralamaRepository = new KiralamaRepository();
    }

    public void kiradakiAraclar() {
        kiralamaRepository.kiradakiAraclar();
    }

    public Kiralama kiralamaOlustur(Kiralama kiralama) {
        return kiralamaRepository.kiralamaOlustur(kiralama);
    }

    public List<Arac> kiralananAraclarByKisiId(Long id) {
        return kiralamaRepository.kiralananAraclarByKisiId(id);
    }
}
