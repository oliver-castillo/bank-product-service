package com.bank.productservice.service;

import com.bank.productservice.model.dto.request.ProductRequest;
import com.bank.productservice.model.dto.response.OperationResponse;
import reactor.core.publisher.Mono;

public interface ProductService<T extends ProductRequest> {
    Mono<OperationResponse> save(T request);
}
