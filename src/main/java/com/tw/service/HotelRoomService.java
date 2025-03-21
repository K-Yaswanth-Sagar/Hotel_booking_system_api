package com.tw.service;

import java.util.List;

import com.tw.entity.HotelRoom;

public interface HotelRoomService {

	boolean saveRoom(Long id, HotelRoom hotelRoom);
	boolean updateRoom(Long id, Integer roomNo,  HotelRoom hotelRoom);
	List<HotelRoom> getAllRooms(Long id);
	HotelRoom getRoom(Long id, Integer roomNo);
	boolean deleteRoom(Long id, Integer roomNo);
	
}
