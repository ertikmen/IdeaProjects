package com.ertikmen.controller;

import com.ertikmen.model.Kiralama;
import com.ertikmen.service.KiralamaService;

public class KiralamaController {

    private KiralamaService kiralamaService;

    public KiralamaController() {
        this.kiralamaService = new KiralamaService();
    }


    public Kiralama kiralamaOlustur(Kiralama kiralama) {
        return kiralamaService.kiralamaOlustur(kiralama);
    }
}
