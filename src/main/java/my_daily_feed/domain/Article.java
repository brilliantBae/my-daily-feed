package my_daily_feed.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import my_daily_feed.dto.ArticleDto;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date pubDate;

    @Column(nullable = false)
    private String author;

    @Lob
    private String content;

    public Article(){}

    private Article(Long id, String title, Date pubDate, String author, String content) {
        this.id = id;
        this.title = title;
        this.pubDate = pubDate;
        this.author = author;
        this.content = content;
    }

    public Article(String title, Date pubDate, String author, String content) {
        this(0L, title, pubDate, author, content);
    }

    public ArticleDto _toArticleDto(){
        return new ArticleDto(this.title, this.pubDate, this.author, this.content);
    }
}
