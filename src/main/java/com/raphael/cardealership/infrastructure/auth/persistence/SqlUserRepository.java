package com.raphael.cardealership.infrastructure.auth.persistence;

import com.raphael.cardealership.infrastructure.auth.entity.User;
import com.raphael.cardealership.infrastructure.auth.exception.DuplicateEmailException;
import com.raphael.cardealership.infrastructure.auth.usecase.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class SqlUserRepository implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    @Override
    public Optional<User> findByEmail(final String email) {
        return jpaUserRepository.findByEmail(email).map(UserEntity::toDomain);
    }

    @Override
    public User save(final User user) {
        UserEntity entity = UserEntity.fromDomain(user);

        try {
            return jpaUserRepository.save(entity).toDomain();
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException("This email is already being used.", e);
        }
    }
}
