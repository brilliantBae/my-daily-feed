package my_daily_feed.web;

import my_daily_feed.dto.UserDto;
import my_daily_feed.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;
import support.test.HtmlFormDataBuilder;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserAcceptanceTest {
    private static final Logger log = LoggerFactory.getLogger(UserAcceptanceTest.class);
    
    @Autowired
    private TestRestTemplate template;

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Test
    public void createForm() {
        ResponseEntity<String> response = template.getForEntity("/users/form", String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        log.debug("body: {}", response.getBody());
    }

    @Test
    public void create() {
        String email = "jwb8705@gmail.com";

        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("email", email).addParameter("password", "password").addParameter("name", "지원이")
                .build();
        ResponseEntity<String> response = template.postForEntity("/users", request, String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.FOUND));
        assertThat(response.getHeaders().getLocation().getPath(), is("/"));
        assertNotNull(userRepository.findByEmail(email));
    }

    @Test
    public void login_success() throws Exception {
        String correctEmail = "jwb8705@gmail.com";

        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("email", correctEmail).addParameter("password", "password1").build();

        ResponseEntity<String> response = template.postForEntity("/users/login", request, String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.FOUND));
        assertTrue(response.getHeaders().getLocation().getPath().startsWith("/"));
        log.debug("body : {}", response.getBody());
    }

//    @Test
//    public void login_fail() throws Exception {
//        String wrongEmail = "wrong@gmail.com";
//
//        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder.urlEncodedForm()
//                .addParameter("email", wrongEmail).addParameter("password", "test").build();
//
//        ResponseEntity<String> response = template.postForEntity("/users/login", request, String.class);
//
//        assertThat(response.getStatusCode(), is(HttpStatus.OK));
//        log.debug("body : {}", response.getBody());
//        String body = response.getBody();
//        assertTrue(body.contains("아이디 또는 비밀번호가 다릅니다."));
//    }
}