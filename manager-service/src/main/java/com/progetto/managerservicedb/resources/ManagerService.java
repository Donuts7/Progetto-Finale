package com.progetto.managerservicedb.resources;

import com.progetto.managerservicedb.models.Manager;
import com.progetto.managerservicedb.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();

    }

    public Manager getManager(String managerID) {
        return managerRepository.findById(managerID).get();

    }


    public void loadManager(@RequestBody final Manager manager){
        managerRepository.save(manager);

    }

    public void updateManager(String managerID, Manager manager){
        managerRepository.save(manager);
    }

    public void deleteManager(String managerID){
        managerRepository.deleteById(managerID);
    }

}
