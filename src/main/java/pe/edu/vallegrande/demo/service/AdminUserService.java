package pe.edu.vallegrande.demo.service;

import pe.edu.vallegrande.demo.model.AdminUser;
import java.util.List;
import java.util.Optional;

public interface AdminUserService {
    Optional<AdminUser> login(String username, String password);
    List<AdminUser> getAllUsers();
}
