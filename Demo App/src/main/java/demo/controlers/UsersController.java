package demo.controlers;

import demo.data.user.User;
import demo.data.user.UserCredentials;
import demo.api.services.UsersService;
import demo.data.user.UserForUpdate;
import demo.data.user.UserToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public Collection<User> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping("is_valid")
    public boolean isUserValid(@RequestBody UserToken userToken) {
        return usersService.isUserTokenValid(userToken);
    }

    @GetMapping("/id")
    public User getUser(HttpServletRequest request) {
        return usersService.getUser(request);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        usersService.registerUser(user);
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody UserForUpdate userForUpdate, HttpServletRequest request) {
        usersService.updateUser(userForUpdate, request);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserCredentials userCredentials) {
        return usersService.login(userCredentials);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody UserToken userToken) {
        usersService.logout(userToken);
    }
}