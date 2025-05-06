package espm.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountResource {

    @Autowired
    private AccountService accountService;
    
    @GetMapping("/account")
    public List<AccountOut> getAll() {
        return new ArrayList<>();
    }

    @PostMapping("/account")
    public AccountOut post(@RequestBody AccountIn in) {
        Account a = AccountParser.to(in);
        Account saved = accountService.create(a);
        return AccountParser.to(saved);
    }

}
