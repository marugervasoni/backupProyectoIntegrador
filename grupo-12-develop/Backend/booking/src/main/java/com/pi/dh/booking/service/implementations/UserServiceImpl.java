package com.pi.dh.booking.service.implementations;

import com.pi.dh.booking.dto.UserDTO;
import com.pi.dh.booking.model.CityEntity;
import com.pi.dh.booking.model.UserEntity;
import com.pi.dh.booking.repository.IUserRepository;
import com.pi.dh.booking.service.interfaces.IUserService;
import com.pi.dh.booking.util.Constant;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public String createUser(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setLastname(userDTO.getLastname());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        System.out.println("Password encode: " + userEntity.getPassword());

        CityEntity city = new CityEntity();
        city.setId(userDTO.getCity().getId());

        userEntity.setCity(city);

        userRepository.save(userEntity);

        return Constant.SuccessResponse.USER_CREATED;
    }
}
