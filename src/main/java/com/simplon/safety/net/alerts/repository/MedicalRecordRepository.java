package com.simplon.safety.net.alerts.repository;

import com.simplon.safety.net.alerts.model.MedicalRecord;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ufhopla
 * on 27/04/2022.
 */
public interface MedicalRecordRepository extends CrudRepository<MedicalRecord,Long> {
}
