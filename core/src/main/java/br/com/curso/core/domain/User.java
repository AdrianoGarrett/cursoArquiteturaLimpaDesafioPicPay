package br.com.curso.core.domain;

import br.com.curso.core.domain.enums.UserTypeEnum;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID uuid;
    private String email;
    private String password;
    private TaxNumber taxNumber;
    private String fullName;
    private UserTypeEnum userTypeEnum;
    private TransactionPin transactionPin;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public User(UUID uuid, String email, String password, TaxNumber taxNumber, String fullName, UserTypeEnum userTypeEnum, TransactionPin transactionPin, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.uuid = uuid;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.userTypeEnum = userTypeEnum;
        this.transactionPin = transactionPin;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public User(String email, String password, TaxNumber taxNumber, String fullName, UserTypeEnum userTypeEnum, TransactionPin transactionPin) {
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.userTypeEnum = userTypeEnum;
        this.transactionPin = transactionPin;
    }

    public User() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserTypeEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    public void setUserTypeEnum(UserTypeEnum userTypeEnum) {
        this.userTypeEnum = userTypeEnum;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return uuid.equals(user.uuid) && email.equals(user.email) && password.equals(user.password) && taxNumber.equals(user.taxNumber) && fullName.equals(user.fullName) && userTypeEnum == user.userTypeEnum && transactionPin.equals(user.transactionPin) && createdAt.equals(user.createdAt) && Objects.equals(updateAt, user.updateAt);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + taxNumber.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + userTypeEnum.hashCode();
        result = 31 * result + transactionPin.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + Objects.hashCode(updateAt);
        return result;
    }
}
