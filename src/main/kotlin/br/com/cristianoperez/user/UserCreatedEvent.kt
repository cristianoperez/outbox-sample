package br.com.cristianoperez.user

import br.com.cristianoperez.infra.ApplicationEvent
import java.time.LocalDateTime

data class UserCreatedEvent(val firstName: String, val lastName: String, val createdAt: LocalDateTime, override val id: Long): ApplicationEvent {
    override val aggregateType: String = "User"
}