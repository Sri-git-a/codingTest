package com.example.demo.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.VehicleException;
import com.example.demo.modal.Vehicle;
import com.example.demo.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicle-api/v1/vehicles")
public class VehicleController {

	
	
	
	  @Autowired 
	  private VehicleRepository vehicleRepository;
	 
	  
	  @PostMapping("/vehicle")
	  public ResponseEntity<String> createVehicle(@Valid @RequestBody Vehicle vehicle) throws VehicleException {
		  UUID uuid = UUID.randomUUID();
		  vehicle.setId(uuid);
		  System.out.println(vehicle.getId());
		  System.out.println(vehicle.getYear());
		  System.out.println(vehicle.getVin());
		  System.out.println(vehicle.getMake());
		  System.out.println(vehicle.getModel());
		  System.out.println(vehicle.getTransmissionType());
		  if(vehicle.getTransmissionType().equalsIgnoreCase("MANUAL") || vehicle.getTransmissionType().equalsIgnoreCase("AUTO")) {
			  vehicleRepository.save(vehicle);
		  return new ResponseEntity<>(vehicle.getId().toString(), HttpStatus.OK);
		  }
		  else {
			  throw new VehicleException("Invalid Transmission Type");
		  }
	  }
	  
}

