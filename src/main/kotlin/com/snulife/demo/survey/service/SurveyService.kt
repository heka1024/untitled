package com.snulife.demo.survey.service

import com.snulife.demo.survey.dto.SurveyResponseDto
import com.snulife.demo.survey.repository.SurveyResultRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class SurveyService {
  @Autowired
  private lateinit var surveyResultRepository: SurveyResultRepository

  @Transactional
  fun getAll(): List<SurveyResponseDto> {
    return surveyResultRepository.findAll().map { SurveyResponseDto(it) }
  }
}