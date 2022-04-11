package com.example.qcm.service;

import com.example.qcm.repository.UserRepository;
import com.example.qcm.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username " + username + " not found"));

        return user;
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        user
//                .getRoleList()
//                .forEach(r -> grantedAuthorities.add(new SimpleGrantedAuthority(r.getName().name())));
//
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                user.getPassword(),
//                grantedAuthorities
//        );


    }
}
