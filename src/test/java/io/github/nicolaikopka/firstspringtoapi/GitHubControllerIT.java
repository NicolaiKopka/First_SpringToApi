package io.github.nicolaikopka.firstspringtoapi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GitHubControllerIT {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void caseGetListOfNames() {
        ResponseEntity<GitRepo[]> response = testRestTemplate.getForEntity("/github/NicolaiKopka", GitRepo[].class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).length).isEqualTo(19);
        Assertions.assertThat(response.getBody()[1].getName()).isEqualTo("Blog_Test");
        Assertions.assertThat(response.getBody()[2].getDescription()).isNull();
    }

}