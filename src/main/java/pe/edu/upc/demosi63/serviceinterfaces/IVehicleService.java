package pe.edu.upc.demosi63.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.demosi63.entities.Vehicle;

import java.util.List;

public interface IVehicleService {
    public List<Vehicle> list();
    public void insertar(Vehicle v);
    public Vehicle listId(int id);
    public void update(Vehicle v);
    public void delete(int id);
    public List<Vehicle> buscarPlaca(String placa);

}
