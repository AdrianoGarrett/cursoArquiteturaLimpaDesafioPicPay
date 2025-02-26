package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.ConsultBalanceGateway;
import br.com.curso.core.domain.Wallet;
import br.com.curso.usecase.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceImpl implements ConsultBalanceUseCase {
    private ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceImpl(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consult(Wallet wallet) {
        return consultBalanceGateway.consult(wallet);
    }
}
