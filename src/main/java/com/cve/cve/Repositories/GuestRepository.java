package com.cve.cve.Repositories;

import java.util.List;

import com.cve.cve.Models.Guest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    List<Guest> findByVisibleTrue();
}