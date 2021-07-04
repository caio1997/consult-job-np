package com.immigration.consult.person.service

import com.immigration.consult.person.entity.Job
import com.immigration.consult.person.exception.GeneralException
import com.immigration.consult.person.repository.JobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher.StringMatcher
import java.util.*

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

    @Transactional(readOnly = true)
    fun findWithFilter(jobFilter: Job): List<Job?>? {
        try {
            val example = Example.of(jobFilter, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING))
            return jobRepository.findAll(example)
        } catch (e: GeneralException){
            throw GeneralException("O FILTRO NÃO FUNCIONOU CORRETAMENTE")
        }
    }

    fun save(job: Job) {
        jobRepository.save(job)
    }

    fun findById(id: Long): Optional<Job> {

        val productForId = jobRepository.findById(id)
        if(productForId.isPresent){
            return productForId
        } else {
            throw GeneralException("Vaga não encontrada")
        }
    }



}