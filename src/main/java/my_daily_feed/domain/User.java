package my_daily_feed.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Email
    private String email;

    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 20)
    private String password;

    @Size(min = 3, max = 20)
    @Column(unique = true, nullable = false, length = 20)
    private String name;

    public User(){}
    private User(Long id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public User(String email, String password, String name) {
        this(0L, email, password, name);
    }


}
