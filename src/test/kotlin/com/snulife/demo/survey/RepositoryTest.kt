package com.snulife.demo.survey

import com.snulife.demo.survey.model.OS
import com.snulife.demo.survey.model.SurveyResult
import com.snulife.demo.survey.model.enums.ExperienceDegree
import com.snulife.demo.survey.repository.OSRepository
import com.snulife.demo.survey.repository.SurveyResultRepository
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
class RepositoryTest(@Autowired val surveyResultRepository: SurveyResultRepository,
                     @Autowired val osRepository: OSRepository) {
  @AfterEach
  fun cleanup() {
    surveyResultRepository.deleteAll()
    osRepository.deleteAll()
  }

  @Test
  fun `조사 결과 저장 및 불러오기`() {
    // given
    val data = SurveyResult(
      python = ExperienceDegree.VERY_LOW,
      rdb = ExperienceDegree.VERY_LOW,
      programming = ExperienceDegree.HIGH,
      major = "지역",
      grade = "2학년",
    )
    surveyResultRepository.save(data)

    // when
    val s = surveyResultRepository.findAll().get(0)

    // then
    then(s.grade).isEqualTo(data.grade)
    then(s.major).isEqualTo(data.major)
  }

  @Test
  fun `운영체제 저장 및 불러오기`() {
    // given
    val os = OS(description = "description", name = "ubuntu", price = 3000)
    osRepository.save(os)

    // when
    val osList = osRepository.findAll()

    // then
    val get = osList[0]
    then(get.name).isEqualTo(os.name)
    then(get.description).isEqualTo(os.description)
    then(get.price).isEqualTo(os.price)
  }

  @Test
  fun `통합 테스트`() {
    val osInit = OS(description = "description", name = "ubuntu", price = 3000)
    osRepository.save(osInit)

    val os = osRepository.findAll().get(0)

    val data = SurveyResult(
      os = os,
      python = ExperienceDegree.VERY_LOW,
      rdb = ExperienceDegree.VERY_LOW,
      programming = ExperienceDegree.HIGH,
      major = "지역",
      grade = "2학년",
    )
    surveyResultRepository.save(data)

    // when
    val s = surveyResultRepository.findAll()[0]

    // then
    then(s.grade).isEqualTo(data.grade)
    then(s.major).isEqualTo(data.major)
    then(s.os).isEqualTo(os)
  }
}