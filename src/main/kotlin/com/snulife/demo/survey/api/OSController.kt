package com.snulife.demo.survey.api

import com.snulife.demo.survey.dto.OSResponseDto
import com.snulife.demo.survey.service.OSService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/os")
class OSController(private val osService: OSService) {
  @GetMapping("")
  fun getAll(): List<OSResponseDto> {
    return osService.getAll()
  }
}