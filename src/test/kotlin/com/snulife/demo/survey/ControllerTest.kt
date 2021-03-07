package com.snulife.demo.survey

import com.snulife.demo.survey.dto.OSCreateRequestDto
import com.snulife.demo.survey.dto.OSResponseDto
import com.snulife.demo.survey.repository.OSRepository
import com.snulife.demo.survey.repository.SurveyResultRepository
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest(
  @Autowired val restTemplate: TestRestTemplate,
  @Autowired val osRepository: OSRepository,
  @Autowired val surveyResultRepository: SurveyResultRepository) {

  @Test
  fun `모든 OS 가져오기`() {
    val entity = restTemplate.getForEntity<List<OSResponseDto>>("/os/")
    then(entity.statusCode).isEqualTo(HttpStatus.OK)
  }

  @Test
  fun `Os가 잘 등록된다`() {
    val name = "name"
    val description = "description"
    val req = OSCreateRequestDto(name=name, description=description, price = null)

    val x = restTemplate.postForEntity("/os/", req, String::class.java)

    println(x)

    then(x.statusCode).isEqualTo(HttpStatus.CREATED)
  }

}