package com.snulife.demo.survey

import com.snulife.demo.survey.model.OS
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
  fun `운영체제 저장 및 불러오기`() {
    // given
    val os = OS(description = "description", name = "ubuntu", price = 3000)
    osRepository.save(os)

    // when
    val osList = osRepository.findAll()

    // then
    val get = osList.get(0)
    then(get.name).isEqualTo(os.name)
    then(get.description).isEqualTo(os.description)
    then(get.price).isEqualTo(os.price)
  }

}