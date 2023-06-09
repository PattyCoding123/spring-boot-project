package com.learning.springbootproject.service;

import com.learning.springbootproject.documents.Department;
import com.learning.springbootproject.errors.DepartmentNotFoundException;

import java.util.List;

/* For services, there could be multiple implementations, which
 * is why it is "best practice" to create an interface that
 * an individual service class can implement.
 *
 * The "Service" classes handle the "business logic" in our
 * Spring Boot Application. Calling the repository methods
 * is part of the "business logic".
 *  */
public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartmentList();

    Department getDepartmentById(String departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(String departmentId);

    Department updateDepartment(String departmentId, Department department) throws DepartmentNotFoundException;

    Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException;
}
