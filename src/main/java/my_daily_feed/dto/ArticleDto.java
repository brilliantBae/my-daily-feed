package my_daily_feed.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import my_daily_feed.domain.Article;

import java.util.Date;

@Getter
@Setter
public class ArticleDto {
    private String title;

    private Date pubDate;

    private String author;

    private String content;

    public ArticleDto(String title, Date pubDate, String author, String content) {
        this.title = title;
        this.pubDate = pubDate;
        this.author = author;
        this.content = content;
    }

    public Article _toArticle(){
        return new Article(this.title, this.pubDate, this.author, this.content);
    }

}
