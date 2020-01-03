package com.progetto.employeeservicedb.repository;

import com.progetto.employeeservicedb.models.Employee;
import com.progetto.employeeservicedb.models.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String>,CrudRepository<Employee, String> {

}
