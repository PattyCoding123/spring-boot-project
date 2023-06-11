package com.learning.springbootproject.controller;

import com.learning.springbootproject.documents.Department;
import com.learning.springbootproject.errors.DepartmentNotFoundException;
import com.learning.springbootproject.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    /* Spring takes control and injects the DepartmentService
     * object automatically for this reference. This way, we
     * don't need to create a reference using the "new" keyword.
     *
     * It knows what classes are Service components
     * due to the @Service annotation over the class declaration.
     *
     * The type of DepartmentService however comes from the
     * Interface since Service classes can have multiple
     * implementations.
     * */
    @Autowired
    private DepartmentService departmentService;

    /* Log messages from RestController methods which is
     * useful for debugging purposes. */
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    /* @RequestBody means that the department variable will
     * be a JSON object in the body of the request.
     *
     * @Valid will validate the Department parameter using
     * the annotations we provided in the Department class.  */
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartmentList() {
        LOGGER.info("Inside getDepartmentList method of DepartmentController");
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
    public Department getDepartmentById(@PathVariable("id") String departmentId)
            throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") String departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") String departmentId, @RequestBody Department department)
            throws DepartmentNotFoundException {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName)
            throws DepartmentNotFoundException {
        return departmentService.getDepartmentByName(departmentName);
    }
}
