package com.rachhiks.demo.Patients.services

import com.rachhiks.demo.Patients.services.domain.entities.Patient
import java.util.*

interface IPatientService {
    fun getPatients():List<Patient>
    fun addPatient(patient:Patient):Patient
    fun getPatientById(id: Int): Optional<Patient>
    fun getPatientBySip(sip:Long): Optional<Patient>
    fun deletePatientBySip(sip: Long): Boolean
}