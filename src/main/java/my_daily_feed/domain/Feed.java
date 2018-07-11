package my_daily_feed.domain;

import lombok.Getter;
import lombok.Setter;
import my_daily_feed.dto.FeedDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="feed")
public class Feed {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    public Feed(){}

    public Feed(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Feed(String title){
        this(0L, title);
    }

    public FeedDto _toFeedDto(){
        return new FeedDto(this.title);
    }
}
