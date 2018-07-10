package my_daily_feed.domain;

import my_daily_feed.dto.FeedDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Feed {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private List<String> RSS_URL;

    public Feed(){}

    public Feed(Long id, String title, List<String> RSS_URL) {
        this.id = id;
        this.title = title;
        this.RSS_URL = RSS_URL;
    }

    public Feed(String title, List<String> RSS_URL ){
        this(0L, title, RSS_URL);
    }

    public FeedDto _toFeedDto(){
        return new FeedDto(this.title, this.RSS_URL);
    }
}
