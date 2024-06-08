package EmployeeManagement.demo.service;

import EmployeeManagement.demo.model.User;
import EmployeeManagement.demo.model.UserTemplate;
import EmployeeManagement.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public User register(UserTemplate ut) {
        User user = new User();
        user.setUsername(ut.getUsername());
        user.setPassword(passwordEncoder.encode(ut.getPassword()));
        user.setAddress(ut.getAddress());

        userRepository.save(user);

        // login
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        ut.getUsername(), ut.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authenticate);

        return user;
    }
}
