package com.progetto.projectservicedb.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.progetto.projectservicedb.models.EmployeeIDList;
import com.progetto.projectservicedb.resources.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;

@Service
public class EmployeeIDListService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackEmployeeIDList")
    public EmployeeIDList getEmployeeIDList(@PathVariable String projectID) {
        return restTemplate.getForObject("http://employee-discovery/employeeidlist/"+                                //chiamata al microservizio employee-service, a cui è associata la tabella employeeproject(in MySQL),  che contiene per ogni tupla una coppia employeeID,projectID
                projectID, EmployeeIDList.class);                                                                        //poichè questa chiamata restituisce una lista di employeeID (String), è stato necessario creare una nuova classe, EmployeeIDList, per evitare gli errori dovuti al json
    }                                                                                                                    //(per più informazioni si veda la classe EmployeeIDList)
    public EmployeeIDList getFallbackEmployeeIDList(@PathVariable String projectID){
        LinkedList<String> list = new LinkedList<>();
        list.add("LIST NOT FOUND");
        EmployeeIDList l = new EmployeeIDList(list);
        return l;
    }
}
