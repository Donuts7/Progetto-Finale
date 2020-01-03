package com.progetto.projectservicedb.resources;


import com.progetto.projectservicedb.models.Progetto;
import com.progetto.projectservicedb.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;


    public List<Progetto> getAllProjects() {
        return projectRepository.findAll();

    }

    public Progetto getProject(String projectID){
        return projectRepository.findById(projectID).get();

    }



    public void loadProject(@RequestBody final Progetto progetto){
        projectRepository.save(progetto);

    }

    public void updateProject( Progetto project){
        projectRepository.save(project);
    }

    public void deleteProject(String projectID){
        projectRepository.deleteById(projectID);
    }
}
