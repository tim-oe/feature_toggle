package org.tec.togglz.repository;

import org.springframework.data.repository.CrudRepository;
import org.tec.togglz.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
