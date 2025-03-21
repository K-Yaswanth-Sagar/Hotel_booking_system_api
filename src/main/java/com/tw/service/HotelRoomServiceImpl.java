package com.tw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tw.entity.Hotel;
import com.tw.entity.HotelRoom;
import com.tw.repo.HotelRepo;
import com.tw.repo.HotelRoomRepo;

@Service
public class HotelRoomServiceImpl implements HotelRoomService {

	private HotelRoomRepo roomRepo;
	private HotelRepo hotelRepo;
	public HotelRoomServiceImpl(HotelRoomRepo roomRepo, HotelRepo hotelRepo) {
		this.roomRepo = roomRepo;
		this.hotelRepo = hotelRepo;
	}
	
	public boolean saveRoom(Long id, HotelRoom hotelRoom) {
		
		Hotel hotel = hotelRepo.findById(id).orElseThrow(() -> 
        new IllegalArgumentException("Hotel with ID " + id + " not found"));

		hotelRoom.setHotel(hotel);
		roomRepo.save(hotelRoom);
	    return true;
		
	}


	@Override
	public boolean updateRoom(Long id, Integer roomNo, HotelRoom hotelRoom) {
		Hotel hotel = hotelRepo.findById(id).orElseThrow(() -> 
        new IllegalArgumentException("Hotel with ID " + id + " not found"));

		hotelRoom.setHotel(hotel);
		HotelRoom h = roomRepo.findByRoomNo(roomNo).orElseThrow(() -> 
		new IllegalArgumentException("Room with number " + roomNo + " not found in hotel ID " + id));

		h.setPrice(hotelRoom.getPrice());
		h.setType(hotelRoom.getType());;
		roomRepo.save(h);
		
		return true;
	}


	@Override
	public List<HotelRoom> getAllRooms(Long id) {

		Hotel hotel = hotelRepo.findById(id).orElseThrow(() -> 
        new IllegalArgumentException("Hotel with ID " + id + " not found"));
		
		return roomRepo.findByHotel(hotel);
	}


	@Override
	public HotelRoom getRoom(Long id, Integer roomNo) {
		
		Hotel hotel = hotelRepo.findById(id).orElseThrow(() -> 
        new IllegalArgumentException("Hotel with ID " + id + " not found"));
		
		HotelRoom h = roomRepo.findByHotelAndRoomNo(hotel, roomNo).orElseThrow(() -> 
		new IllegalArgumentException("Room with number " + roomNo + " not found in hotel ID " + id));
		
		return h;
	}


	@Override
	public boolean deleteRoom(Long id, Integer roomNo) {
		Hotel hotel = hotelRepo.findById(id).orElseThrow(() -> 
        new IllegalArgumentException("Hotel with ID " + id + " not found"));
		
		HotelRoom room = roomRepo.findByHotelAndRoomNo(hotel, roomNo).orElseThrow(() -> 
		new IllegalArgumentException("Room with number " + roomNo + " not found in hotel ID " + id));
		roomRepo.delete(room);
		return true;
	}
	
}
