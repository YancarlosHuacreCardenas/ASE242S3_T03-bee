package pe.edu.vallegrande.demo.service;

import pe.edu.vallegrande.demo.model.TableSpot;
import java.util.List;

public interface TableSpotService {
    List<TableSpot> getAll();
    TableSpot getById(Integer id);
    TableSpot create(TableSpot tableSpot);
    TableSpot update(Integer id, TableSpot tableSpot);
    void delete(Integer id);
}
