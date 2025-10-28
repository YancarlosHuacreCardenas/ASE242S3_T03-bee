package pe.edu.vallegrande.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.demo.model.TableSpot;
import pe.edu.vallegrande.demo.repository.TableSpotRepository;
import pe.edu.vallegrande.demo.service.TableSpotService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TableSpotServiceImpl implements TableSpotService {

    private final TableSpotRepository repository;

    @Override
    public List<TableSpot> getAll() {
        return repository.findAll();
    }

    @Override
    public TableSpot getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TableSpot create(TableSpot tableSpot) {
        return repository.save(tableSpot);
    }

    @Override
    public TableSpot update(Integer id, TableSpot tableSpot) {
        if (!repository.existsById(id)) return null;
        tableSpot.setTableId(id);
        return repository.save(tableSpot);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
