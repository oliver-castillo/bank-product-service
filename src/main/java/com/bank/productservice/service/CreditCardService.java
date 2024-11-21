package com.bank.productservice.service;

import com.bank.productservice.mapper.ProductMapper;
import com.bank.productservice.model.dto.request.CreditCardRequest;
import com.bank.productservice.model.dto.response.CreditCardResponse;
import com.bank.productservice.model.dto.response.OperationResponse;
import com.bank.productservice.repository.CreditCardRepository;
import com.bank.productservice.util.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreditCardService implements ProductService<CreditCardRequest, CreditCardResponse> {
    private final CreditCardRepository repository;
    private final ProductMapper mapper;

    @Override
    public Mono<OperationResponse> save(CreditCardRequest request) {
        return repository.save(mapper.toDocument(request))
                .map(document -> new OperationResponse(Message.CREATED_SUCCESSFULLY, HttpStatus.CREATED))
                .doOnSuccess(response -> log.info("Credit card created successfully: {}", response.getMessage()));
    }

    @Override
    public Flux<CreditCardResponse> getByClientId(String clientId) {
        return repository.findByClientId(clientId).map(mapper::toResponse);
    }
}
