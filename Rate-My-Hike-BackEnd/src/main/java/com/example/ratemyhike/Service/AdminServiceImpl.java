package com.example.ratemyhike.Service;

import com.example.ratemyhike.Exceptions.AdminAccountWithEmailAlreadyPresentException;
import com.example.ratemyhike.Exceptions.AdminAccountWithTheIDAlreadyPresentException;
import com.example.ratemyhike.Exceptions.AdminAccountWithTheIDDoesntExistException;
import com.example.ratemyhike.Model.Admin;
import com.example.ratemyhike.Repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

@Autowired
private AdminRepo adminRepository;

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Long id) throws AdminAccountWithTheIDDoesntExistException {
        Optional<Admin> optional = adminRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        throw new AdminAccountWithTheIDDoesntExistException();
    }

    @Override
    public Admin addNewAdmin(Admin admin) throws AdminAccountWithTheIDAlreadyPresentException, AdminAccountWithEmailAlreadyPresentException {
//        Optional<Admin> optional = adminRepository.findById(admin.getAdminId());
        Optional<Admin> optional = adminRepository.findAdminByEmail(admin.getEmail());

        if(adminRepository.existsById(admin.getAdminId())){
            admin.setAdminId(admin.getAdminId()+1);
            addNewAdmin(admin);
        }

        if(optional.isEmpty()) {
            adminRepository.save(admin);
            return admin;
        }
//        throw new AdminAccountWithTheIDAlreadyPresentException();
        throw new AdminAccountWithEmailAlreadyPresentException();
    }


    @Override
    public void deleteAdmin(Long id) throws AdminAccountWithTheIDDoesntExistException {
        Optional<Admin> optional = adminRepository.findById(id);
        if (optional.isPresent()){
            optional.get();
        }
        throw new AdminAccountWithTheIDDoesntExistException();
    }

    @Override
    public Admin updateAdmin(Admin admin) throws AdminAccountWithTheIDDoesntExistException {
        Optional<Admin> adminOptional = adminRepository.findById(admin.getAdminId());
        if (adminOptional.isPresent()){
            adminRepository.save(admin);

            return adminOptional.get();
        }
        throw new AdminAccountWithTheIDDoesntExistException();
    }

    @Override
    public Admin verifyAdmin(String username, String password) throws AdminAccountWithTheIDDoesntExistException {
        return null;
    }
}
