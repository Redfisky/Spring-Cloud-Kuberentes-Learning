package china.nanjing.myssoauthorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Chen Hongyu
 */

@RestController
public class UserController {

    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/hello/sso")
    public Object hello() {
        return "hello spring security oauth2 sso - authorization";
    }



}
