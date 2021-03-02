package com.snulife.demo.survey

import com.snulife.demo.survey.repository.SurveyResultRepository
import com.snulife.demo.survey.service.SurveyService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ServiceTest {
  @InjectMocks
  private val surveyService = SurveyService()

  @Mock
  private lateinit var surveyResultRepository: SurveyResultRepository

  @Test
  fun `결과 생성`() {
    // TODO

  }


}