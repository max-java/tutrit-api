package by.jrr.tutritapi.controller;

import by.jrr.tutritapi.model.HomeResponse;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

//request.getHeader("authorization")
@RestController
@CrossOrigin
public class HomeController {

    @GetMapping("/home")
    public HomeResponse getHomePage(HttpServletRequest request, Principal principal) {
        AccessToken accessToken;
        try {
            KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) principal;
            SimpleKeycloakAccount account = (SimpleKeycloakAccount) token.getDetails();
            KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) account.getPrincipal();
            KeycloakSecurityContext context = keycloakPrincipal.getKeycloakSecurityContext();
             accessToken = context.getToken();
            accessToken.getPreferredUsername();
//        return new HomeResponse(title);
        } catch (Exception ex) {
             accessToken = new AccessToken();
             accessToken.setPreferredUsername("not Authorized");

        }

        return new HomeResponse(accessToken.getPreferredUsername() +" \n" + request.getHeader("authorization"));
    }

    @GetMapping("/user")
    public Object getUserPage(HttpServletRequest request, Principal principal) {
        AccessToken accessToken;
        try {
            KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) principal;
            SimpleKeycloakAccount account = (SimpleKeycloakAccount) token.getDetails();
            KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) account.getPrincipal();
            KeycloakSecurityContext context = keycloakPrincipal.getKeycloakSecurityContext();
            accessToken = context.getToken();
        } catch (Exception ex) {
            accessToken = new AccessToken();
            accessToken.setPreferredUsername("not Authorized");
        }
        return new Object();
    }

    @GetMapping("/event")
    public HomeResponse getEventPage(HttpServletRequest request, Principal principal) {

        return new HomeResponse("Event Page");
    }




}
