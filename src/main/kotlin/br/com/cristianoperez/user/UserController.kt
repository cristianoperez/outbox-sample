package br.com.cristianoperez.user

import org.springframework.context.ApplicationEventPublisher
import org.springframework.http.HttpStatus.CREATED
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class UserController(val userRepository: UserRepository,
                     val applicationEventPublisher: ApplicationEventPublisher) {

    @PostMapping("/users")
    @ResponseStatus(CREATED)
    @Transactional
    fun create(@RequestBody userCreateRequest: UserCreateRequest){
        val user = userCreateRequest.toUser()
        userRepository.save(user)
        applicationEventPublisher.publishEvent(UserCreatedEvent(user.firstname, user.lastname, LocalDateTime.now(), user.id!!))
    }

}

data class UserCreateRequest(val firstName: String, val lastName: String){
    fun toUser() = User(firstName, lastName)
}