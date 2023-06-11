package com.learning.springbootproject.service;

import com.learning.springbootproject.documents.Department;
import com.learning.springbootproject.errors.DepartmentNotFoundException;
import com.learning.springbootproject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    /* Spring should automatically inject the
     * DepartmentRepository whenever we call a method
     * in our DepartmentServiceImpl class. */
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

    /* Since there is a chance that no document exists with the
     * input departmentId, the findById function will return an
     * Optional<Department>. It is best to check if the object
     * exists, but we can go straight to getting its reference
     * with the get() for the Optional type. */
    @Override
    public Department getDepartmentById(String departmentId) throws DepartmentNotFoundException {
       Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isEmpty()) {
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(String departmentId, Department department) throws DepartmentNotFoundException {
        Optional<Department> potentialDepDb = departmentRepository.findById(departmentId);

        if(potentialDepDb.isEmpty()) {
            throw new DepartmentNotFoundException("The department you want to edit does not exist.");
        }

        Department depDb = potentialDepDb.get();
        // Checks to make sure a field exists and is NOT empty.
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDb.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDb.setDepartmentCode(department.getDepartmentCode());
        }

        /* Save method will save the changes made to a
         * particular department in MongoDB and return
         * the java representation */
        return departmentRepository.save(depDb);
    }

    @Override
    public Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        if(department.isEmpty()) {
            throw new DepartmentNotFoundException("The department does not exist");
        }
        return department.get();
    }
}
