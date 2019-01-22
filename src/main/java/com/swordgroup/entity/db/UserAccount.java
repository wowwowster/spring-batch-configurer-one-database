package com.swordgroup.entity.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 账户余额
     */
    private BigDecimal accountBalance;
    /**
     * 是否开启自动扣减
     */
    private Boolean autoDeduct;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Boolean getAutoDeduct() {
        return autoDeduct;
    }

    public void setAutoDeduct(Boolean autoDeduct) {
        this.autoDeduct = autoDeduct;
    }
}
