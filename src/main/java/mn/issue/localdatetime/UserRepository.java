package mn.issue.localdatetime;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.validation.Validated;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Validated
@JdbcRepository(dialect = Dialect.H2)
public interface UserRepository extends CrudRepository<UserEntity, String> {

    @NotNull
    Optional<User> findByName(@NotBlank @Nonnull String name);

    @Query("SELECT * FROM USER u where u.name = :name")
    Optional<User> findByNameWithQuery(@NotBlank @Nonnull String name);
}
