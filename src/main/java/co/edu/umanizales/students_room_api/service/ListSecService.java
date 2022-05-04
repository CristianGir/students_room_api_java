package co.edu.umanizales.students_room_api.service;

import co.edu.umanizales.students_room_api.model.ListSEC;
import co.edu.umanizales.students_room_api.model.Node;
import co.edu.umanizales.students_room_api.model.Pet;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ListSecService {
    private ListSEC list = new ListSEC();

    public Node getAllLinked(){
        return this.list.enlist();
    }

    public String add(Pet pet){
        this.list.add(pet);
        return "Adicionado con éxito";
    }

    public String addFirst(Pet pet){
        this.list.addFirst(pet);
        return "Adicionado con éxito";
    }

    public String invert()
    {
        try {
            this.list.invert();
            return "Invertido con éxito.";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
}
