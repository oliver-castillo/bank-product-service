package com.bank.productservice.repository;

import com.bank.productservice.model.document.product.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard, String> {
    Flux<CreditCard> findByClientId(String clientId);
}
