package espm.account;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PriceService priceService;
    
    @GetMapping("/account")
    public List<AccountOut> read() {
        return accountService.findAll().stream()
            .map(AccountParser::to)
            .toList();
    }

    @GetMapping("/account/{id}")
    public AccountOut read(@PathVariable String id) {
        Account found = accountService.findById(id);
        if (found == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, id);
        }
        return AccountParser.to(found);
    }

    @DeleteMapping("/account/{id}")
    public void delete(@PathVariable String id) {
        accountService.deleteById(id);
    }

    @PostMapping("/account")
    public AccountOut create(@RequestBody AccountIn in) {
        Account a = AccountParser.to(in);
        Account saved = accountService.create(a);
        return AccountParser.to(saved);
    }

    @PutMapping("/account/{id}")
    public AccountOut update(
        @PathVariable String id,
        @RequestBody AccountIn in
    ) {
        Account a = AccountParser.to(in).id(id);
        Account saved = accountService.update(a);
        return AccountParser.to(saved);
    }

    @GetMapping("/price/{from}/{to}")
    public Map<String, String> price(
        @PathVariable String from,
        @PathVariable String to
    ) {
        Map<String, String> out = priceService.price(from, to);
        return out;
    }

}
