package my_daily_feed.dto;

import lombok.Getter;
import lombok.Setter;
import my_daily_feed.domain.Feed;

import java.util.List;

@Getter
@Setter
public class FeedDto {
    private String title;
    private List<String> RSS_URL;

    public FeedDto(String title, List<String> RSS_URL) {
        this.title = title;
        this.RSS_URL = RSS_URL;
    }

    public Feed _toFeed(){
        return new Feed(this.title, this.RSS_URL);
    }
}
