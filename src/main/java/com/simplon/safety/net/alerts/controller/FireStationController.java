package com.simplon.safety.net.alerts.controller;

import com.simplon.safety.net.alerts.model.FireStation;
import com.simplon.safety.net.alerts.repository.FireStationRepository;
import com.simplon.safety.net.alerts.service.FireStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ufhopla
 * on 27/04/2022.
 */

@RestController
@RequestMapping("/firestations")
class FireStationController {

    @Autowired
    private FireStationService fireStationService;

    @Autowired
    private FireStationRepository fireStationRepository;

    public FireStationController(final FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    @GetMapping("/list")
    public Iterable<FireStation> list() {
        return fireStationService.list();
    }

    @PostMapping("/add")
    FireStation newFireStation(@RequestBody FireStation newFireStation) {
        return fireStationRepository.save(newFireStation);
    }

}
