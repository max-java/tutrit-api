package by.jrr.tutritapi.controller;

import by.jrr.tutritapi.model.HomeResponse;
import by.jrr.tutritapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/home")
    public HomeResponse getHomePage() {
        String title;
        try {
            title = userRepository.findAll().get(0).getName();
        } catch (Exception ex) {
            title = "Database not connected";
        }
        return new HomeResponse(title);
    }
}
