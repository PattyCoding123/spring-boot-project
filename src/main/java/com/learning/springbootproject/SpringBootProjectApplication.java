package com.learning.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* In order for the Spring Boot application to recognize REST API
 * controller classes, we need to use the @RestController annotation
 * on those classes
 *
 * With the SpringDevTools, we can go into our IDE settings and do the following:
 * 1. Open File > Settings (ctrl + alt + s) and enable the Compiler setting that
 * reads "Allow auto-make to start even if developed application is currently running".
 *
 * 2. Open File > Settings, open the Build, Execution, Deployment settings, go to the
 * Compiler dropdown, and enable the "Build project automatically" setting.
 *
 * Doing this will allow us to notice our changes during development without needing
 * to rerun the entire project.
 * */
@SpringBootApplication
public class SpringBootProjectApplication {

    /*
    * The Architecture that our Spring Boot Application
    * follows is (from top level to bottom level):
    *
    *   The Entity Controllers (REST CONTROLLERS)
    *             |
    *    Services (Call Entity Repository methods)
    *             |
    *   Data access/Repository classes (Link between Entities and Database)
    *             |
    *     Database (MongoDB)
    *  */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }

}
