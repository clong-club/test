package com.boot.demo.dao;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.boot.demo.bean.Employee;
/**
 * @author linzhiqiang
 */
@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String>{
 
    /**
     * 查询雇员信息
     * @param id
     * @return
     */
    Employee queryEmployeeById(String id);

}