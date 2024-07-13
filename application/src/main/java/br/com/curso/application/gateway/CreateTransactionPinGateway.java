package br.com.curso.application.gateway;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.usecase.CreateTransactionPinUseCase;

public interface CreateTransactionPinGateway {
    void create(TransactionPin transactionPin);
}
