package io.github.nicolaikopka.firstspringtoapi.GitHubApi;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GitRepo {

    private String name;
    private String description;

}
