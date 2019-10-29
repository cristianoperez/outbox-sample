package br.com.cristianoperez.outbox

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Outbox(
        val aggregateRoot: String,
        val eventType: String,
        val payload: String)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}