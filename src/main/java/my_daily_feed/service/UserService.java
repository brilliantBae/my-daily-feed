package my_daily_feed.service;

import my_daily_feed.domain.User;
import my_daily_feed.dto.UserDto;
import my_daily_feed.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Resource(name = "userRepository")
    private UserRepository userRepository;

    public User save(UserDto userDto){
        return userRepository.save(userDto._toUser());
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }

}
