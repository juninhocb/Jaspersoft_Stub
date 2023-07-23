package com.carlosjr.springjasper.employee;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.Iterator;
import java.util.List;

public class EmployeeDataSource implements JRDataSource {

    private final Iterator<Employee> employeeIterator;
    private Employee currentEmployee;

    public EmployeeDataSource(List<Employee> employees) {
        this.employeeIterator = employees.iterator();
    }

    @Override
    public boolean next() throws JRException {
        if (employeeIterator.hasNext()) {
            currentEmployee = employeeIterator.next();
            return true;
        }
        return false;
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        String fieldName = jrField.getName();
        if ("active".equals(fieldName)) {
            return currentEmployee.getActive();
        } else if ("age".equals(fieldName)) {
            return currentEmployee.getAge();
        } else if ("salary".equals(fieldName)) {
            return currentEmployee.getSalary();
        } else if ("id".equals(fieldName)) {
            return currentEmployee.getId();
        } else if ("address".equals(fieldName)) {
            return currentEmployee.getAddress();
        } else if ("name".equals(fieldName)) {
            return currentEmployee.getName();
        }
        return null;
    }
}
