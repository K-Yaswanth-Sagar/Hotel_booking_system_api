package com.tw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Long> {

}
