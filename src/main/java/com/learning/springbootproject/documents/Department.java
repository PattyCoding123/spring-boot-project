package com.learning.springbootproject.documents;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/* Java representation of a Department document in MongoDB.
 * We must use the @Document("{collection}") to map a document
 * class to a collection.
 * */
@Document("departments")
public class Department {
    @Id
    private String departmentId;

    /*
    * Using the Spring Boot Validator dependency, we have made
    * the departmentName a required field with the @NotBlank annotation.
    *
    * There's also:
    * @Length(max, min)
    * @Size(max, min)
    * @Email
    * @Positive
    * @Negative
    * @PositiveOrZero
    * @NegativeOrZero
    * @Future
    * @Present
    * @Past
    * @PastOrPresent
    *  */
    @NotBlank(message = "Please Add Department Name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }
}
