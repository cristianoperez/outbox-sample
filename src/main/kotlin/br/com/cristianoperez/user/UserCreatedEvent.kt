package br.com.cristianoperez.user

import br.com.cristianoperez.infra.ApplicationEvent
import java.time.LocalDateTime

data class UserCreatedEvent(val firstName: String, val lastName: String, val createdAt: LocalDateTime): ApplicationEvent {
    override fun aggregateRoot() = "User"
}