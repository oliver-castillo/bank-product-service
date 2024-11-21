package com.bank.productservice.controller;

import com.bank.productservice.model.dto.request.BankAccountRequest;
import com.bank.productservice.model.dto.request.HolderRequest;
import com.bank.productservice.model.dto.request.SignatoryRequest;
import com.bank.productservice.model.dto.response.BankAccountResponse;
import com.bank.productservice.model.dto.response.OperationResponse;
import com.bank.productservice.model.enums.BankAccountType;
import com.bank.productservice.model.enums.ClientType;
import com.bank.productservice.service.ProductService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("bank-accounts")
public class BankAccountController {
    private final ProductService<BankAccountRequest, BankAccountResponse> service;
    private final Validator validator;

    @PostMapping(value = "{type}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OperationResponse> save(@PathVariable int type, @RequestBody BankAccountRequest request) {
        request.setAccountType(BankAccountType.withId(type));
        validate(request);
        return service.save(request);
    }

    @GetMapping(value = "client/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<BankAccountResponse> getByClientId(@PathVariable String clientId) {
        return service.getByClientId(clientId);
    }

    private void validate(BankAccountRequest request) {
        if (Objects.requireNonNull(request.getAccountType().getClientType()) == ClientType.PERSONAL) {
            request.setSignatories(Set.of());
            request.setHolders(Set.of(new HolderRequest()));
            if (request.getAccountType() != BankAccountType.FIXED_TERM_ACCOUNT_STANDARD) {
                request.setTransactionDates(Set.of());
            }
        } else if (request.getAccountType().getClientType() == ClientType.BUSINESS) {
            request.setTransactionDates(Set.of());

            if (request.getSignatories() != null) {
                request.getSignatories().forEach(signatory -> {
                    final Set<ConstraintViolation<SignatoryRequest>> violations;
                    violations = validator.validate(signatory);
                    if (!violations.isEmpty()) {
                        throw new ConstraintViolationException(violations);
                    }
                });
            }
            if (request.getHolders() != null) {
                request.getHolders().forEach(holder -> {
                    final Set<ConstraintViolation<HolderRequest>> violations;
                    violations = validator.validate(holder);
                    if (!violations.isEmpty()) {
                        throw new ConstraintViolationException(violations);
                    }
                });
            }
        }

        if (!request.getAccountType().hasTransactionLimit()) {
            request.setTransactionLimit(0);
        }
        if (!request.getAccountType().hasMaintenanceFee()) {
            request.setMaintenanceFee(0.0);
        }
        if (!request.getAccountType().requiresAverageMonthlyMinimumAmount()) {
            request.setAverageMonthlyMinimumAmount(0.0);
        }


        Set<ConstraintViolation<BankAccountRequest>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
