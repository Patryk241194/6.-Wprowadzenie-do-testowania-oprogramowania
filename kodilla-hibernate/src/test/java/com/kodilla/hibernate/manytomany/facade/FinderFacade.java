package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinderFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinderFacade.class);
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> findCompaniesByPartialName(String partialName) {
        LOGGER.info("Searching for companies by partial name: " + partialName);
        List<Company> foundCompanies = companyDao.findCompaniesByPartialName(partialName);
        String companies = (foundCompanies.size() == 1) ? "company" : "companies";
        LOGGER.info("Found " + foundCompanies.size() + " " + companies + ".");
        return foundCompanies;
    }

    public List<Employee> findEmployeesByPartialLastName(String partialLastName) {
        LOGGER.info("Searching for employees by partial last name: " + partialLastName);
        List<Employee> foundEmployees = employeeDao.findByPartialLastName(partialLastName);
        String employees = (foundEmployees.size() == 1) ? "employee" : "employees";
        LOGGER.info("Found " + foundEmployees.size() + " " + employees + ".");
        return foundEmployees;
    }
}
