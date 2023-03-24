package com.example.board.model;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class Post {
    private Long id;

    @NotEmpty(message = "이름을 입력하여 주세요.")
    private String userName;

    @NotEmpty(message = "생년월일을 입력하여 주세요.")
    private String birthday;

    @NotEmpty(message = "휴대폰번호를 입력하여 주세요.")
    private String phoneNumber;

    @NotEmpty(message = "지갑주소를 입력하여 주세요.")
    private String walletAddress;

    private int balance;

    @NotEmpty(message = "은행명을 입력하여 주세요.")
    private String bank;

    @NotEmpty(message = "계좌번호를 입력하여 주세요.")
    private String accountNumber;

    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
 
}
