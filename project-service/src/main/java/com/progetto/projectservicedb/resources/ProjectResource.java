package com.progetto.projectservicedb.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.progetto.projectservicedb.models.*;
import com.progetto.projectservicedb.services.EmployeeIDListService;
import com.progetto.projectservicedb.services.EmployeeService;
import com.progetto.projectservicedb.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ProjectResource {

    @Autowired
    private ProjectService projectService;

    @Autowired
    public RestTemplate restTemplate;                                                                                    //grazie al restTemplate sarà possibile comunicare con gli altri microservizi attivi

    @Autowired
    ManagerService managerService;                                                                                       //ManagerService, insieme a EmployeeService ed EmployeeIDListService, sono necessari al fine del funzionamento corretto di Hystrix

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeIDListService employeeIDListService;


    @RequestMapping("/overview/{projectID}")
    public String getOverview(@PathVariable  String projectID){                                                          //metodo che fornisce una overview complessiva di ogni progetto: verrà stampato a video il progetto associato al projectID dato in input
        List<String> lista1 = new ArrayList<>();                                                                         //insieme ai dati del manager del progetto,con essi viene anche fornita a video la lista dei dipendenti assegnati al progetto
        for(int i=0;i<projectService.getAllProjects().size();i++){
            lista1.add(projectService.getAllProjects().get(i).getProjectID());
        }
           if(lista1.contains(projectID)){                                                                               //lista1 serve a verificare che il projectID dato in input sia effettivamente presente nel database
                                                                                                                         //essa viene infatti popolata da tutti i projectID (String) presenti nel databse. Su di essa viene infine chiamato il metodo contains()
               String s ="Overview del progetto \n" + projectService.getProject(projectID).toString() + " \nManager: \n";

               s+= managerService.getManager(projectID);
                                                                                                                         //invocazione del metodo getManager, presente in ManagerService, ove è contenuta la chiamata al microservizio manager-service
                                                                                                                         //(senza l'implementazione di Hystrix non sarebbe stato necessario invocare un metodo appartenente ad un'altra classe, in quanto
                                                                                                                         //la chiamata sarebbe stata fatta direttamente qui, in ProjectResource. Le stesse considerazioni valgono per i metodi getEmployeeIDList e getEmployee)
               s += "\nDipendenti assegnati al progetto: ";
               EmployeeIDList lista = employeeIDListService.getEmployeeIDList(projectID);                                //invocazione del metodo getEmployeeIDList, presente in EmloyeeIDListService


               if(lista!=null){
                   s += "\n"+ employeeService.getEmployee(lista);                                                        //invocazione del metodo getEmployee, presente in EmployeeService
               }else s+= "\n A questo progetto non è stato ancora assegnato alcun dipendente ";                          //nel caso in cui la lista, denominata ''lista'', restituita dal metodo  getEmployeeIDList, risulti null, viene inserito nella
                                                                                                                         //stringa ''s'' il messaggio qui indicato

         return s;


        }else return null;
                                                                                                                         //se il controllo non viene rispettato, non viene stampata alcuna stringa
    }


    @RequestMapping("/projects")                                                                                         //la descrizione dei metodi a seguire è la medesima di quella nella classe EmployeeRescource del microservizio employee-service
    public List<Progetto> getAllProjects(){
        return projectService.getAllProjects();
    }

    @RequestMapping("/projectsID")                                                                                         //la descrizione dei metodi a seguire è la medesima di quella nella classe EmployeeRescource del microservizio employee-service
    public ProjectIDList getAllProjectsID(){
        List<String> lista = new ArrayList<>();
        for(int i=0;i<projectService.getAllProjects().size();i++){
            lista.add(projectService.getAllProjects().get(i).getProjectID());
    } ProjectIDList lista1 = new ProjectIDList(lista);
        return lista1;
    }


    @RequestMapping("/projects/{projectID}")
    public Progetto getProject(@PathVariable String projectID){
        List<String> lista = new ArrayList<>();
        for(int i=0;i<projectService.getAllProjects().size();i++){
            lista.add(projectService.getAllProjects().get(i).getProjectID());
        }
        if(lista.contains(projectID)){
           return projectService.getProject(projectID);
        }else return null;
    }


    @RequestMapping(method = RequestMethod.POST, value="/projects")
    public void addProject(@RequestBody final Progetto progetto){
        projectService.loadProject(progetto);

    }

    @RequestMapping(method = RequestMethod.PUT, value="/projects/{projectID}")
    public void updateProject(@RequestBody Progetto progetto, @PathVariable String projectID){
        List<String> lista = new ArrayList<>();
        for(int i=0;i<projectService.getAllProjects().size();i++){
            lista.add(projectService.getAllProjects().get(i).getProjectID());
        }
        if(lista.contains(projectID)){
       projectService.updateProject(progetto);}

    }

    @RequestMapping(method = RequestMethod.DELETE, value="/projects/{projectID}")
    public void deleteProject(@PathVariable  String projectID){
        List<String> lista = new ArrayList<>();
        for(int i=0;i<projectService.getAllProjects().size();i++){
            lista.add(projectService.getAllProjects().get(i).getProjectID());
        }
        if(lista.contains(projectID)){
        projectService.deleteProject(projectID);}

    }


}
