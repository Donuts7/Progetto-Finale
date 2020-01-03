package com.progetto.projectservicedb.models;

import javax.persistence.*;

@Entity
@Table(name="projects")
public class Progetto {

    @Id
    @Column(name= "projectID")
    private String projectID;
    @Column(name= "nome")
    private String nome;
    @Column(name= "descrizione")
    private String descrizione;
    @Column(name= "budget")
    private float budget;
    @Column(name ="managerID")
    private String managerID;
    //ad ogni progetto viene assegnato un solo manager


    public Progetto() {}

    public Progetto(String nome, String descrizione,String projectID, float budget,String managerID) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.budget = budget;
        this.projectID=projectID;
        this.managerID = managerID;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getProjectID() {return projectID;}

    public void setProjectID(String projectID) {this.projectID = projectID;}

    @Override
    public String toString() {
        return
                " Nome del progetto: " + nome +
                ", Descrizione: " + descrizione +
                ", Budget: " + budget +
                ", projectID: " + projectID;
    }
    /*
update  projects
set     managerID = "002"
where   projectID = "002";
update  projects
set     managerID = "003"
where   projectID = "003";
update  projects
set     managerID = "004"
where   projectID = "004";
update  projects
set     managerID = "005"
where   projectID = "005";*/
}
