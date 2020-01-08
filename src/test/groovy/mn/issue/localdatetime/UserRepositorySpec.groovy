package mn.issue.localdatetime

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class UserRepositorySpec extends Specification {

    @Inject
    UserRepository userRepository

    void 'test LocalDateTime with finder'() {
        given:
        UserEntity userEntity = new UserEntity('ABC', name)
        userRepository.save(userEntity)

        when:
        Optional<User> optUserByName = userRepository.findByName(name)

        then:
        optUserByName.isPresent()
        optUserByName.get().dateCreated

        where:
        name = 'Iván'
    }

    void 'test LocalDateTime with query'() {
        given:
        UserEntity userEntity = new UserEntity('ABC', name)
        userRepository.save(userEntity)

        when:
        Optional<User> optUserWithQuery = userRepository.findByNameWithQuery(name)

        then:
        optUserWithQuery.isPresent()
        optUserWithQuery.get().dateCreated

        where:
        name = 'Iván'
    }
}
