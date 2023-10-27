package com.ertikmen.service;

import com.ertikmen.repository.KisiRepository;

public class KisiService {

    private KisiRepository kisiRepository;

    public KisiService() {
        this.kisiRepository = new KisiRepository();
    }
}
