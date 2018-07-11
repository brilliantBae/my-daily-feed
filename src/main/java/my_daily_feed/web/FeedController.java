package my_daily_feed.web;

import my_daily_feed.service.FeedService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeedController {
    @Resource(name= "feedService")
    private FeedService feedService;


}
