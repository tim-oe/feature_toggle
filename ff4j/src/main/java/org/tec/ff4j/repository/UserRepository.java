package org.tec.ff4j.repository;

import org.springframework.data.repository.CrudRepository;
import org.tec.ff4j.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
