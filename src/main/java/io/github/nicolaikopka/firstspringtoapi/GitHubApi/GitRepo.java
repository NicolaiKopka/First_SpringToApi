package io.github.nicolaikopka.firstspringtoapi.GitHubApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GitRepo {

    private String name;
    private String description;

}
