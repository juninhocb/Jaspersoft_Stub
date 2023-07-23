package com.carlosjr.springjasper.employee;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class EmployeeReportProvider {

    @Value("${com.carlosjr.resources.employee-datatable}")
    private String employeeDataTablePath;
    @Bean
    @Qualifier("employeeJasperReport")
    @Primary
    public JasperReport reports() throws IOException, JRException {

        Resource resource = new ClassPathResource(employeeDataTablePath);

        // Load the .jasper file as a resource
        InputStream inputStream = resource.getInputStream();

        // Create a JasperReport object directly from the .jasper file
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);

        // Make sure to close the inputStream after use
        inputStream.close();

        return jasperReport;

    }

    @Bean
    @Qualifier("nameJasperReport")

    public JasperReport nameReports() throws IOException, JRException {

        Resource resource = new ClassPathResource(employeeDataTablePath.replace("datatable", "data"));

        // Load the .jasper file as a resource
        InputStream inputStream = resource.getInputStream();

        // Create a JasperReport object directly from the .jasper file
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);

        // Make sure to close the inputStream after use
        inputStream.close();

        return jasperReport;

    }


}
