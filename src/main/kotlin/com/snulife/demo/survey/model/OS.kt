package com.snulife.demo.survey.model
import javax.persistence.*

@Entity
@Table(name = "os",
  indexes = [Index(name = "os_name_index", columnList = "name", unique = false)])
data class OS(
  @Column(name = "name", nullable = false)
  var name: String,

  @Column(name = "description", nullable = false)
  var description: String,

  @Column(name = "price", nullable = true)
  var price: Int? = null,

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null,
)

