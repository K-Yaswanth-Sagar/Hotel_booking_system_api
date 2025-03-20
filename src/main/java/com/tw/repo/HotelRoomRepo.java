package com.tw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.entity.HotelRoom;

public interface HotelRoomRepo extends JpaRepository<HotelRoom, Long> {

}
