package my_daily_feed.service;

import my_daily_feed.repository.FeedRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Transactional
@Service
public class FeedService {
    @Resource(name = "feedRepository")
    private FeedRepository feedRepository;
}
