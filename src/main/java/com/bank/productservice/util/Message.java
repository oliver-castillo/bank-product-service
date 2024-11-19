package com.bank.productservice.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Message {
    CREATED_SUCCESSFULLY("Se ha creado el registro correctamente"),
    UPDATED_SUCCESSFULLY("Se ha actualizado el registro correctamente"),
    DELETED_SUCCESSFULLY("Se ha eliminado el registro correctamente"),

    INTERNAL_SERVER_ERROR("Error interno del servidor"),
    DUPLICATE_KEY("Uno o más datos enviados ya existen en la base de datos"),

    NOT_FOUND("El registro no existe"),
    ARGUMENT_NOT_VALID("Uno o más argumentos no son válidos");

    private final String message;
}
