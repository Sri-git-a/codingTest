package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {}