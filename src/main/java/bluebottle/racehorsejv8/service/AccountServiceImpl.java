package bluebottle.racehorsejv8.service;

import bluebottle.racehorsejv8.model.Account;
import bluebottle.racehorsejv8.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository accountRepository;
    @Override
    public List<Account> findAll(Pageable pageable) {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Boolean remove(Long id) {
        accountRepository.deleteById(id);
        return true;
    }
}
