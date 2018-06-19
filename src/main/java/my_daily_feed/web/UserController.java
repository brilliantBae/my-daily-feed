package my_daily_feed.web;

import my_daily_feed.dto.UserDto;
import my_daily_feed.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/users")
public class UserController {

    @Resource(name="userService")
    private UserService userService;

    @GetMapping("/form")
    public String index(){
        return "/user/index";
    }

    @PostMapping("")
    public String create(UserDto userDto){
        userService.save(userDto);
        return "redirect:/";
    }
}
