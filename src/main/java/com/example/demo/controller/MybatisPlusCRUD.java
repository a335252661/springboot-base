package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.oracal.AcctBalanceAbmSummary;
import com.example.demo.mapper.oracle.AcctBalanceAbmSummaryMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/1/16
 */
@Controller
public class MybatisPlusCRUD {

    @Resource
    private AcctBalanceAbmSummaryMapper acctBalanceAbmSummaryMapper;

    @RequestMapping("select")
    @ResponseBody
    public List<AcctBalanceAbmSummary>   select() {
//        AcctBalanceAbmSummary aa = new AcctBalanceAbmSummary();
//        aa.setAcctId(999L);
//        aa.setCreatedDate(new Date());
//        aa.setBalance(new BigDecimal(10));
//        aa.setBalanceMonth("201911");
//        int insert = acctBalanceAbmSummaryMapper.insert(aa);
        //更新的内容
        AcctBalanceAbmSummary aa2 = new AcctBalanceAbmSummary();
        aa2.setBalance(new BigDecimal(1000));
        //条件
        UpdateWrapper<AcctBalanceAbmSummary> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("ACCT_ID",999L)
                .eq("BALANCE_MONTH","201911");
        int update = acctBalanceAbmSummaryMapper.update(aa2, updateWrapper);
        //带条件查询
        List<AcctBalanceAbmSummary> acctBalanceAbmSummaries = acctBalanceAbmSummaryMapper.selectList(updateWrapper);
        return acctBalanceAbmSummaries;
    }
}
