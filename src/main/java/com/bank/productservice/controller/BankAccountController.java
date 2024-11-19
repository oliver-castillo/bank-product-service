package com.bank.productservice.controller;

import com.bank.productservice.mapper.BankAccountMapper;
import com.bank.productservice.model.dto.request.BankAccountRequest;
import com.bank.productservice.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("accounts/personal")
public class BankAccountController {
    private final BankAccountRepository repository;
    private final BankAccountMapper mapper;

    @PostMapping("/savings-accounts/basic")
    private void save1(@RequestBody @Validated(BankAccountRequest.SavingsAccountBasicRequest.class) BankAccountRequest request) {
        repository.save(mapper.toDocument(request)).subscribe();
    }

    @PostMapping("/savings-accounts/vip")
    private void save2(@RequestBody @Validated(BankAccountRequest.SavingsAccountVipRequest.class) BankAccountRequest request) {
        repository.save(mapper.toDocument(request)).subscribe();
    }
}
