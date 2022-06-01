package io.github.nicolaikopka.firstspringtoapi;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitRepoService {

    public GitRepo[] getRepo(String user) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GitRepo[]> result = restTemplate.getForEntity("https://api.github.com/users/" + user + "/repos", GitRepo[].class);
        return result.getBody();
    }

}
