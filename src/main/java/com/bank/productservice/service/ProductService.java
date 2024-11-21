package com.bank.productservice.service;

import com.bank.productservice.model.dto.request.ProductRequest;
import com.bank.productservice.model.dto.response.OperationResponse;
import com.bank.productservice.model.dto.response.ProductResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService<T extends ProductRequest, R extends ProductResponse> {
    Mono<OperationResponse> save(T request);

    Flux<R> getByClientId(String clientId);
}
