package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TransferGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.InternalServerErrorException;
import br.com.curso.core.exception.NotFoundException;
import br.com.curso.core.exception.NotificationException;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private TransferGateway transferGateway;
    private UserNotificationUseCase userNotificationUseCase;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, CreateTransactionUseCase createTransactionUseCase, TransactionValidateUseCase transactionValidateUseCase, TransferGateway transferGateway, UserNotificationUseCase userNotificationUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException {

        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        from.transferValue(value);
        to.receiveValue(value);

        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        transactionValidateUseCase.validate(transaction);

        if(!transferGateway.transfer(transaction)){
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(),ErrorCodeEnum.TR0003.getCode());
        }

        if(!userNotificationUseCase.notificate(transaction,to.getUser().getEmail())){
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(),ErrorCodeEnum.NO0001.getCode());
        }

        return true;
    }
}
