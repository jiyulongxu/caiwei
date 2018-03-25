package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.service.IEmployeeService;
import com.caiwei.console.common.domain.EmployeeDO;
import com.caiwei.console.persistent.domain.EmployeePO;
import com.caiwei.console.persistent.mapper.EmployeeMapper;
import com.github.framework.server.shared.define.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int insert(EmployeePO employeeDO) {
        return employeeMapper.insert(employeeDO);
    }

    @Override
    public int update(EmployeePO employeeDO) {
        return employeeMapper.update(employeeDO);
    }

    @Override
    public int delete(String empCode) {
        EmployeePO employeePO = new EmployeePO(empCode, Constants.PoStatus.INACTIVE.value());
        return employeeMapper.update(employeePO);
    }

    @Override
    public EmployeeDO findByEmpCode(String empCode) {
        return employeeMapper.findByEmpCode(empCode);
    }

    @Override
    public List<EmployeeDO> findByDeptCode(String deptCode) {
        return employeeMapper.findByDeptCode(deptCode);
    }

    @Override
    public List<EmployeeDO> findEmpByParam(EmployeeDO employeeDO) {
        return employeeMapper.findEmpByParam(employeeDO);
    }
}
