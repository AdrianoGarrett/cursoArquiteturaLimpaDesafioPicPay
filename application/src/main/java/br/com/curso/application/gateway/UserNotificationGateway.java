package br.com.curso.application.gateway;

import br.com.curso.core.domain.Transaction;

import java.math.BigDecimal;

public interface UserNotificationGateway {
    Boolean notificate(Transaction transaction, String email);
}
