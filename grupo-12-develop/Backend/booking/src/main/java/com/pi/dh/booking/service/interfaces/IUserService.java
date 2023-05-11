package com.pi.dh.booking.service.interfaces;

import com.pi.dh.booking.dto.UserDTO;
import com.pi.dh.booking.model.UserEntity;

import java.util.List;

public interface IUserService {

    String createUser(UserDTO userDTO);

}
