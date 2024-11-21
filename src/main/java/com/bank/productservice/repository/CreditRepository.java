package com.bank.productservice.repository;

import com.bank.productservice.model.document.product.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CreditRepository extends ReactiveMongoRepository<Credit, String> {
    Flux<Credit> findByClientId(String clientId);
}
