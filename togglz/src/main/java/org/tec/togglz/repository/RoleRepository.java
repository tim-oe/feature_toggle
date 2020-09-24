package org.tec.togglz.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.tec.togglz.entity.RoleEntity;
import org.tec.togglz.entity.UserEntity;

import java.util.List;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    List<RoleEntity> findByUser(UserEntity user, Sort sort);
}
