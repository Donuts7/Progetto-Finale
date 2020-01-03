package com.progetto.projectservicedb.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.progetto.projectservicedb.models.Manager;
import com.progetto.projectservicedb.resources.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class ManagerService {                                                                                            //in questa classe è contenuta la chiamata al servizio manager-service
                                                                                                                         //in particolare viene passata un'istanza della classe Manager, che è presente nel database riferito al suddetto servizio
    @Autowired                                                                                                           //l'istanza viene poi convertita in una stringa, che rappresenta l'output del metodo getManager presente in questa classe
    private ProjectService projectService;

    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackManager")
    public String getManager(@PathVariable String projectID) {
        try{                                                                                                             //il blocco try/catch è necessario, in quanto distingue il caso in cui il servizio manager-service non sia attivo dal
        return restTemplate.getForObject("http://manager-discovery/managers/"+                                       //caso in cui al progetto non corrisponda alcun managerID. Infatti, se si verifica quest'ultima circostanza, viene lanciata
                projectService.getProject(projectID).getManagerID(), Manager.class).toString();                          //una eccezione NullPointerException, che viene riconosciuta dal try/catch, che restituisce una stringa, impedendo la chiamata a getFallbackManager.
           }catch (NullPointerException e){                                                                              //senza blocco try catch, il metodo getFallbackManager sarebbe stato invocato anche nel caso in cui il servizio fosse funzionante, ma al progetto
            return " A questo progetto non è stato ancora assegnato alcun manager";                                      //in considerazione non fosse stato assegnato alcun managerID
        }
    }
    public String getFallbackManager(@PathVariable String projectID){

        return " Attualmente non è possibile raggiungere il servizio desiderato";
    }
}
