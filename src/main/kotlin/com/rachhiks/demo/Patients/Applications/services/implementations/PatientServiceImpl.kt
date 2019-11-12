package com.rachhiks.demo.Patients.services.implementations

import com.rachhiks.demo.Patients.services.domain.dao.IPatientDao
import com.rachhiks.demo.Patients.services.domain.entities.Patient
import com.rachhiks.demo.Patients.services.IPatientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*


@Service
class PatientServiceImpl: IPatientService {

    @Autowired

    private lateinit var patientDao: IPatientDao

    override fun addPatient(patient: Patient): Patient = patientDao.save(patient)
    @Transactional
    override fun getPatients(): List<Patient> = patientDao.findAll() as List<Patient>

    override fun getPatientById(id: Int): Optional <Patient>{
        var result =  patientDao.findById(id)
        return result
    }

    override fun getPatientBySip(sip: Long): Optional<Patient> = patientDao.findBySip(sip)

    override fun deletePatientBySip(sip: Long):Boolean{
        try{
            if(patientDao.deleteBySip(sip)>=1) return true
            return false
        } catch(e: Exception){
            return false
        }
    }


}