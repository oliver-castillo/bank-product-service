package com.bank.productservice.controller;

import com.bank.productservice.model.dto.request.BankAccountRequest;
import com.bank.productservice.model.dto.response.OperationResponse;
import com.bank.productservice.model.enums.BankAccountType;
import com.bank.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("products/bank-accounts")
public class BankAccountController {
    private final ProductService<BankAccountRequest> service;

    @PostMapping(value = "{type}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OperationResponse> save(@PathVariable int type, @RequestBody @Valid BankAccountRequest request) {
        request.setAccountType(BankAccountType.withId(type));
        return service.save(request);
    }
}
