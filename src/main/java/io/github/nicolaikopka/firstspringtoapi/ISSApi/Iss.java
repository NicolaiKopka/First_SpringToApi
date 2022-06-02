package io.github.nicolaikopka.firstspringtoapi.ISSApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Iss {

    private String message;
    private long timestamp;
    @JsonProperty("iss_position")
    private ISSPos issPos;

}
