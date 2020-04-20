package com.test.demo.util;

import com.test.demo.model.User;
import com.test.demo.dto.user.UserDTO;
import org.modelmapper.ModelMapper;

public final class UserDTOMapper {

    private UserDTOMapper() {
    }

    private static final ModelMapper mapper = new ModelMapper();

    public static User map(UserDTO userDto) {
        return mapper.map(userDto, User.class);
    }

    public static UserDTO map(User user) {
        return mapper.map(user, UserDTO.class);
    }
}
