package com.bank.productservice.service;

import com.bank.productservice.exception.BadRequest;
import com.bank.productservice.mapper.ProductMapper;
import com.bank.productservice.model.dto.request.BankAccountRequest;
import com.bank.productservice.model.dto.response.BankAccountResponse;
import com.bank.productservice.model.dto.response.OperationResponse;
import com.bank.productservice.repository.BankAccountRepository;
import com.bank.productservice.util.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class BankAccountService implements ProductService<BankAccountRequest, BankAccountResponse> {
    private final BankAccountRepository repository;
    private final ProductMapper mapper;

    @Override
    public Mono<OperationResponse> save(BankAccountRequest request) {
        if (!validate(request)) {
            throw new BadRequest();
        } else {
            return repository.save(mapper.toDocument(request)).map(
                    document -> new OperationResponse(Message.CREATED_SUCCESSFULLY, HttpStatus.CREATED)
            ).doOnSuccess(response -> log.info("Bank account created successfully: {}", response));
        }
    }

    @Override
    public Flux<BankAccountResponse> getByClientId(String clientId) {
        return repository.findBankAccountsByClientId(clientId).map(mapper::toResponse);
    }

    private boolean validate(BankAccountRequest request) throws WebExchangeBindException {
        // TODO: Agregar validaciones
        return true;
    }
}
