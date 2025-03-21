package com.tw.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tw.entity.Hotel;
import com.tw.service.HotelService;

@RestController
public class HotelController {

	private HotelService service;
	public HotelController(HotelService service) {
		this.service = service;
	}
	
	@PostMapping("/addHotel")
	public ResponseEntity<?> addHotel(@RequestBody Hotel hotel){
		boolean status = service.addHotel(hotel);
		if(status)
			return ResponseEntity.status(HttpStatus.CREATED).body("hotel created successfully");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Couldn't add the hotel");
	}
	
	@PutMapping("/updateHotel-{id}")
	public ResponseEntity<?> updateHotel(@PathVariable Long id, @RequestBody Hotel hotel){
		boolean status = service.updateHotel(id, hotel);
		if(status)
			return ResponseEntity.status(HttpStatus.CREATED).body("hotel updated successfully");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Couldn't update the hotel");
	}
	
	@GetMapping("/get-hotel-list")
	public ResponseEntity<?> getAll(){
		
		List<Hotel> hotels = service.getAllHotels();
		if(hotels != null)
			return ResponseEntity.status(HttpStatus.OK).body(hotels);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Couldn't able to fetch the details");
	}
		
	
	@GetMapping("/get-by-id-{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		
		Hotel hotel = service.getHotelById(id);
		if(hotel != null)
			return ResponseEntity.status(HttpStatus.OK).body(hotel);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Couldn't able to fetch the details");
	}
		
	
	@DeleteMapping("/delete-{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		boolean status = service.deleteHotel(id);
		if(status)
			return ResponseEntity.status(HttpStatus.OK).body("hotel deleted successfully");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete the room details");
	}
		
	
}
