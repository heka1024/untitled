package com.snulife.demo.survey

import com.snulife.demo.survey.model.OS
import com.snulife.demo.survey.repository.OSRepository
import com.snulife.demo.survey.repository.SurveyResultRepository
import com.snulife.demo.survey.service.OSService
import com.snulife.demo.survey.service.SurveyService
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class OSServiceTest {
  @InjectMocks
  private val osService = OSService()

  @Mock
  private lateinit var osRepository: OSRepository

  @Test
  fun `결과 생성`() {
    // given
    val os1 = OS(
      name = "우분투",
      description = "오픈소스",
    )
    val xs = listOf(os1)

    given(osRepository.findAll()).willReturn(xs)

    // when
    val rs = osService.getAll()

    // then
    then(rs.size).isEqualTo(1)
    then(rs[0].name).isEqualTo(os1.name)
    then(rs[0].description).isEqualTo(os1.description)
  }
}