package com.progetto.employeeservicedb.repository;

import com.progetto.employeeservicedb.models.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, String>,CrudRepository<EmployeeProject, String> {
     List<EmployeeProject> findByProjectID(String projectID);
}


