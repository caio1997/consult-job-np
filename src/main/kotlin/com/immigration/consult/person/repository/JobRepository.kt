package com.immigration.consult.person.repository

import com.immigration.consult.person.entity.Job
import org.springframework.data.jpa.repository.JpaRepository

interface JobRepository : JpaRepository<Job, Long> {
}