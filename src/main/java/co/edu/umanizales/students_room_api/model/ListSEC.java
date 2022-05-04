package co.edu.umanizales.students_room_api.model;

import lombok.Data;

@Data
public class ListSEC {
    private Node head;
    private int count;

    public Node enlist(){
        ListSE list = new ListSE();
        if (this.head != null) {
            Node temp = this.head;
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
            this.head = new Node(pet);
            this.head.setNext(this.head);
        }
        else {
            Node temp = this.head;
            while (temp.getNext() != this.head) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(pet));
            temp.getNext().setNext(this.head);
        }
        this.count++;
    }

    public void addFirst(Pet pet) {
        if (this.head == null) {
            this.head = new Node(pet);
            this.head.setNext(this.head);
        }
        else {
            Node temp = this.head;
            while (temp.getNext() != this.head) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(pet));
            temp.getNext().setNext(this.head);
            this.head = temp.getNext();
        }
        this.count++;
    }

    public void invert() throws Exception {
        if (this.count > 1) {
            ListSEC newList = new ListSEC();
            Node temp = this.head;
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
