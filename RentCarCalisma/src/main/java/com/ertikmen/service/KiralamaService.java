package com.ertikmen.service;

import com.ertikmen.model.Kiralama;
import com.ertikmen.repository.KiralamaRepository;

public class KiralamaService {

    private KiralamaRepository kiralamaRepository;

    public KiralamaService() {
        this.kiralamaRepository = new KiralamaRepository();
    }

    public void kiradakiAracler() {
        kiralamaRepository.kiradakiAraclar();
    }

    public Kiralama kiralamaOlustur(Kiralama kiralama) {
        return kiralamaRepository.kiralamaOlustur(kiralama);
    }
}
