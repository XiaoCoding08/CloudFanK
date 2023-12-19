package com.exam.service;

import com.exam.dto.EmployeeLoginDTO;
import com.exam.entity.Employee;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

}
