package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.CreateWalletGateWay;
import br.com.curso.core.domain.Wallet;
import br.com.curso.usecase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {
    private CreateWalletGateWay createWalletGateWay;

    public CreateWalletUseCaseImpl(CreateWalletGateWay createWalletGateWay) {
        this.createWalletGateWay = createWalletGateWay;
    }

    @Override
    public void create(Wallet wallet) {
        createWalletGateWay.create(wallet);
    }
}
