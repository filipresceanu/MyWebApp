package com.company.mywebapp.model.dto;

import com.company.mywebapp.model.User;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;


    public static UserDto from(User user)
    {
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }


}
