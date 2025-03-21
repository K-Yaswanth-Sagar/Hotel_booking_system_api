package com.tw.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.entity.Hotel;
import com.tw.entity.HotelRoom;

public interface HotelRoomRepo extends JpaRepository<HotelRoom, Long> {
	void deleteByHotel(Hotel hotel); 
	Optional<HotelRoom> findByRoomNo(Integer roomNo);
	List<HotelRoom> findByHotel(Hotel hotel);
	Optional<HotelRoom> findByHotelAndRoomNo(Hotel hotel, Integer roomNo);
}
