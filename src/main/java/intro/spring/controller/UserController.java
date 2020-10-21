package intro.spring.controller;

import intro.spring.dto.UserResponseDto;
import intro.spring.model.User;
import intro.spring.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String putUsers() {
        userService.add(new User("Roma", "123", 27));
        userService.add(new User("Mila", "123", 26));
        userService.add(new User("Vadim", "123", 38));
        userService.add(new User("Sasha", "123", 28));
        return "The data successfully added to DB!";
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId) {
        return createUserDto(userService.getById(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.listUsers()
                .stream()
                .map(this::createUserDto)
                .collect(Collectors.toList());
    }

    private UserResponseDto createUserDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserId(user.getId());
        userResponseDto.setLogin(user.getLogin());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setAge(user.getAge());
        return userResponseDto;
    }
}
