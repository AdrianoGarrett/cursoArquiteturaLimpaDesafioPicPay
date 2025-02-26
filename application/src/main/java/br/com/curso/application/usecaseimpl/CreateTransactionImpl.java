package br.com.curso.application.usecaseimpl;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.CreateTransactionUseCase;
import br.com.curso.application.gateway.CreateTransactionGateway;
public class CreateTransactionImpl implements CreateTransactionUseCase {
    private CreateTransactionGateway createTransactionGateway;

    public CreateTransactionImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) throws TransferException {
        var transactionSaved = createTransactionGateway.create(transaction);
        if(transactionSaved == null){
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(),ErrorCodeEnum.TR0003.getCode());
        }
        return transactionSaved;
    }
}
