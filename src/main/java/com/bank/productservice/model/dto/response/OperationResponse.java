package com.bank.productservice.model.dto.response;

import com.bank.productservice.util.Message;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class OperationResponse {
    private String message;
    private String status;
    private Integer code;
    private LocalDateTime timestamp;

    public OperationResponse(Message message, HttpStatus httpStatus) {
        this.message = message.getMessage();
        this.status = httpStatus.getReasonPhrase();
        this.code = httpStatus.value();
        this.timestamp = LocalDateTime.now();
    }
}

