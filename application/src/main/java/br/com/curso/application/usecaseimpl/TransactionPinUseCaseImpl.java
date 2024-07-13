package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.CreateTransactionPinGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.usecase.CreateTransactionPinUseCase;

public class TransactionPinUseCaseImpl implements CreateTransactionPinUseCase {
    private CreateTransactionPinGateway transactionPinGateway;

    public TransactionPinUseCaseImpl(CreateTransactionPinGateway transactionPinGateway) {
        this.transactionPinGateway = transactionPinGateway;
    }

    @Override
    public void create(TransactionPin transactionPin) {
        transactionPinGateway.create(transactionPin);
    }
}
