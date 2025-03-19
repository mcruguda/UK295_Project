package ch.csbe.uek295_boilerplate.resources.Users;

import ch.csbe.uek295_boilerplate.resources.Users.dto.LoginRequestDto;

public class UserServiceImpl {
    public LoginRequestDto getUserWithCredentials(LoginRequestDto loginRequestDto) {
        return loginRequestDto;
    }

    public String findUserByEmail(String email) {
        return email;
    }
}
