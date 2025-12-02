package pe.edu.vallegrande.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.demo.model.AdminUser;
import pe.edu.vallegrande.demo.repository.AdminUserRepository;
import pe.edu.vallegrande.demo.service.AdminUserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminUserServiceImpl implements AdminUserService {

    private final AdminUserRepository repository;

    @Override
    public Optional<AdminUser> login(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<AdminUser> getAllUsers() {
        return repository.findAll();
    }
}
