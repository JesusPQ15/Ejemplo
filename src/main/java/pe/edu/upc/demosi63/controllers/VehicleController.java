package pe.edu.upc.demosi63.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demosi63.dtos.VehicleDTO;
import pe.edu.upc.demosi63.entities.Vehicle;
import pe.edu.upc.demosi63.serviceinterfaces.IVehicleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehiculos")
public class VehicleController {

    @Autowired
    private IVehicleService vS;

    @GetMapping
    public List<VehicleDTO> listar() {

        return vS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VehicleDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody VehicleDTO dto) {
        ModelMapper m = new ModelMapper();
        Vehicle ve = m.map(dto, Vehicle.class);
        vS.insertar(ve);
    }
    @GetMapping("/{id}")
    public VehicleDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        VehicleDTO dto=m.map(vS.listId(id),VehicleDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody VehicleDTO dto) {
        ModelMapper m = new ModelMapper();
        Vehicle ve = m.map(dto, Vehicle.class);
        vS.update(ve);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        vS.delete(id);
    }
    @GetMapping("/busquedas")
    public List<VehicleDTO> buscar(@RequestParam String placa) {

        return vS.buscarPlaca(placa).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VehicleDTO.class);
        }).collect(Collectors.toList());
    }
}
