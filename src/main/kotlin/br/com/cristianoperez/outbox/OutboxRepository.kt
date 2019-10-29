package br.com.cristianoperez.outbox

import org.springframework.data.repository.CrudRepository

interface OutboxRepository: CrudRepository<Outbox, Long>
