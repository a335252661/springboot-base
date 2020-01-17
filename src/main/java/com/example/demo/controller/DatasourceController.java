package com.example.demo.controller;

import com.example.demo.service.DataSourceTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2019/11/8
 */
@RestController
public class DatasourceController {

    @Autowired
    DataSourceTestService dataSourceService;

    @RequestMapping("datasource")
    @ResponseBody
    public String index() {
        dataSourceService.test();
        return "多数据源测试完成！！";
    }
}
