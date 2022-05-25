package co.edu.umanizales.students_room_api.controller;

import co.edu.umanizales.students_room_api.model.Node;
import co.edu.umanizales.students_room_api.model.Pet;
import co.edu.umanizales.students_room_api.service.ListDecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/listdec")
public class ListDecController {
    @Autowired
    private ListDecService listDecService;

    @GetMapping
    public Node getAllLinked()
    {
        return listDecService.getAllLinked();
    }

    @PostMapping
    public String createPet(@RequestBody Pet pet)
    {
        return listDecService.add(pet);
    }

    @PostMapping(path="/tostart")
    public String createPetToStart(@RequestBody Pet pet){
        return listDecService.addFirst(pet);
    }

    @GetMapping(path = "/invert")
    public String invertList()
    {
        return listDecService.invert();
    }

    @PostMapping(path = "/loadpets")
    public String loadPets(@RequestBody List<Pet> pets) {
        for (Pet pet : pets)
        {
            listDecService.add(pet);
        }
        return "Mascotas cargadas exitosamente.";
    }
}
