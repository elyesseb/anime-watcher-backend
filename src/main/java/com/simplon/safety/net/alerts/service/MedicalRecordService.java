package com.simplon.safety.net.alerts.service;

import com.simplon.safety.net.alerts.model.MedicalRecord;
import com.simplon.safety.net.alerts.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ufhopla
 * on 27/04/2022.
 */

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(final MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public Iterable<MedicalRecord> list() {
        return medicalRecordRepository.findAll();
    }

    public MedicalRecord save(MedicalRecord medicalRecords) {
        return medicalRecordRepository.save(medicalRecords);
    }

    public Iterable<MedicalRecord> save(List<MedicalRecord> medicalRecords) {
        return medicalRecordRepository.saveAll(medicalRecords);
    }

}
