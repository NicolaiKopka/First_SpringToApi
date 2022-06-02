package io.github.nicolaikopka.firstspringtoapi;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GitRepo {

    private String name;
    private String description;

}
