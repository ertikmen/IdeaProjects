package com.ertikmen.service;

import com.ertikmen.repository.KiralamaRepository;

public class KiralamaService {

    private KiralamaRepository kiralamaRepository;

    public KiralamaService() {
        this.kiralamaRepository = new KiralamaRepository();
    }
}
