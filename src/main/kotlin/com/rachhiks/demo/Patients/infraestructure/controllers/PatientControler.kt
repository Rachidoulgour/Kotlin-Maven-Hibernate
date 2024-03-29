package com.rachhiks.demo.Patients.services.controllers

import com.rachhiks.demo.Patients.services.domain.entities.Patient
import com.rachhiks.demo.Patients.services.IPatientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("api/v1")
class PatientControler {

    @Autowired
    private lateinit var patientService: IPatientService

    @RequestMapping("hello")
    fun helloWorld(): ResponseEntity<Unit> {
        return ResponseEntity<Unit>(HttpStatus.OK);
    }

    @RequestMapping("patients", "GET", "application/json")
    fun getPatients(): ResponseEntity<List<Patient>> {
        val list: List<Patient> = patientService.getPatients()
        return ResponseEntity(list, HttpStatus.OK)
    }
        /*fun getPatients(): ResponseEntity<List<Patient>> = ResponseEntity(patientService.getPatients(), HttpStatus.OK)*/
    @PostMapping("patients")
    fun addPatient(@RequestBody patient: Patient):ResponseEntity<Patient>{
            val result:Patient = patientService.addPatient(patient)
            return when(result){
                null -> ResponseEntity(result, HttpStatus.BAD_REQUEST)
                else -> ResponseEntity(result, HttpStatus.CREATED)
            }
        }
    @GetMapping("patient/(id")
    fun getPatientById(@PathVariable id: Int):ResponseEntity<Patient>{
        val result:Optional<Patient> = patientService.getPatientById(id)
        return result.map{res-> ResponseEntity(res, HttpStatus.OK)}
                .orElse(ResponseEntity(HttpStatus.NO_CONTENT))
    }
    @GetMapping("patients/sip/{sip}")
    fun getPatientBySip(@PathVariable sip: Long):ResponseEntity<Patient>{
        val result:Optional<Patient> = patientService.getPatientBySip(sip)
        return result.map{res-> ResponseEntity(res, HttpStatus.OK)}
                .orElse(ResponseEntity(HttpStatus.NO_CONTENT))
    }
    @DeleteMapping("patients/sip/{sip}")
    fun deletePatientBySip(@PathVariable sip: Long):ResponseEntity<Boolean>{
        val result:Boolean = patientService.deletePatientBySip(sip)
        if (result) return ResponseEntity(result, HttpStatus.OK)
        return ResponseEntity(false, HttpStatus.NOT_FOUND)
    }

}