package com.bank.productservice.controller;

import com.bank.productservice.model.dto.request.CreditRequest;
import com.bank.productservice.model.dto.response.CreditResponse;
import com.bank.productservice.model.dto.response.OperationResponse;
import com.bank.productservice.model.enums.ClientType;
import com.bank.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("credits")
public class CreditController {
    private final ProductService<CreditRequest, CreditResponse> service;

    @PostMapping("personal")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OperationResponse> savePersonalCredit(@RequestBody @Valid CreditRequest request) {
        request.setClientType(ClientType.PERSONAL);
        return service.save(request);
    }

    @PostMapping("business")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OperationResponse> saveBusinessCredit(@RequestBody @Valid CreditRequest request) {
        request.setClientType(ClientType.BUSINESS);
        return service.save(request);
    }

    @GetMapping(value = "client/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CreditResponse> getByClientId(@PathVariable String clientId) {
        return service.getByClientId(clientId);
    }
}
