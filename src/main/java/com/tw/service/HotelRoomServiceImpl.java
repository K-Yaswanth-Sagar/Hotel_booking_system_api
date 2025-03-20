package com.tw.service;

import org.springframework.stereotype.Service;

import com.tw.entity.HotelRoom;
import com.tw.repo.HotelRoomRepo;

@Service
public class HotelRoomServiceImpl implements HotelRoomService {

	private HotelRoomRepo repo;
	
	public HotelRoomServiceImpl(HotelRoomRepo repo) {
		this.repo = repo;
	}
	
	public boolean saveRoom(HotelRoom hotelRoom) {
		return repo.save(hotelRoom) != null;
		
	}
	
}
