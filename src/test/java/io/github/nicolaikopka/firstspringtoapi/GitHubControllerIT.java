package io.github.nicolaikopka.firstspringtoapi;

import io.github.nicolaikopka.firstspringtoapi.GitHubApi.GitRepo;
import io.github.nicolaikopka.firstspringtoapi.GitHubApi.GitRepoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GitHubControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private GitRepoService gitRepoService;

    @Test
    void caseGetListOfNames() {
        ResponseEntity<GitRepo[]> response = testRestTemplate.getForEntity("/github/NicolaiKopka", GitRepo[].class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).length).isEqualTo(19);
        Assertions.assertThat(response.getBody()[1].getName()).isEqualTo("Blog_Test");
        Assertions.assertThat(response.getBody()[2].getDescription()).isNull();
    }

    @Test
    void caseGetListOfNameWithMock() {
        GitRepo gitRepo1 = new GitRepo("repo1", "test");
        GitRepo gitRepo2 = new GitRepo("repo2", "test2");
        Mockito.when(gitRepoService.getRepo("NicolaiKopka")).thenReturn(List.of(gitRepo1, gitRepo2));
        ResponseEntity<GitRepo[]> response = testRestTemplate.getForEntity("/github/NicolaiKopka", GitRepo[].class);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).length).isEqualTo(2);
        Assertions.assertThat(response.getBody()[0].getName()).isEqualTo("repo1");
        Assertions.assertThat(response.getBody()[1].getDescription()).isEqualTo("test2");
    }

}