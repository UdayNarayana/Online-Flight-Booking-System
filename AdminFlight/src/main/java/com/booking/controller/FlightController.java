package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.booking.exception.InvalidFormatException;
import com.booking.exception.InvalidUserException;
import com.booking.exception.NoDataFoundException;
import com.booking.exception.NoSuchFlightIdException;
import com.booking.model.Flight;
import com.booking.service.FlightService;
import com.booking.vo.User;

@RestController
@RequestMapping("/flight")
public class FlightController {

	private static final String PATTERN = "[a-zA-Z\\s?]{2,}";
	private static final String FLIGHT_MODEL_PATTERN = "[a-zA-Z0-9-\\s?]{2,}";
	private static final String USER_URL="http://localhost:8020/user/get-user/";
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/get-all-flights")
	public ResponseEntity<List<Flight>> getAllFlights(){
		if(flightService.getAllFlightDetails().isEmpty()) {
			throw new NoDataFoundException("There are no records to view the flight details.");
		}
		return new ResponseEntity<>(flightService.getAllFlightDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/get-flight-by-id/{userId}/{flightId}")
	public ResponseEntity<Flight> getFlightById(
			@PathVariable("flightId") int flightId,
			@PathVariable("userId") int userId){
		try {
			 restTemplate.getForObject(USER_URL + userId, User.class);
		} catch (RuntimeException ex) {
			return null;
		}
		Flight flight = flightService.getFlightByFlightId(flightId);
		if(flight==null) {
			throw new NoSuchFlightIdException("There is no flight with flight ID "+flightId);
		}
		return new ResponseEntity<>(flight,HttpStatus.OK);
	}
	
	@GetMapping("/get-flight-by-id-admin/{userId}/{flightId}")
	public ResponseEntity<Flight> getFlightByIdAdmin(
			@PathVariable("flightId") int flightId,
			@PathVariable("userId") int userId){
		Flight flight = flightService.getFlightByFlightId(flightId);
		if(flight==null) {
			throw new NoSuchFlightIdException("There is no flight with flight ID "+flightId);
		}
		User user=null;
		try {
			 user = restTemplate.getForObject(USER_URL + userId, User.class);
		} catch (RuntimeException ex) {
			return null;
		}
		if(!user.getUserType().equalsIgnoreCase("Admin")) {
			throw new InvalidUserException("Only admins can view the flight details.");
		}
		return new ResponseEntity<>(flight,HttpStatus.OK);
	}
	
	@PostMapping("/add-one-flight/{userId}")
	public ResponseEntity<String> addOneFlight(
			@RequestBody Flight flight,
			@PathVariable("userId") int userId){
		User user=null;
		try {
			 user = restTemplate.getForObject(USER_URL + userId, User.class);
		} catch (RuntimeException ex) {
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
		if(!user.getUserType().equalsIgnoreCase("Admin")) {
			throw new InvalidUserException("Only admins can add the flight details.");
		}
		if(!flight.getArrivalLoc().matches(PATTERN)||
		   !flight.getDepartureLoc().matches(PATTERN)||
		   !flight.getFleetName().matches(PATTERN)||
		   !flight.getModel().matches(FLIGHT_MODEL_PATTERN)) {
			throw new InvalidFormatException("Invalid format, please enter again.");
		}
		return new ResponseEntity<>(flightService.addOneFlight(flight),HttpStatus.OK);
	}
	
	@PutMapping("/update-flight")
	public ResponseEntity<Flight> updateFlight(
			@RequestBody Flight flight){
		return new ResponseEntity<>(flightService.updateFlightDetail(flight),HttpStatus.OK);
	}
	
	@PutMapping("/update-flight/{userId}")
	public ResponseEntity<Flight> updateFlight(
			@RequestBody Flight flight,
			@PathVariable("userId") int userId){
		User user=null;
		try {
			 user = restTemplate.getForObject(USER_URL + userId, User.class);
		} catch (RuntimeException ex) {
			return null;
		}
		if(!user.getUserType().equalsIgnoreCase("Admin")) {
			throw new InvalidUserException("Only admins can update the flight details.");
		}
		return new ResponseEntity<>(flightService.updateFlightDetail(flight),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete-flight-by-id/{userId}/{flightId}")
	public ResponseEntity<String> deleteFlightByid(
			@PathVariable("flightId") int flightId,
			@PathVariable("userId") int userId){
		User user=null;
		try {
			 user = restTemplate.getForObject(USER_URL + userId, User.class);
		} catch (RuntimeException ex) {
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
		if(!user.getUserType().equalsIgnoreCase("Admin")) {
			throw new InvalidUserException("Only admins can delete the flight details.");
		}
		Flight flight = flightService.getFlightByFlightId(flightId);
		if(flight==null) {
			throw new NoSuchFlightIdException("There is no flight with flight ID "+flightId);
		}

		return new ResponseEntity<>(flightService.deleteByFlightId(flightId),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-all-flights/{userId}")
	public ResponseEntity<String> deleteAllFlights(@PathVariable("userId") int userId){
		User user=null;
		try {
			 user = restTemplate.getForObject(USER_URL + userId, User.class);
		} catch (RuntimeException ex) {
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
		if(!user.getUserType().equalsIgnoreCase("Admin")) {
			throw new InvalidUserException("Only admins can delete the flight details.");
		}
		if(flightService.getAllFlightDetails().isEmpty()) {
			throw new NoDataFoundException("There are no records to delete the flight details.");
		}
		return new ResponseEntity<>(flightService.deleteAllFlightDetails(),HttpStatus.OK);
	}
	
	
}
