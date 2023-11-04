package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class FinderFacadeTest {

    @Autowired
    private FinderFacade finderFacade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testFindCompaniesByPartialName() {
        // Given
        Company microsoft = new Company("Microsoft");
        Company amazon = new Company("Amazon");
        Company google = new Company("Google");
        companyDao.save(microsoft);
        companyDao.save(amazon);
        companyDao.save(google);

        // When
        List<Company> foundCompanies = finderFacade.findCompaniesByPartialName("Ama");

        // Then
        assertEquals(1, foundCompanies.size());
        assertEquals("Amazon", foundCompanies.get(0).getName());
    }

    @Test
    void testFindEmployeesByPartialLastName() {
        // Given
        Employee patrykPotrykus = new Employee("Patryk", "Potrykus");
        Employee janKowalski = new Employee("Jan", "Kowalski");
        Employee adamNowak = new Employee("Adam", "Nowakowski");
        employeeDao.save(patrykPotrykus);
        employeeDao.save(janKowalski);
        employeeDao.save(adamNowak);

        // When
        List<Employee> foundEmployees = finderFacade.findEmployeesByPartialLastName("ski");

        // Then
        assertEquals(2, foundEmployees.size());
        assertTrue(foundEmployees.contains(adamNowak));
        assertTrue(foundEmployees.contains(janKowalski));
        assertFalse(foundEmployees.contains(patrykPotrykus));
    }
}