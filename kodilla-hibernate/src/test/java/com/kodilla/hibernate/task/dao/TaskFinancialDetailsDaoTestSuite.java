package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskFinancialDetailsDaoTestSuite {
    @Autowired
    private TaskFinancialDetailsDao taskFinancialDetailsDao;

    @Test
    void testFindByPaid() {
        //Given
        TaskFinancialDetails taskFinancialDetails =
                new TaskFinancialDetails(new BigDecimal(115), false);
        taskFinancialDetailsDao.save(taskFinancialDetails);
        boolean paid = taskFinancialDetails.isPaid();

        //When
        List<TaskFinancialDetails> readTaskFinancialDetails = taskFinancialDetailsDao.findByPaid(paid);

        //Then
        assertEquals(1, readTaskFinancialDetails.size());

        //CleanUp
        int id = readTaskFinancialDetails.get(0).getId();
        taskFinancialDetailsDao.deleteById(id);
    }

}
