package com.immigration.consult.person.repository

import com.immigration.consult.person.entity.Job
import org.springframework.data.repository.CrudRepository

interface JobRepository : CrudRepository<Job, Long> {
}