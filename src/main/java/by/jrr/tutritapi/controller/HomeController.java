package by.jrr.tutritapi.controller;

import by.jrr.tutritapi.model.HomeResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

    @GetMapping("/home")
    public HomeResponse getHomePage() {
        return new HomeResponse("Курсы:");
    }
}
