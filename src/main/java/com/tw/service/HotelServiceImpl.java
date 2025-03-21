package com.tw.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tw.entity.Hotel;
import com.tw.repo.HotelRepo;
import com.tw.repo.HotelRoomRepo;

@Service
public class HotelServiceImpl implements HotelService {
	
	private HotelRepo repo;
	private HotelRoomRepo hrr;
	public HotelServiceImpl(HotelRepo repo, HotelRoomRepo hrr) {
		this.repo = repo;
		this.hrr = hrr;
	}

	@Override
	public boolean addHotel(Hotel hotel) {
		if (hotel == null) {
	        throw new IllegalArgumentException("hotel object cannot be null");
	    }
	    repo.save(hotel);
	    return true;
	}

	@Override
	public boolean updateHotel(Long id, Hotel hotel) {
		Hotel h = repo.findById(id).get();
		h.setName(hotel.getName());
		h.setHotelAddress(hotel.getHotelAddress());
		repo.save(h);
		return true;
	}

	@Override
	public List<Hotel> getAllHotels() {
		return repo.findAll();
	}

	@Override
	public Hotel getHotelById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	@Transactional
	public boolean deleteHotel(Long id) {
		
		 Hotel hotel = repo.findById(id)
		            .orElseThrow(() -> new IllegalArgumentException("Hotel not found"));

		    hrr.deleteByHotel(hotel);

		    repo.delete(hotel);
		    return true;
	}

}
