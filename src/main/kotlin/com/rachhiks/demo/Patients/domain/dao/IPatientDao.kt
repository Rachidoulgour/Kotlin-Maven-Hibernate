package com.rachhiks.demo.Patients.services.domain.dao

import com.rachhiks.demo.Patients.services.domain.entities.Patient
import org.springframework.data.repository.CrudRepository
import java.util.*

interface IPatientDao: CrudRepository<Patient, Int> {
    public fun findBySip(sip:Long): Optional<Patient>
    public fun deleteBySip(sip: Long):Int
}