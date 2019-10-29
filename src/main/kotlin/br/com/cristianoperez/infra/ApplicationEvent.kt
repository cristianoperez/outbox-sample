package br.com.cristianoperez.infra

interface ApplicationEvent{
    fun aggregateRoot(): String
}