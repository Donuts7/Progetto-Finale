package com.progetto.projectservicedb.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.progetto.projectservicedb.models.Employee;
import com.progetto.projectservicedb.models.EmployeeIDList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackEmployee")
    public String getEmployee(EmployeeIDList lista) {
        String s = "";                                                                                                   //la stringa ''s'' viene popolata tramite tante chiamate quanti sono gli elementi della EmployeeIDList (condizione del ciclo for)
        for(int i=0;i<lista.getSize();i++) {                                                                             //per ogni chiamata, infatti, si fa riferimento ad un singolo employeeID, ottenuto tramite l'invocazione del metodo getElement, definito nella classe EmployeeIDList
            s += restTemplate.getForObject("http://employee-discovery/employees/" + lista.getElement(i),             //per ogni istanza della classe Employee viene quindi invocato il metodo toString per popolare la stringa
                    Employee.class).toString();                                                                          //ogni chiamata fa riferimento ad una tupla presente nella tabella employees presente nel database associato al servizio employee-service
        }
        return s;


    }
    public String getFallbackEmployee(EmployeeIDList lista){

        return "Attualmente non è possibile raggiungere il servizio desiderato";
    }
}
