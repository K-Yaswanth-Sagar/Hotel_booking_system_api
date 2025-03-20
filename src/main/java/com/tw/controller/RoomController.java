package com.tw.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tw.entity.HotelRoom;
import com.tw.service.HotelRoomService;

@RestController
public class RoomController {

	private HotelRoomService service;
	
	public RoomController(HotelRoomService service) {
		this.service = service;
	}
	
	@PostMapping("/addRoom")
	public ResponseEntity<?> saveRoom(@RequestBody HotelRoom room){
		boolean status = service.saveRoom(room);
		if(status)
			return ResponseEntity.status(HttpStatus.CREATED).build();
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Couldn't add the room");
	}
	
}
