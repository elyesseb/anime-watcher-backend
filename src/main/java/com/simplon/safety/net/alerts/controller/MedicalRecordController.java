package com.simplon.safety.net.alerts.controller;

import com.simplon.safety.net.alerts.model.MedicalRecord;
import com.simplon.safety.net.alerts.repository.MedicalRecordRepository;
import com.simplon.safety.net.alerts.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ufhopla
 * on 27/04/2022.
 */

@RestController
@RequestMapping("/medicalRecords")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordController(final MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping("/list")
    public Iterable<MedicalRecord> list() {
        return medicalRecordService.list();
    }

    @PostMapping("/add")
    MedicalRecord newMedicalRecord(@RequestBody MedicalRecord newMedicalRecord) {
        return medicalRecordRepository.save(newMedicalRecord);
    }
}
