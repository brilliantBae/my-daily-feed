package my_daily_feed.dto;

import lombok.Getter;
import lombok.Setter;
import my_daily_feed.domain.Feed;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class FeedDto {
    private String title;


    public FeedDto(String title) {
        this.title = title;
    }

    public Feed _toFeed(){
        return new Feed(this.title);
    }
}
