package espm.account;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Aqui ficam as regras de negocio.
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account create(Account a) {
        a.createdAt(new Date());
        a.hashPassword("calcular o hash");
        return accountRepository.save(new AccountModel(a)).to();
    } 
    
}
