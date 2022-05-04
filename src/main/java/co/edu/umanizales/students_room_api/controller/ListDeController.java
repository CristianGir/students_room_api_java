package co.edu.umanizales.students_room_api.controller;

import co.edu.umanizales.students_room_api.model.Node;
import co.edu.umanizales.students_room_api.model.Pet;
import co.edu.umanizales.students_room_api.service.ListDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/listde")
public class ListDeController {
    @Autowired
    private ListDeService listDeService;

    @GetMapping
    public Node getAllLinked()
    {
        return listDeService.getAllLinked();
    }

    @PostMapping
    public String createPet(@RequestBody Pet pet)
    {
        return listDeService.add(pet);
    }

    @PostMapping(path="/tostart")
    public String createPetToStart(@RequestBody Pet pet){
        return listDeService.addFirst(pet);
    }

    @GetMapping(path = "/invert")
    public String invertList()
    {
        return listDeService.invert();
    }

    @PostMapping(path = "/loadpets")
    public String loadPets(@RequestBody List<Pet> pets) {
        for (Pet pet : pets)
        {
            listDeService.add(pet);
        }
        return "Mascotas cargadas exitosamente.";
    }
}
