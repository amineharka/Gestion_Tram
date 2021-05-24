package com.example.global.metier;

import com.example.global.dao.UserRepository;
import com.example.global.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository ;

    @Override
    public UserDetails loadUserByUsername(String gmail) throws UsernameNotFoundException {

        User user = userRepository.findByGmail(gmail);
        return new org.springframework.security.core.userdetails.User(user.getGmail(),user.getPassword(),new ArrayList<>());
    }
}
