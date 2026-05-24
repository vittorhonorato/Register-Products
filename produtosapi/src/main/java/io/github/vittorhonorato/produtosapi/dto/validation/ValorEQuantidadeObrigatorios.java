package io.github.vittorhonorato.produtosapi.dto.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValorEQuantidadeValidator.class)
public @interface ValorEQuantidadeObrigatorios {

    String message() default "os campos valor e quantidade sao obrigatórios!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
