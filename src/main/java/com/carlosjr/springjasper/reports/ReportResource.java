package com.carlosjr.springjasper.reports;

import com.carlosjr.springjasper.employee.Employee;
import com.carlosjr.springjasper.employee.EmployeeDataSource;
import com.carlosjr.springjasper.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reports")
@Slf4j
@RequiredArgsConstructor
public class ReportResource {

    @Qualifier("employeeJasperReport")
    private final JasperReport jasperReport;

    private final EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public ResponseEntity<byte[]> getEmployeeReport() throws JRException {

        List<Employee> employees = employeeRepository.findAll();

        EmployeeDataSource employeeDataSource = new EmployeeDataSource(employees);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                null, employeeDataSource);

        byte[] reportData = JasperExportManager.exportReportToPdf(jasperPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF); // Set the appropriate content type for your report format
        headers.setContentDispositionFormData("attachment", "employee_report.pdf"); // Optional: Set a filename for download

        return new ResponseEntity<>(reportData, headers, HttpStatus.OK);
    }


}
