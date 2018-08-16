package my_daily_feed.web;

import my_daily_feed.domain.Feed;
import my_daily_feed.service.FeedService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/feeds")
public class FeedController {
    @Resource(name= "feedService")
    private FeedService feedService;

    @PostMapping("")
    public Feed create(){
        return null;
    }

}
