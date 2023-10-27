package com.ertikmen.controller;

import com.ertikmen.model.Arac;
import com.ertikmen.model.Kiralama;
import com.ertikmen.service.KiralamaService;

import java.util.List;

public class KiralamaController {

    private KiralamaService kiralamaService;

    public KiralamaController() {
        this.kiralamaService = new KiralamaService();
    }


    public Kiralama kiralamaOlustur(Kiralama kiralama) {
        return kiralamaService.kiralamaOlustur(kiralama);
    }

    public List<Arac> kiralanmisArabalar(Long id) {
        return kiralamaService.kiralananAraclarByKisiId(id);
    }
}
