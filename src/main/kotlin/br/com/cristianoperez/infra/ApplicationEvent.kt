package br.com.cristianoperez.infra

interface ApplicationEvent{
    val id: Long
    val aggregateType: String
}