package com.tw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {

}
