package com.example.global.metier;

import com.example.global.dao.UserRepository;
import com.example.global.entities.User;
import com.example.global.util.TrackerUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository ;
    private final TrackerUtil trackerUtil ;

    public User updateProfile(User user)
    {
        //user.setId(trackerUtil.getLoggedUser().getId());
        User updatedUser = userRepository.findByGmail(user.getGmail());
        updatedUser.setNom(user.getNom());
        updatedUser.setPrenom(user.getPrenom());
        updatedUser.setGmail(user.getGmail());
        updatedUser.setSexe(user.getSexe());
        updatedUser.setPhone(user.getPhone());
        updatedUser.setCin(user.getCin());
        updatedUser.setImageUrl(user.getImageUrl());

        return userRepository.save(updatedUser);
    }

    public User getCurrentUser() {
        return trackerUtil.getLoggedUser();
    }
}
