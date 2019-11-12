package com.rachhiks.demo.Patients.services.domain.entities

import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "patients")
data class Patient (
    @Id
    @GeneratedValue
    var id: Int?,
    var sip: Long?,
    var name: String?,
    var lastname: String?,
    @NotNull
    var created_at: LocalDateTime=LocalDateTime.now(),
    var updated_at: LocalDateTime?
)
