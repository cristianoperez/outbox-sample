package br.com.cristianoperez.outbox

import br.com.cristianoperez.infra.ApplicationEvent
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class OutboxEventListner(private val outboxRepository: OutboxRepository,
                         private val objectMapper: ObjectMapper) {


    @EventListener
    fun outboxListner(applicationEvent: ApplicationEvent) {
        val outbox = Outbox(applicationEvent.aggregateRoot(), applicationEvent.javaClass.simpleName, objectMapper.writeValueAsString(applicationEvent))
        outboxRepository.save(outbox)
    }
}
