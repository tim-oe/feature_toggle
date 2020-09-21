package org.tec.ff4j.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.tec.ff4j.entity.RoleEntity;
import org.tec.ff4j.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    List<RoleEntity> findByUser(UserEntity user, Sort sort);
}
