package org.tec.ff4j.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.tec.ff4j.App;
import org.tec.ff4j.auth.Role;
import org.tec.ff4j.entity.RoleEntity;
import org.tec.ff4j.entity.UserEntity;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes={App.class})
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    @Transactional
    public void testRead() {
        Optional<UserEntity> opt = userRepository.findByUsername("admin");

        Assumptions.assumeTrue(opt.isPresent());

        UserEntity actual = opt.get();

        Assertions.assertFalse(actual.getRoles().isEmpty());
    }

    @Test
    @Transactional
    public void testWrite() {
        UserEntity actual = new UserEntity();

        actual.setUsername("user@" + System.currentTimeMillis());
        actual.setPassword(passwordEncoder.encode("password"));
        actual.setEnabled(true);

        RoleEntity re = new RoleEntity();
        re.setRole(Role.ROLE_ANONYMOUS);
        re.setUser(actual);

        List<RoleEntity> roles = new ArrayList<>(Arrays.asList(re));
        actual.setRoles(roles);

        userRepository.save(actual);

        Optional<UserEntity> opt = userRepository.findByUsername(actual.getUsername());

        Assumptions.assumeTrue(opt.isPresent());

        Assertions.assertEquals(actual, opt.get());
    }
}
