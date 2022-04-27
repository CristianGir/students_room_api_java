package co.edu.umanizales.students_room_api.controller;

import co.edu.umanizales.students_room_api.model.Node;
import co.edu.umanizales.students_room_api.model.Pet;
import co.edu.umanizales.students_room_api.service.ListSeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/listse")
public class ListSeController {
    @Autowired
    private ListSeService listSeService;

    @GetMapping
    public Node getAllLinked()
    {
         return listSeService.getAllLinked();
    }

    @PostMapping
    public String createPet(@RequestBody Pet pet)
    {
        return listSeService.add(pet);
    }

    @PostMapping(path="/tostart")
    public String createPetToStart(@RequestBody Pet pet){
        return listSeService.addToStart(pet);
    }

    @PostMapping(path="/toposition/{position}")
    public String createPetToPosition(@PathVariable int position,
                                      @RequestBody Pet pet){
        return listSeService.addToPosition(position,pet);
    }

    @GetMapping(path = "/deletebyposition/{position}")
    public String deleteByPosition(@PathVariable int position)
    {
        return listSeService.deleteToPosition(position);
    }

    @GetMapping(path = "/deletebyid/{id}")
    public String deleteById(@PathVariable String id)
    {
        return listSeService.deleteById(id);
    }

    @GetMapping(path = "/invert")
    public String invertList()
    {
        return listSeService.invertList();
    }

    @GetMapping(path = "/verify/{id}")
    public String verifyById(@PathVariable String id)
    {
        return listSeService.verifyById(id);
    }

    @GetMapping(path = "/switchends")
    public String switchEnds()
    {
        return listSeService.switchEnds();
    }
}
