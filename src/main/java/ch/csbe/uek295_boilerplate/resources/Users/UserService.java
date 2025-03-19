package ch.csbe.uek295_boilerplate.resources.Users;

import ch.csbe.uek295_boilerplate.resources.Users.dto.LoginRequestDto;

public interface UserService {
    LoginRequestDto getUserWithCredentials(LoginRequestDto loginRequestDto);
    String findUserByEmail(String email);
}
