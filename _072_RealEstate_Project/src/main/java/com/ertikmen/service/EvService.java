package com.ertikmen.service;

import com.ertikmen.repository.EvRepository;

public class EvService {

        private EvRepository evRepository;

    public EvService() {
        this.evRepository = new EvRepository();
    }
}
