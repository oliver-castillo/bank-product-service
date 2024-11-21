package com.bank.productservice.controller;

import com.bank.productservice.model.dto.request.CreditCardRequest;
import com.bank.productservice.model.dto.response.CreditCardResponse;
import com.bank.productservice.model.dto.response.OperationResponse;
import com.bank.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("credit-cards")
public class CreditCardController {
    private final ProductService<CreditCardRequest, CreditCardResponse> service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OperationResponse> save(@RequestBody @Valid CreditCardRequest request) {
        return service.save(request);
    }

    @GetMapping(value = "client/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CreditCardResponse> getByClientId(@PathVariable String clientId) {
        return service.getByClientId(clientId);
    }
}
