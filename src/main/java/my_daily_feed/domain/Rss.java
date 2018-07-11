package my_daily_feed.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name ="rss")
public class Rss {

    @Id @GeneratedValue
    @Column(name="RSS_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String url;

    // Feed's PK field name = id
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "id"))
    private Feed feed;

    public Rss(){}

    public Rss(Long id, String name, String url, Feed feed) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.feed = feed;
    }

    public Rss(String name, String url, Feed feed) {
        this(0L, name, url, feed);
    }
}
