package com.carlosjr.springjasper.employee;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.Iterator;

@RequiredArgsConstructor
public class NameDataSource implements JRDataSource {

    private final Iterator<Employee> nameIterator;
    private String currentName;

    @Override
    public boolean next() throws JRException {
        if (nameIterator.hasNext()) {
            currentName = nameIterator.next().getName();
            return true;
        }
        return false;
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        String fieldName = jrField.getName();
        if ("name".equals(fieldName)) {
            return currentName;}
        return "null-name";
    }
}
