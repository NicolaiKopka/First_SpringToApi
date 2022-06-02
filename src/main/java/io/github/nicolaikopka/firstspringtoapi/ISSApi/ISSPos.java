package io.github.nicolaikopka.firstspringtoapi.ISSApi;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ISSPos {

    private String longitude;
    private String latitude;
}
