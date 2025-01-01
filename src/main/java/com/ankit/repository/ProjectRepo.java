package com.ankit.repository;

import com.ankit.modal.Project;
import com.ankit.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Long> {
//    List<Project> findByOwner(User user);

    List<Project> findByNameContainingAndTeamContaining(String partialName, User user);

//    @Query("SELECT p FROM Project p join p.team t where t=:user")
//    List<Project> findProjectByTeam(@Param("user") User user);

//    @Query("SELECT p FROM Project p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%')) " +
//            "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :query, '%'))")
//    List<Project> searchByQuery(@Param("query") String query);

    List<Project> findByTeamContainingOrOwner(User user, User owner);
}
