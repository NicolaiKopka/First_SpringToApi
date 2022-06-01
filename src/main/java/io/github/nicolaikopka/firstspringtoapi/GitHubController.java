package io.github.nicolaikopka.firstspringtoapi;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("github")
public class GitHubController {

    private final GitRepoService gitRepoService;

    public GitHubController(GitRepoService gitRepoService) {
        this.gitRepoService = gitRepoService;
    }

    @GetMapping("{user}")
    public GitRepo[] getGitRepos(@PathVariable String user){
        return gitRepoService.getRepo(user);


//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<GitRepo[]> result = restTemplate.getForEntity("https://api.github.com/users/" + user + "/repos", GitRepo[].class);
//        return result.getBody();


//        return restTemplate.getForObject("https://api.github.com/users/" + user + "/repos", GitRepo[].class);

    }
}
