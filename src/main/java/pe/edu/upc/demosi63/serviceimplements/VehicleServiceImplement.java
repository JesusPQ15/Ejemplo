package pe.edu.upc.demosi63.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demosi63.entities.Vehicle;
import pe.edu.upc.demosi63.repositories.IVehicleRepository;
import pe.edu.upc.demosi63.serviceinterfaces.IVehicleService;

import java.util.List;

@Service
public class VehicleServiceImplement implements IVehicleService {
    @Autowired
    private IVehicleRepository vR;

    @Override
    public List<Vehicle> list() {
        return vR.findAll();
    }

    @Override
    public void insertar(Vehicle v) {
        vR.save(v);
    }

    @Override
    public Vehicle listId(int id) {
        return vR.findById(id).orElse(new Vehicle());
    }

    @Override
    public void update(Vehicle v) {
        vR.save(v);
    }

    @Override
    public void delete(int id) {
        vR.deleteById(id);
    }

    @Override
    public List<Vehicle> buscarPlaca(String placa) {
        return vR.buscarPlaca(placa);
    }
}
