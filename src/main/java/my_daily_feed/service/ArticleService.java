package my_daily_feed.service;

import my_daily_feed.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
@Transactional
public class ArticleService {
    @Resource(name="articleRepository")
    private ArticleRepository articleRepository;


}
