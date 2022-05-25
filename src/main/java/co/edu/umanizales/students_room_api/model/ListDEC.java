package co.edu.umanizales.students_room_api.model;

import lombok.Data;

@Data
public class ListDEC {
    private NodeDE head;
    private int count;

    public Node enlist(){
        ListSE list = new ListSE();
        if (this.head != null) {
            NodeDE temp = this.head;
            list.add(temp.getData());
            while (temp.getNext() != this.head) {
                list.add(temp.getNext().getData());
                temp = temp.getNext();
            }
        }
        return list.getHead();
    }

    public void add(Pet pet) {
        if (this.head == null) {
            this.head = new NodeDE(pet);
            this.head.setNext(this.head);
            this.head.setPrevious(this.head);
        }
        else {
            NodeDE temp = this.head;
            while (temp.getNext() != this.head) {
                temp = temp.getNext();
            }
            temp.setNext(new NodeDE(pet));
            temp.getNext().setNext(this.head);
            temp.getNext().setPrevious(temp);
            this.head.setPrevious(temp.getNext());
        }
        this.count++;
    }

    public void addFirst(Pet pet) {
        if (this.head == null) {
            this.head = new NodeDE(pet);
            this.head.setNext(this.head);
            this.head.setPrevious(this.head);
        }
        else {
            NodeDE newNode = new NodeDE(pet);
            NodeDE temp = this.head;
            while (temp.getNext() != this.head) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(this.head);
            this.head = newNode;
            this.head.setPrevious(temp);
        }
        this.count++;
    }

    public void invert() throws Exception {
        if (this.count > 1) {
            ListDEC newList = new ListDEC();
            NodeDE temp = this.head;
            newList.addFirst(temp.getData());
            while (temp.getNext() != this.head) {
                newList.addFirst(temp.getNext().getData());
                temp = temp.getNext();
            }
            temp.setNext(this.head);
            this.head = newList.getHead();
        }
        else {
            throw new Exception("No hay suficientes datos para invertir la lista.");
        }
    }
}
