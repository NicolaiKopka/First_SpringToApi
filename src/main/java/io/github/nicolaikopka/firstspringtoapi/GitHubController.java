package io.github.nicolaikopka.firstspringtoapi;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("github")
@RequiredArgsConstructor
public class GitHubController {

    private final GitRepoService gitRepoService;

    @GetMapping("{user}")
    public List<GitRepo> getGitRepos(@PathVariable String user){
        List<GitRepo> gitRepos = gitRepoService.getRepo(user);

        for (GitRepo repo: gitRepos) {
            System.out.println(repo.toString());
        }
        return gitRepos;

    }
}
