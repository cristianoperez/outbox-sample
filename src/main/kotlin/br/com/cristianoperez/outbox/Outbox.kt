package br.com.cristianoperez.outbox

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Outbox(
        val aggregateid: Long,
        val aggregatetype: String,
        val type: String,
        val payload: String,
        val timestamp: Long)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}