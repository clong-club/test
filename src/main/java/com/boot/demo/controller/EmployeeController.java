package com.boot.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.demo.bean.Employee;
import com.boot.demo.dao.EmployeeRepository;
import com.google.gson.Gson;
/**   
 * @ClassName:  EmployeeController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: CLONG
 * @date:   2018年11月29日 上午10:24:32  
 * @Copyright: 2018 www.derlte.com Inc. All rights reserved. 
 * 注意：本内容仅限于天津德尔塔科技有限公司内部传阅，禁止外泄以及用于其他的商业目 
 */  
@RestController
@RequestMapping("es")
public class EmployeeController {
 
    /**   
     * @Fields employeeRepository : TODO(用一句话描述这个变量表示什么)   
     */ 
    @Autowired
    private EmployeeRepository employeeRepository;
 
    /**
     * 添加
     * @return
     */
    @RequestMapping("add")
    public String add() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setFirstName("xuxu");
        employee.setLastName("zh");
        employee.setAge(26);
        employee.setAbout("i am in peking");
        employeeRepository.save(employee);
        System.err.println("add a obj");
        return "success";
    }
 
    /**
     * 删除
     * @return
     */
    @RequestMapping("delete")
    public String delete() {
        Employee employee = employeeRepository.queryEmployeeById("1");
        employeeRepository.delete(employee);
        return "success";
    }
 
    /**
     * 局部更新
     * @return
     */
    @RequestMapping("update")
    public String update() {
        Employee employee = employeeRepository.queryEmployeeById("1");
        employee.setFirstName("哈哈");
        employeeRepository.save(employee);
        System.err.println("update a obj");
        return "success";
    }
    /**
     * 查询
     * @return
     */
    @RequestMapping("query")
    public Iterable<Employee> query() {
        Iterable<Employee> accountInfo = employeeRepository.findAll();
        System.err.println(new Gson().toJson(accountInfo));
        return accountInfo;
    }
} 
