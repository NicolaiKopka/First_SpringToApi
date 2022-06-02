package io.github.nicolaikopka.firstspringtoapi.ISSApi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IssService {

    public Iss getLocation() {
        RestTemplate restTemplate = new RestTemplate();
        Iss iss = restTemplate.getForObject("http://api.open-notify.org/iss-now", Iss.class);
        assert iss != null;
        return iss;
    }
}
