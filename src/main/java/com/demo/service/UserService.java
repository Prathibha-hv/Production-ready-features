package com.demo.service;

import com.demo.dto.LoginDto;
import com.demo.dto.SignUpDto;
import com.demo.dto.UserDto;
import com.demo.entity.User;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private  UserDto userDto;
    private PasswordEncoder passwordEncoder;

    private ModelMapper mapper;


    public UserService(UserRepository userRepository,ModelMapper mapper,PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.mapper=mapper;
        this.passwordEncoder=passwordEncoder;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User not found with email "+username));
    }

    public UserDto signUp(SignUpDto signUpDto) {
        Optional<User> user =userRepository.findByEmail(signUpDto.getEmail());
        if(user.isPresent())
        {
            throw new BadCredentialsException("User with same email already exists "+userDto.getEmail());
        }
        User toBeCreated=mapper.map(signUpDto,User.class);
        toBeCreated.setPassword(passwordEncoder.encode(toBeCreated.getPassword()));
        User savedUser=userRepository.save(toBeCreated);
        return mapper.map(savedUser,UserDto.class);
    }


}
