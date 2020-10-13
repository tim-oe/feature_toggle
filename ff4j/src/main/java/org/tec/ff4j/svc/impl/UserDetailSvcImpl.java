package org.tec.ff4j.svc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tec.ff4j.entity.UserEntity;
import org.tec.ff4j.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailSvcImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> opt = userRepository.findByUsername(username);

        if (opt.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        UserEntity ue = opt.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        ue.getRoles()
                .forEach(e -> authorities.add(new SimpleGrantedAuthority(e.getRole().toString())));

        return User.withUsername(ue.getUsername())
                .password(ue.getPassword())
                .disabled(!ue.isEnabled())
                .authorities(authorities)
                .build();
    }
}