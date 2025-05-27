package espm.auth;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String login(String email, String password) {

        // TODO: verifica se usuario e senha exitem no
        // microsservico de account, se existir, então,
        // cria um token.
        return null;

    }

    public void register(String name, String email, String password) {
        
    }
    
}
