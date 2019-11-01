package br.com.cristianoperez.user

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(val firstname: String, val lastname: String){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}