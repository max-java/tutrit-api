package by.jrr.tutritapi.controller;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class AuthenticationController {

    @GetMapping("/myjwt")
    public String getCurrentUserJwt(Principal principal, HttpServletRequest request) {
        AccessToken accessToken;
        try {
            KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) principal;
            SimpleKeycloakAccount account = (SimpleKeycloakAccount) token.getDetails();
            KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) account.getPrincipal();
            KeycloakSecurityContext context = keycloakPrincipal.getKeycloakSecurityContext();
            accessToken = context.getToken();
            return accessToken.toString();
        } catch (Exception ex) {
            accessToken = new AccessToken();
            accessToken.setPreferredUsername("not Authorized");
        }
        return accessToken.toString();
    }
}
