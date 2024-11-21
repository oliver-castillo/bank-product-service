package com.bank.productservice.repository;

import com.bank.productservice.model.document.product.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BankAccountRepository extends ReactiveMongoRepository<BankAccount, String> {
    Flux<BankAccount> findBankAccountsByClientId(String clientId);
}
