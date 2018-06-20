package my_daily_feed.web;

import my_daily_feed.domain.User;
import my_daily_feed.dto.UserDto;
import my_daily_feed.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

    @PostMapping("/login")
    public String login(String email, String password, HttpSession session, Model model){
        User user = userService.findByEmail(email);
        session.setAttribute("loginUser", user);
        return "redirect:/";
    }
}
