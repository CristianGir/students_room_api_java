package co.edu.umanizales.students_room_api.model;
import co.edu.umanizales.students_room_api.model.ListSE;

import lombok.Data;

@Data
public class ListDE {
    private NodeDE head;
    private int count;

    public Node enlist(){
        ListSE list = new ListSE();
        if (this.head != null) {
            NodeDE temp = this.head;
            while (temp != null) {
                list.add(temp.getData());
                temp = temp.getNext();
            }
        }
        return list.getHead();
    }

    public void add(Pet pet) {
        if (this.head == null) {
            NodeDE newNode = new NodeDE(pet);
            this.head = newNode;
        }
        else {
            NodeDE temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            NodeDE newNode = new NodeDE(pet);
            temp.setNext(newNode);
            newNode.setPrevious(temp);
        }
        this.count++;
    }

    public void addFirst(Pet pet) {
        if (this.head == null) {
            NodeDE newNode = new NodeDE(pet);
            this.head = newNode;
        }
        else {
            NodeDE newNode = new NodeDE(pet);
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
            this.head = newNode;
        }
        this.count++;
    }

    public void invert() throws Exception {
        if (this.count > 1) {
            ListDE new_list = new ListDE();
            NodeDE temp = this.head;
            while (temp != null) {
                new_list.addFirst(temp.getData());
                temp = temp.getNext();
            }
            this.head = new_list.head;
        }
        else {
            throw new Exception("La lista no tiene elementos suficientes para invertir.");
        }
    }
}
