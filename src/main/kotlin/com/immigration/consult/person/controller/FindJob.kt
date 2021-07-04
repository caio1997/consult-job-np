package com.immigration.consult.person.controller

import com.immigration.consult.person.entity.Job
import com.immigration.consult.person.exception.GeneralException
import com.immigration.consult.person.service.FindJobService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/get")
class FindJob {

    @Autowired
    lateinit var findJobService: FindJobService

    @GetMapping
    fun findAll():ResponseEntity<Any>{
        return try {
            ResponseEntity.ok().body(findJobService.findAll())
        } catch (e: GeneralException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    @GetMapping("/filter")
    fun findFilter(
            @RequestParam(value = "vaga", required = false) vaga: String?,
            @RequestParam(value = "cargo", required = false) cargo: String?,
            @RequestParam(value = "empresa", required = false) empresa: String?,
            @RequestParam(value = "cidade", required = false) cidade: String?,
            @RequestParam(value = "estado", required = false) estado: String?
    ): Any? {

        return try {

            val jobFilter = Job(vaga, cargo, empresa, cidade, estado)

            val jobs: List<Job?>? = findJobService.findWithFilter(jobFilter)
            ResponseEntity.ok<List<Job>>(jobs as List<Job>?)

        } catch (e: GeneralException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    @PostMapping
    fun save(@RequestBody job: Job): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok().body(findJobService.save(job))
        } catch (e: GeneralException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long):ResponseEntity<Any>{

        return try {
            val responseFindById = findJobService.findById(id)
            ResponseEntity.ok().body(responseFindById)
        } catch (e: GeneralException) {
            ResponseEntity.badRequest().body(e.message)
        }

    }
}