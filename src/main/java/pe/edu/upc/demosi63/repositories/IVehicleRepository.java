package pe.edu.upc.demosi63.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demosi63.entities.Vehicle;


import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle,Integer> {
    @Query("select ve FROM Vehicle ve where ve.plateVehicle like %:placa%")
    public List<Vehicle> buscarPlaca(@Param("placa") String placa);
}

