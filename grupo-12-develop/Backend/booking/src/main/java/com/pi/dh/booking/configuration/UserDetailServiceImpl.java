package com.pi.dh.booking.configuration;

import com.pi.dh.booking.model.UserEntity;
import com.pi.dh.booking.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private IUserRepository userRepository;

    public UserDetailServiceImpl(IUserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity usuario = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email: " + email + " no existe."));

        return new UserDetailsImpl(usuario);
    }
}
