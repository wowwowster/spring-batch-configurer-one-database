package com.swordgroup.entity.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "water_record")
public class WaterRecord {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private BigDecimal consumption;

    private Boolean isGenerateBill;

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

    public BigDecimal getConsumption() {
        return consumption;
    }

    public void setConsumption(BigDecimal consumption) {
        this.consumption = consumption;
    }

    public Boolean getGenerateBill() {
        return isGenerateBill;
    }

    public void setGenerateBill(Boolean generateBill) {
        isGenerateBill = generateBill;
    }
}
