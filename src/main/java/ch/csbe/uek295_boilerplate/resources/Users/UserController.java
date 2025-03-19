package ch.csbe.uek295_boilerplate.resources.Users;

import ch.csbe.uek295_boilerplate.resources.Users.dto.LoginRequestDto;
import ch.csbe.uek295_boilerplate.resources.security.TokenService;
import ch.csbe.uek295_boilerplate.resources.security.TokenWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @PostMapping("login")
    public TokenWrapper login(@RequestBody LoginRequestDto loginRequestDto) {
        User user = this.userService.getUserWithCredentials(loginRequestDto);
        if (user != null) {
            TokenWrapper tokenWrapper = new TokenWrapper();
            String token = this.tokenService.generateToken(user);
            tokenWrapper.setToken(token);
            return tokenWrapper;
        } else {
            // Errorhandling.
            // Either return 401 or 400
            return null;
        }
    }
}
