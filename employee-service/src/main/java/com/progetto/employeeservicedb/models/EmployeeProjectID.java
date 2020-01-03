package com.progetto.employeeservicedb.models;

import java.io.Serializable;

public class EmployeeProjectID implements Serializable {

    private String employeeID;
    private String projectID;

    public EmployeeProjectID(){}

    public EmployeeProjectID(String employeeID, String projectID) {
        this.employeeID = employeeID;
        this.projectID = projectID;
    }
}

//questa classe serve a fare in modo che per EmployeeProject sia possibile avere una chiave composta sia dall'employeeID
//che dal projectID. In questo modo viene rispettato il modello presente nel database a cui questo microservizio fa riferimento
