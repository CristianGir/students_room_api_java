package co.edu.umanizales.students_room_api.controller;

import co.edu.umanizales.students_room_api.model.Node;
import co.edu.umanizales.students_room_api.model.Pet;
import co.edu.umanizales.students_room_api.service.ListSecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/listsec")
public class ListSecController {
    @Autowired
    private ListSecService listSecService;

    @GetMapping
    public Node getAllLinked()
    {
        return listSecService.getAllLinked();
    }

    @PostMapping
    public String createPet(@RequestBody Pet pet)
    {
        return listSecService.add(pet);
    }

    @PostMapping(path="/tostart")
    public String createPetToStart(@RequestBody Pet pet){
        return listSecService.addFirst(pet);
    }

    @GetMapping(path = "/invert")
    public String invertList()
    {
        return listSecService.invert();
    }
}
