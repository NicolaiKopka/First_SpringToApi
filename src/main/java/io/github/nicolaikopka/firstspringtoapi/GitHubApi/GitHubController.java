package io.github.nicolaikopka.firstspringtoapi.GitHubApi;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
