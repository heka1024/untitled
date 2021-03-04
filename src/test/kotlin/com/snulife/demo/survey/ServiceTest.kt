package com.snulife.demo.survey

import com.snulife.demo.survey.dto.OSCreateRequestDto
import com.snulife.demo.survey.model.OS
import com.snulife.demo.survey.model.SurveyResult
import com.snulife.demo.survey.model.enums.ExperienceDegree
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
  fun `저장 잘 되어야 함`() {
    // given
    val name = "우분투"
    val description = "오픈소스"
    val price = 3000

    val req = OSCreateRequestDto(name=name, description=description, price=price)
    val id = osService.save(req)

    // when
    println(osRepository.findAll())
    val os = osRepository.findAll()[0]

    // then
    then(os.id).isEqualTo(id)
    then(os.name).isEqualTo(name)
    then(os.price).isEqualTo(price)
    then(os.description).isEqualTo(description)
  }

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

@ExtendWith(MockitoExtension::class)
class SurveyServiceTest {
  @InjectMocks
  private val surveyService = SurveyService()

  @Mock
  private lateinit var surveyResultRepository: SurveyResultRepository

  @Test
  fun `간단한 설문 및 결과`() {
    // given
    val survey = SurveyResult(
      python = ExperienceDegree.VERY_LOW,
      rdb = ExperienceDegree.VERY_LOW,
      programming = ExperienceDegree.HIGH,
      major = "지역",
      grade = "2학년",
    )
    val xs = listOf(survey)

    given(surveyResultRepository.findAll()).willReturn(xs)

    // when
    val rs = surveyService.getAll()

    // then
    then(rs.size).isEqualTo(1)
    then(rs[0].python).isEqualTo(survey.python)
    then(rs[0].major).isEqualTo(survey.major)
  }

  @Test
  fun `os가 결합된 설문 및 결과`() {
    // given
    val os1 = OS(
      name = "우분투",
      description = "오픈소스",
    )

    val survey = SurveyResult(
      python = ExperienceDegree.VERY_LOW,
      rdb = ExperienceDegree.VERY_LOW,
      programming = ExperienceDegree.HIGH,
      major = "지역",
      grade = "2학년",
      os = os1,
    )
    val xs = listOf(survey)

    given(surveyResultRepository.findAll()).willReturn(xs)

    // when
    val rs = surveyService.getAll()

    // then
    then(rs.size).isEqualTo(1)
    then(rs[0].python).isEqualTo(survey.python)
    then(rs[0].major).isEqualTo(survey.major)
    then(rs[0].os).isEqualTo(os1)
  }
}