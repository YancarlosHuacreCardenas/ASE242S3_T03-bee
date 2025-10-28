package pe.edu.vallegrande.demo.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.demo.model.TableSpot;
import pe.edu.vallegrande.demo.service.TableSpotService;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
@RequiredArgsConstructor
public class TableSpotRest {

    private final TableSpotService service;

    @GetMapping
    public List<TableSpot> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TableSpot getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public TableSpot create(@RequestBody TableSpot tableSpot) {
        return service.create(tableSpot);
    }

    @PutMapping("/{id}")
    public TableSpot update(@PathVariable Integer id, @RequestBody TableSpot tableSpot) {
        return service.update(id, tableSpot);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
