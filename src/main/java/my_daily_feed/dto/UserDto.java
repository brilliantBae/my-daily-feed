package my_daily_feed.dto;

import lombok.*;
import my_daily_feed.domain.User;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class UserDto {
    private String email;
    private String password;
    private String name;

    public UserDto(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public User _toUser(){
        return new User(this.email, this.password, this.name);
    }

}
