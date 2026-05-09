package io.github.vittorhonorato.produtosapi.exception;

import org.springframework.http.HttpStatus;

public record ApiResponse(
        HttpStatus status,
        String message
) {
}
