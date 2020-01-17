package com.example.demo.serviceImpl;

import com.example.demo.mapper.mysql.MySqlHelloMapper;
import com.example.demo.mapper.oracle.OracalHelloMapper;
import com.example.demo.service.DataSourceTestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2019/11/8
 */
@Service
public class DataSourceServiceImpl implements DataSourceTestService {

    @Resource
    private MySqlHelloMapper mySqlHelloMapper;

    @Resource
    private OracalHelloMapper oracalHelloMapper;

//    @Resource
//    private AcctBalanceAbmSummaryMapper acctBalanceAbmSummaryMapper;

    @Override
    public void test() {
        int test = mySqlHelloMapper.test();
        int test2 = oracalHelloMapper.test();


        System.out.println(test);
        System.out.println(test2);

//        List<AcctBalanceAbmSummary> acctBalanceAbmSummaries1 = acctBalanceAbmSummaryMapper.selectCount();
//        System.out.println(acctBalanceAbmSummaries1.size());
//        AcctBalanceAbmSummary acc = new AcctBalanceAbmSummary();
//
//        QueryWrapper<AcctBalanceAbmSummary> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(AcctBalanceAbmSummary::getChgWho,"system");
//        List<AcctBalanceAbmSummary> acctBalanceAbmSummaries = acctBalanceAbmSummaryMapper.selectList(queryWrapper);
//
//        acctBalanceAbmSummaries.forEach(in-> System.out.print(in));
//        System.out.println(test+"=============="+test2);


//        List<AcctBalanceAbmSummary> acctBalanceAbmSummaries = acctBalanceAbmSummaryMapper.selectList(null);
//        System.out.println(acctBalanceAbmSummaries.size());

    }
}
