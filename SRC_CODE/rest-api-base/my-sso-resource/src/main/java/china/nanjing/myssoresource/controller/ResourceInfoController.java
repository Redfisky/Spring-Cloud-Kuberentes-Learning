package china.nanjing.myssoresource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Chen Hongyu
 */
@RestController
public class ResourceInfoController {
    
    @GetMapping("/resource-info")
    @ResponseBody
    public Object personInfo() {
        return "Hello Spring Security SSO- Resource Server! ";
    }

    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }

}
