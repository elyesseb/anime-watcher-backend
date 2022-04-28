package com.simplon.safety.net.alerts.service;

import com.simplon.safety.net.alerts.model.FireStation;
import com.simplon.safety.net.alerts.repository.FireStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ufhopla
 * on 27/04/2022.
 */

@Service
public class FireStationService {

    @Autowired
    private FireStationRepository fireStationRepository;

    public FireStationService(final FireStationRepository fireStationRepository) {
        this.fireStationRepository = fireStationRepository;
    }

    public Iterable<FireStation> list() {
        return fireStationRepository.findAll();
    }

    public FireStation save(FireStation fireStation) {
        return fireStationRepository.save(fireStation);
    }

    public Iterable<FireStation> save(List<FireStation> fireStations) {
        return fireStationRepository.saveAll(fireStations);
    }

}
