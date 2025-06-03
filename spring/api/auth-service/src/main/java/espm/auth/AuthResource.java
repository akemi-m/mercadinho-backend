package espm.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthResource {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/login")
    public TokenOut login(
        @RequestBody CredentialIn credential
    ) {

        String jwt = authService.login(
            credential.email(),
            credential.password()
        );
        return TokenOut.builder()
            .jwt(jwt)
            .build();

    }

    @PostMapping("/auth/register")
    public void register(
        @RequestBody RegisterIn register
    ) {

        authService.register(
            register.name(),
            register.email(),
            register.password()
        );

    }
    
}
