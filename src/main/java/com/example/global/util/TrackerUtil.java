package com.example.global.util;

import com.example.global.dao.UserRepository;
import com.example.global.dao.VoyageurRepository;
import com.example.global.entities.CustomUserDetail;
import com.example.global.entities.User;
import com.example.global.entities.Voyageur;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TrackerUtil {
    private final UserRepository userRepository ;
    private final VoyageurRepository voyageurRepository ;

    public User getLoggedUser()
    {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        User user1 = userRepository.findByGmail(user.getUsername());
        return user1;

    }
    public Voyageur getLoggedVoyageur()
    {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Voyageur voyageur = voyageurRepository.findByGmail(user.getUsername());
        return voyageur ;

    }
}
