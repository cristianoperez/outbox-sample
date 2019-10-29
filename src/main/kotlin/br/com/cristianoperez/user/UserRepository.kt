package br.com.cristianoperez.user

import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long>