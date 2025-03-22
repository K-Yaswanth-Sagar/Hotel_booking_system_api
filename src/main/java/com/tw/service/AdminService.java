package com.tw.service;

import com.tw.entity.Admin;
import java.util.List;

public interface AdminService {
    Admin createAdmin(Admin admin);
    Admin updateAdmin(Long id, Admin admin);
    void deleteAdmin(Long id);
    List<Admin> getAllAdmins();
}
