package com.ertikmen.config.security;



import com.ertikmen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetails implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserByUserRole(String role) throws UsernameNotFoundException {

     //   Optional<UserProfile> user=userService.findByAuthId(id);

            List<GrantedAuthority> authorityList=new ArrayList<>();
            authorityList.add(new SimpleGrantedAuthority(role));

            return User.builder()
                    .username(role)
                    .password("")
                    .accountLocked(false)
                    .accountExpired(false)
                    .authorities(authorityList)
                    .build();

    }
}
