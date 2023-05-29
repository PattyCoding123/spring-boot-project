package com.learning.springbootproject.service;

import com.learning.springbootproject.documents.Department;
import com.learning.springbootproject.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    /* Mock Repository class since we are only
     * testing the Service layer. */
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        /* Mock a response object for the departmentRepository, since
         * we don't want to worry about its implementation. */
        Optional<Department> department = Optional.ofNullable(Department.builder()
                .departmentName("IT")
                .departmentAddress("Michigan")
                .departmentCode("IT-06")
                .departmentId("abc123")
                .build());

        /*
         *Since getDepartmentByName calls findByDepartmentNameIgnoreCase, we want to return
         * an existing department wrapped in an Optional. */
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldBeFound() throws Exception {
        String departmentName = "IT";

        Department found = departmentService.getDepartmentByName("IT");

        System.out.println(found.getDepartmentName());
        assertEquals(departmentName, found.getDepartmentName());
    }
}