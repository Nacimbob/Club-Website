package com.cve.cve.Repositories;

import java.util.List;

import com.cve.cve.Enumeration.CollaboratorType;
import com.cve.cve.Models.Collaborator;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CollaboratorRepository
 */
public interface CollaboratorRepository extends JpaRepository<Collaborator,Long> {
   
    List<Collaborator> findByVisibleTrue();
    List<Collaborator> findByVisibleTrueAndGlobaleTrue();
    List<Collaborator> findAllByOrderByIdAsc();
    List<Collaborator> findByVisibleTrueAndGlobaleTrueAndEvents_Id(Long id);
	Long countByCollaboratorType(CollaboratorType collaboratorType);

}