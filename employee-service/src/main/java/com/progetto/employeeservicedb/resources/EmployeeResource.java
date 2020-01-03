package com.progetto.employeeservicedb.resources;

import com.progetto.employeeservicedb.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;



@RestController
public class EmployeeResource {


    @Autowired
    private EmployeeService employeeService;
    @Autowired
    public RestTemplate restTemplate;


    @RequestMapping("/employees")
    public List<Employee> getAllEmployee(){                                                                              //visualizza la lista contenente tutti i dipendenti

        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employeeidlist/{projectID}")
        public EmployeeIDList getEmployeeIDList(@PathVariable String projectID){                                         //metodo che restituisce una lista di employeeID. E' il metodo che viene chiamato dal servizio project-service.
        List<String> lista = new ArrayList<>();                                                                          //in particolare esso viene chiamato dal metodo getEmployeeIDList, che si trova all'interno del metodo getOverview, in ProjectResource
        for(int i=0;i<employeeService.getAllEmployeeProject().size();i++){
            lista.add(employeeService.getAllEmployeeProject().get(i).getProjectID());
        }
            if(lista.contains(projectID)){                                                                               //verifica che in ''lista'', composta da tutti i projectID presenti nel database, sia effettivamente presente il projectID dato in ingresso
               EmployeeProjectList list = new EmployeeProjectList();                                                     //se esso è presente, si procede con la creazione di una istanza della classe EmployeeProjectList, ovvero di una lista contenente oggetti EmployeeProject
               list.setLista(employeeService.getEmployeeProjectList(projectID));                                         //da questa lista viene quindi estrapolata una seconda lista, contentente solo gli employeeID dei dipendenti assegnati al progetto
               return new EmployeeIDList(list.getEmployeeIDList());                                                      //ciò avviene sttraverso l'invocazione del metodo getEmployeeIDList, presente nella classe EmployeeProjectList
            }else return null;
    }                                                                                                                    //se il projectID non è presente nel database, viene restituito null


    @RequestMapping("/employees/{employeeID}")                                                                           //visualizza il dipendente associato all'ID inserito
    public Employee getEmployee(@PathVariable String employeeID){                                                        //è il metodo che, quando chiamato dal servizio project-service, resituisce un'istanza di Employee
        List<String> lista = new ArrayList<>();                                                                          //in particolare, questo metodo viene chiamato dall'omonimo metodo getEmployee, che si trova in getOverwiev, in ProjectResource
        for(int i=0;i<employeeService.getAllEmployees().size();i++){
            lista.add(employeeService.getAllEmployees().get(i).getEmployeeID());
        }
            if (lista.contains(employeeID)) {                                                                            //stesso controllo presente nel metodo precedente, con la differenza che qui viene valutato l'employeeID anzichè il projectID
                return employeeService.getEmployee(employeeID);
            } else
               return null;

    }


    @RequestMapping(method = RequestMethod.POST, value="/employees")                                                     //inserisce un nuovo dipendente nel database
    public void addEmployee(@RequestBody final Employee employee){
        employeeService.loadEmployee(employee);

    }

    @RequestMapping(method = RequestMethod.PUT, value="/employees/{employeeID}")                                        //modifica un dipendente già presente nel database
    public void updateEmployee(@RequestBody Employee employee, @PathVariable String employeeID){
        List<String> lista = new ArrayList<>();
        for(int i=0;i<employeeService.getAllEmployees().size();i++){
            lista.add(employeeService.getAllEmployees().get(i).getEmployeeID());
        }
        if (lista.contains(employeeID)) {
        employeeService.updateEmployee(employee);}

    }

    @RequestMapping(method = RequestMethod.DELETE, value="/employees/{employeeID}")                                      //elimina un dipendente dal database
    public void deleteEmployee(@PathVariable  String employeeID){
        List<String> lista = new ArrayList<>();
        for(int i=0;i<employeeService.getAllEmployees().size();i++){
            lista.add(employeeService.getAllEmployees().get(i).getEmployeeID());
        }
        if (lista.contains(employeeID)) {
        employeeService.deleteEmployee(employeeID);}

    }
    @RequestMapping("/employeeproject/{projectID}")                                                                      //restituisce una lista di EmployeeProject, riferita ad un determinato progetto.
    public List<EmployeeProject> getEmployeeProjectList(@PathVariable String projectID){
        return employeeService.getEmployeeProjectList(projectID);
    }


    @RequestMapping(method = RequestMethod.POST, value="/employeeproject")                                               //aggiunge una tupla alla tabella employeeproject presente nel database
    public void addEmployeeProject(@RequestBody EmployeeProject employeeProject){                                        //l'oggetto passato in input tramite Postman dovrà essere EmployeeProject
        List<String> lista = new ArrayList<>();
        for(int i=0;i<employeeService.getAllEmployees().size();i++){
            lista.add(employeeService.getAllEmployees().get(i).getEmployeeID());
        }



        if (lista.contains(employeeProject.getEmployeeID()) &&
             restTemplate.getForObject("http://project-discovery/projectsID",
                     ProjectIDList.class).contiene(employeeProject.getProjectID())){
                      employeeService.loadEmployeeProject(employeeProject);}

    }

    @RequestMapping(method = RequestMethod.DELETE, value="/employeeproject")                                             //elimina dal database la tupla contenente l'oggetto passato in input
    public void deleteEmployeeProject(@RequestBody EmployeeProject employeeProject){
        List<String> lista = new ArrayList<>();
        for(int i=0;i<employeeService.getAllEmployees().size();i++){
            lista.add(employeeService.getAllEmployees().get(i).getEmployeeID());
        }
        if (lista.contains(employeeProject.getEmployeeID())){
             employeeService.deleteEmployeeProject(employeeProject);
        }

    }


















}
