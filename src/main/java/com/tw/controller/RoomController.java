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

import com.tw.entity.HotelRoom;
import com.tw.service.HotelRoomService;

@RestController
public class RoomController {

	private HotelRoomService service;
	
	public RoomController(HotelRoomService service) {
		this.service = service;
	}
	
	@PostMapping("/hotelId-{id}/addRoom")
	public ResponseEntity<?> saveRoom(@PathVariable Long id, @RequestBody HotelRoom room){
		boolean status = service.saveRoom(id, room);
		if(status)
			return ResponseEntity.status(HttpStatus.CREATED).body("room created successfully");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Couldn't add the room");
	}
	
	@PutMapping("/hotelId-{id}/updateRoom-{roomNo}")
	public ResponseEntity<?> updateRoom(@PathVariable Long id, @PathVariable Integer roomNo, @RequestBody HotelRoom room) {
		boolean status = service.updateRoom(id, roomNo, room);
		if(status)
			return ResponseEntity.status(HttpStatus.OK).body("room updated successfully");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Couldn't update the room");
	}
	
	@GetMapping("/hotelId-{id}/all-rooms")
	public ResponseEntity<?> getAll(@PathVariable Long id){
		List<HotelRoom> rooms = service.getAllRooms(id);
		if(rooms != null)
			return ResponseEntity.status(HttpStatus.OK).body(rooms);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Couldn't able to fetch the details");
	}
	
	@GetMapping("/hotelId-{id}/get-room-{roomNo}")
	public ResponseEntity<?> getByRoomNo(@PathVariable Long id, @PathVariable Integer roomNo) {
		HotelRoom room = service.getRoom(id, roomNo);
		if(room != null)
			return ResponseEntity.status(HttpStatus.OK).body(room);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Couldn't able to fetch the details");
	}
	
	@DeleteMapping("/hotelId-{id}/delete-room-{roomNo}")
	public ResponseEntity<?> deleteRoom(@PathVariable Long id, @PathVariable Integer roomNo) {
		boolean status = service.deleteRoom(id, roomNo);
		if(status)
			return ResponseEntity.status(HttpStatus.OK).body("room deleted successfully");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete the room details");
	}
	
}
