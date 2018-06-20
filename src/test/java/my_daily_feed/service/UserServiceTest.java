package my_daily_feed.service;

import org.junit.Test;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.*;
@Transactional
public class UserServiceTest {
    
    @Resource(name="userService")
    private UserService userService;

    @Test
    public void name() {
    }
}