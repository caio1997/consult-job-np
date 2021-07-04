package com.immigration.consult.person.service

import com.immigration.consult.person.entity.Job
import com.immigration.consult.person.exception.GeneralException
import com.immigration.consult.person.repository.JobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FindJobService {

    @Autowired
    lateinit var jobRepository: JobRepository

    fun findAll(): MutableIterable<Job> {
        val jobs = jobRepository.findAll()
        if(jobs.count() == 0){
            throw GeneralException("Nenhum registro foi encontrado!")
        } else {
            return jobs
        }
    }

}