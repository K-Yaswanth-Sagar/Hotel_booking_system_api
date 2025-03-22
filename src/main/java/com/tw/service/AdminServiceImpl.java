package com.tw.service;

import com.tw.entity.Admin;
import com.tw.repo.AdminRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepo;

    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {
        Admin existingAdmin = adminRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Admin not found"));

        existingAdmin.setUsername(admin.getUsername());
        existingAdmin.setPassword(admin.getPassword());

        return adminRepo.save(existingAdmin);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepo.deleteById(id);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }
}
