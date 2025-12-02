package pe.edu.vallegrande.demo.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.demo.model.AdminUser;
import pe.edu.vallegrande.demo.service.AdminUserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminUserRest {

    private final AdminUserService service;

    @PostMapping("/login")
    public Optional<AdminUser> login(@RequestBody AdminUser user) {
        return service.login(user.getUsername(), user.getPassword());
    }

    @GetMapping("/users")
    public List<AdminUser> getAllUsers() {
        return service.getAllUsers();
    }
}
