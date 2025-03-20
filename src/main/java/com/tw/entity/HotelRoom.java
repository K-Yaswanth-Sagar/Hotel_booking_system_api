package com.tw.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="hotel_rooms")
public class HotelRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "room_number")
	private Integer roomNo;
	
	@Column(name = "room_type")
	private String type;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "is_booked")
	private boolean isBooked;
	
}
