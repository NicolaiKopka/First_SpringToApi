package io.github.nicolaikopka.firstspringtoapi.ISSApi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("iss-loc")
@RequiredArgsConstructor
public class IssController {
    private final IssService issService;

    @GetMapping
    public Iss getLocation() {
        return issService.getLocation();
    }

}
