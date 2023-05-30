package com.learning.springbootproject.repository;

import com.learning.springbootproject.documents.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * The API implementation happens in the repository.
 * It acts as a link between the model and the database and has
 * all the methods for CRUD operations so that us developers
 * do not need to define them all ourselves (reduce boilerplate).
 *
 * The DepartmentRepository will extend the MongoRepository<T, ID>
 * interface which takes two generic type arguments:
 * T: Java representation of the document.
 * ID: The ID type.
 * */
@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
    /* Since findByDepartmentName is not a part of the MongoRepository,
     * we need to declare it ourselves.
     *
     * For defining our own query methods, we must write the name
     * with camel casing and follow the "findBy{FIELD}" convention.
     * This ensures that the MongoRepository knows what field
     * to filter the query with.
     * */

    /*
     * The @Query annotation is applied at the method-level
     * in MongoRepository interfaces, and pertains to a single method.
     *
     * For MongoDB JSON queries, each query starts with curly braces
     * and follows the format:
     * {
     *  key: ?NUM
     * }
     * The ?NUM refers to the argument position for mapping the function's
     * parameters to the values in the query.
     *
     * To include more options for a particular field, you must surround
     * them with more curly braces. Additionally, you must also attach $
     * at the start of operators.
     *  */
    // @Query(value = "{'departmentName': ?0}")
    Optional<Department> findByDepartmentName(String departmentName);

    // @Query(value = "{'departmentName': {$regex: ?0, $options: 'i'}")
    Optional<Department> findByDepartmentNameIgnoreCase(String departmentName);
}
