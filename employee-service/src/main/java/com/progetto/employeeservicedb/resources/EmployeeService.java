package com.progetto.employeeservicedb.resources;

import com.progetto.employeeservicedb.models.Employee;
import com.progetto.employeeservicedb.models.EmployeeProject;
import com.progetto.employeeservicedb.repository.EmployeeProjectRepository;
import com.progetto.employeeservicedb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeProjectRepository employeeProjectRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();

    }

    public List<EmployeeProject> getEmployeeProjectList(String projectID) {
        return employeeProjectRepository.findByProjectID(projectID);

    }

    public List<EmployeeProject> getAllEmployeeProject() {
        return employeeProjectRepository.findAll();

    }

    public void loadEmployeeProject(@RequestBody final EmployeeProject employeeProject){
        employeeProjectRepository.save(employeeProject);

    }


    public void deleteEmployeeProject(EmployeeProject e){
        employeeProjectRepository.delete(e);

    }



    public Employee getEmployee(String employeeID) {
        return employeeRepository.findById(employeeID).get();

    }


    public void loadEmployee(@RequestBody final Employee employee){
        employeeRepository.save(employee);

    }

    public void updateEmployee(Employee emp){
        employeeRepository.save(emp);
    }

    public void deleteEmployee(String employeeID){
        employeeRepository.deleteById(employeeID);
    }


}
