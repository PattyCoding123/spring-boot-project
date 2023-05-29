package com.learning.springbootproject.documents;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/* Java representation of a Department document in MongoDB.
 * We must use the @Document("{collection}") to map a document
 * class to a collection.
 *
 * With Lombok, we can use the @Data annotation to handle
 * all the boilerplate code for Plain Old Java Objects (POJOs).
 *
 * @NoArgsConstructor means this class has a default constructor.
 *
 * There's also:
 * AllArgsConstructor
 * Builder
 * */
@Document("departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
