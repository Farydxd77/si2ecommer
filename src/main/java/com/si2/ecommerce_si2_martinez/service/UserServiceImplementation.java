package com.si2.ecommerce_si2_martinez.service;

import com.si2.ecommerce_si2_martinez.config.JwtProvider;
import com.si2.ecommerce_si2_martinez.exception.UserException;
import com.si2.ecommerce_si2_martinez.model.User;
import com.si2.ecommerce_si2_martinez.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;
    private JwtProvider jwtProvider;

    public UserServiceImplementation(JwtProvider jwtProvider, UserRepository userRepository) {
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long userId) throws UserException {

        Optional<User>user = userRepository.findById(userId);
        if(user.isPresent()) {
            return user.get();
        }
        throw new UserException("User not found with id " + userId);
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        String email = jwtProvider.getEmailFromToken(jwt);
        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UserException("User not found with email " + email);
        }

        return user;
    }
}
