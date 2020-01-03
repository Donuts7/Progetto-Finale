package com.progetto.managerservicedb.resources;

import com.progetto.managerservicedb.models.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

                                                                                                                         //i metodi presenti in questa classe sono i medesimi di quelli presenti nella classe EmployeeResource, del microservizio employeeproject
@RestController
public class ManagerResource {

    @Autowired
    private ManagerService managerService;



    @RequestMapping("/managers")
    public List<Manager> getAllManagers(){

        return managerService.getAllManagers();
    }


    @RequestMapping("/managers/{managerID}")
    public Manager getManager(@PathVariable String managerID) {                                                          //metodo chiamato dal serivizio project-service. In particolare fa riferimento
        List<String> lista = new ArrayList<>();                                                                          //al metodo omonimo getManaer, presente in getOverview, in ProjectResource
        for(int i=0;i<managerService.getAllManagers().size();i++){
           lista.add(managerService.getAllManagers().get(i).getManagerID());
        }
        if(lista.contains(managerID)){
            return managerService.getManager(managerID);
        }else return null;
    }

    @RequestMapping(method = RequestMethod.POST, value="/managers")
    public void addManager(@RequestBody final Manager manager){
        managerService.loadManager(manager);

    }

    @RequestMapping(method = RequestMethod.PUT, value="/managers/{managerID}")
    public void updateManager(@RequestBody Manager manager, @PathVariable String managerID){
        List<String> lista = new ArrayList<>();
        for(int i=0;i<managerService.getAllManagers().size();i++){
            lista.add(managerService.getAllManagers().get(i).getManagerID());
        }
        if(lista.contains(managerID)){
        managerService.updateManager(managerID,manager);}

    }

    @RequestMapping(method = RequestMethod.DELETE, value="/managers/{managerID}")
    public void deleteManager(@PathVariable  String managerID){
        List<String> lista = new ArrayList<>();
        for(int i=0;i<managerService.getAllManagers().size();i++){
            lista.add(managerService.getAllManagers().get(i).getManagerID());
        }
        if(lista.contains(managerID)){
        managerService.deleteManager(managerID);}

    }
}
