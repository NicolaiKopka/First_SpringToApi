package io.github.nicolaikopka.firstspringtoapi.GitHubApi;


import io.github.nicolaikopka.firstspringtoapi.GitHubApi.GitRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class GitRepoService {

    public List<GitRepo> getRepo(String user) {
        RestTemplate restTemplate = new RestTemplate();
        GitRepo[] result = restTemplate.getForObject("https://api.github.com/users/" + user + "/repos", GitRepo[].class);
        assert result != null;
        return Arrays.stream(result)
                .toList();

    }

}
