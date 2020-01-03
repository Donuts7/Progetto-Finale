package com.progetto.projectservicedb.models;


public class Manager {                                         //i commenti riferiti a questa classe sono i medesimi di quelli fatti nella classe Employee


    private String managerID;

    private String nome;

    private String cognome;

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
    public String toString() throws NullPointerException{
        return   " Nome: " + nome +
                ", Cognome: " + cognome +
                ", Stipendio: " + stipendio +
                ", managerID: " + managerID;

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
