package com.progetto.projectservicedb.repository;

import com.progetto.projectservicedb.models.Progetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends JpaRepository<Progetto, String>,CrudRepository<Progetto, String> {
}
