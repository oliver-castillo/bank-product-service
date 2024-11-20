package com.bank.productservice.service;

import com.bank.productservice.mapper.ProductMapper;
import com.bank.productservice.model.dto.request.CreditRequest;
import com.bank.productservice.model.dto.response.OperationResponse;
import com.bank.productservice.repository.CreditRepository;
import com.bank.productservice.util.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreditService implements ProductService<CreditRequest> {
    private final CreditRepository repository;
    private final ProductMapper mapper;

    @Override
    public Mono<OperationResponse> save(CreditRequest request) {
        if (!validate(request)) {
            return Mono.just(new OperationResponse(Message.REQUIREMENT_NOT_MET, HttpStatus.BAD_REQUEST));
        } else {
            return repository.save(mapper.toDocument(request))
                    .map(document -> new OperationResponse(Message.CREATED_SUCCESSFULLY, HttpStatus.CREATED))
                    .doOnSuccess(response -> log.info("Credit created successfully: {}", response.getMessage()));
        }
    }

    private boolean validate(CreditRequest request) {
        // TODO: Implement validation logic
        return true;
    }
}
