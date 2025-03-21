package com.tw.service;

import java.util.List;

import com.tw.entity.Hotel;

public interface HotelService {
	
	boolean addHotel(Hotel hotel);
	boolean updateHotel(Long id, Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotelById(Long id);
	boolean deleteHotel(Long id);
	
}
