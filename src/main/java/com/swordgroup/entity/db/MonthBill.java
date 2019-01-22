package com.swordgroup.entity.db;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "month_bill")
@Data
public class MonthBill {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 总费用
     */
    private BigDecimal totalFee;

    /**
     * 是否已缴
     */
    private Boolean isPaid;

    /**
     * 是否通知
     */
    private Boolean isNotice;

    /**
     * 账单生成时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Boolean getNotice() {
        return isNotice;
    }

    public void setNotice(Boolean notice) {
        isNotice = notice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
