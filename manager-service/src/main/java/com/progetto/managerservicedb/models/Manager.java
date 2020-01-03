package com.progetto.managerservicedb.models;

import javax.persistence.*;

@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @Column (name ="managerID")
    private String managerID;
    @Column (name ="nome")
    private String nome;
    @Column (name ="cognome")
    private String cognome;
    @Column (name ="stipendio")
    private float stipendio;


    public Manager() {}

    public Manager(String managerID, String nome, String cognome, float stipendio) {
        this.managerID = managerID;
        this.nome = nome;
        this.cognome = cognome;
        this.stipendio = stipendio;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public float getStipendio() {
        return stipendio;
    }

    public void setStipendio(float stipendio) {
        this.stipendio = stipendio;
    }

    @Override
    public String toString() {
        return   "Nome='" + nome + '\'' +
                ", Cognome='" + cognome +
                ", managerID='" + managerID + '\'' +
                ", Budget=" + stipendio ;

    }

    /*
    INSERT INTO managers(managerID,nome,cognome,stipendio)
    VALUES("001","Gianfranco","Cavalcanti",5000);
    INSERT INTO managers(managerID,nome,cognome,stipendio)
    VALUES("002","Giuseppe","Larato",4500);
    INSERT INTO managers(managerID,nome,cognome,stipendio)
    VALUES("003","Mauro","La Rocca",6000);
    INSERT INTO managers(managerID,nome,cognome,stipendio)
    VALUES("004","Paolo","Rossi",5500);
    * */
}
