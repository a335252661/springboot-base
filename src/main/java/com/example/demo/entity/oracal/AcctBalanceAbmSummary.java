package com.example.demo.entity.oracal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

 /**
  * @Description TODO
  * @author  程刘德
  * @date 2020/1/16
  * @version 1.0
  */
@Data
@TableName(value = "ACCT_BALANCE_ABM_SUMMARY")
public class AcctBalanceAbmSummary implements Serializable {
    @TableField(value = "ACCT_ID")
    private Long acctId;

    @TableField(value = "TYPE_FLAG")
    private Short typeFlag;

    @TableField(value = "BALANCE")
    private BigDecimal balance;

    @TableField(value = "BALANCE_MONTH")
    private String balanceMonth;

    @TableField(value = "CREATED_DATE")
    private Date createdDate;

    @TableField(value = "CHG_WHO")
    private String chgWho;

    @TableField(value = "REMARKS")
    private String remarks;
}