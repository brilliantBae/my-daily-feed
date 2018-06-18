package my_daily_feed.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3, max = 20)
    @Column(unique = true, nullable = false, length = 20)
    private String userId;

    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 20)
    private String password;

    @Size(min = 3, max = 20)
    @Column(unique = true, nullable = false, length = 20)
    private String name;

    private User(Long id, String userId, String password, String name) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
    }
    public User(String userId, String password, String name) {
        this(0L, userId, password, name);
    }
}
