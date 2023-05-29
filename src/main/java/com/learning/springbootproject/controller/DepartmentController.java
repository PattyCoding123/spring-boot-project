package com.learning.springbootproject.controller;

import com.learning.springbootproject.documents.Department;
import com.learning.springbootproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    /* Spring takes control and injects the DepartmentService
     * object automatically for this reference. This way, we
     * don't need to create a reference using the "new" keyword. */

    @Autowired
    private DepartmentService departmentService;

    /* @RequestBody means that the department variable will
     * be transformed into a JSON object  */
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartmentList() {
        return departmentService.getDepartmentList();
    }

    /* The {id} indicates that "id" is a dynamic value
     * in the API endpoint
     *
     * To map the dynamic value from the endpoint to the
     * function parameter, use the @PathVariable("{variable}")
     * annotation.
     *
     * In this example, we would do @PathVariable("id").
     * */
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") String departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") String departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") String departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }
}
