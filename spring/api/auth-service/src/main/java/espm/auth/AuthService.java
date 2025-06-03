package espm.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import espm.account.AccountController;
import espm.account.AccountIn;
import espm.account.AccountOut;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private AccountController accountController;

    public String login(String email, String password) {

        // verifica se usuario e senha existem
        AccountOut accountOut = accountController.login(
            AccountIn.builder()
                .email(email)
                .password(password)
                .build()
        );
        if (accountOut == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        // TODO: cria um token.
        return "ainda tem que criar token";

    }

    public void register(String name, String email, String password) {

        logger.debug("register: " + name + ":" + password);

        AccountIn accountIn = AccountIn.builder()
            .name(name)
            .email(email)
            .password(password)
            .build();

        logger.debug("in: " + accountIn);

        AccountOut accountOut = accountController.create(accountIn);

        logger.debug("out: " + accountOut);

    }
    
}
