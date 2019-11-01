package br.com.cristianoperez.outbox

import br.com.cristianoperez.infra.ApplicationEvent
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.*

@Component
class OutboxEventListner(private val outboxRepository: OutboxRepository,
                         private val objectMapper: ObjectMapper) {


    @EventListener
    fun outboxListner(applicationEvent: ApplicationEvent) {
        val outbox = Outbox(
                applicationEvent.id,
                applicationEvent.aggregateType,
                applicationEvent.javaClass.simpleName,
                objectMapper.writeValueAsString(applicationEvent),
                Date().time
        )
        outboxRepository.save(outbox)
    }
}
