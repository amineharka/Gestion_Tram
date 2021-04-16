package com.example.global.metier;

import com.example.global.dao.UserRepository;
import com.example.global.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository ;

    public User updateProfile(User user,Long id)
    {
        user.setId(id);
        return userRepository.save(user);
    }

}
