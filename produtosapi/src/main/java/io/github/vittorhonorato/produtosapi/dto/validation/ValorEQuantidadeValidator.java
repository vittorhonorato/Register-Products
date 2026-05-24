package io.github.vittorhonorato.produtosapi.dto.validation;

import io.github.vittorhonorato.produtosapi.dto.ProductRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValorEQuantidadeValidator implements ConstraintValidator<ValorEQuantidadeObrigatorios, ProductRequestDTO> {


    @Override
    public boolean isValid(ProductRequestDTO request, ConstraintValidatorContext context) {

        if (request == null) {
            return true;
        }

        boolean valorNotNull = request.getValorUnidade() != null;
        boolean quantidadeNotNull = request.getQuantidade() != null;

        if (valorNotNull && quantidadeNotNull) {
            return true;
        }

        if (!valorNotNull && !quantidadeNotNull) {
            return true;
        }

        if (valorNotNull) {
            return buildViolation(
                    context,
                    "quantidade",
                    "Quando valor_unidade for enviado, quantidade também deve ser enviada"
            );
        }

        return buildViolation(
                context,
                "valorUnidade",
                "Quando quantidade for enviada, valor_unidade também deve ser enviado"
        );
    }

    private boolean buildViolation(
            ConstraintValidatorContext context,
            String field,
            String message) {

        context.disableDefaultConstraintViolation();

        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(field)
                .addConstraintViolation();

        return false;
    }
}
