package com.immigration.consult.person.controller

import com.immigration.consult.person.entity.Job
import com.immigration.consult.person.repository.JobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/insertAll")
class InsertAll {

    @Autowired
    lateinit var jobRepository: JobRepository

    @GetMapping
    fun createObjs(){

        val job1 = Job("Vaga 01", "Cargo 01", "Empresa 01", "Cidade 01", "Estado 01")
        val job2 = Job("Vaga 02", "Cargo 02", "Empresa 02", "Cidade 02", "Estado 02")
        val job3 = Job("Vaga 03", "Cargo 03", "Empresa 03", "Cidade 03", "Estado 03")
        val job4 = Job("Vaga 04", "Cargo 04", "Empresa 04", "Cidade 04", "Estado 04")
        val job5 = Job("Vaga 05", "Cargo 05", "Empresa 05", "Cidade 05", "Estado 05")
        val job6 = Job("Vaga 06", "Cargo 06", "Empresa 06", "Cidade 06", "Estado 06")
        val job7 = Job("Vaga 07", "Cargo 07", "Empresa 07", "Cidade 07", "Estado 07")
        val job8 = Job("Vaga 08", "Cargo 08", "Empresa 08", "Cidade 08", "Estado 08")
        val job9 = Job("Vaga 09", "Cargo 09", "Empresa 09", "Cidade 09", "Estado 09")

        jobRepository.save(job1)
        jobRepository.save(job2)
        jobRepository.save(job3)
        jobRepository.save(job4)
        jobRepository.save(job5)
        jobRepository.save(job6)
        jobRepository.save(job7)
        jobRepository.save(job8)
        jobRepository.save(job9)
    }

}