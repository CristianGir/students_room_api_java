package co.edu.umanizales.students_room_api.model;

import lombok.Data;

@Data
public class ListSE {
    private Node head;
    private int count;

    public void add(Pet pet){
        if (this.head ==null)
        {
            this.head = new Node(pet);
        }
        else
        {
            Node temp = this.head;
            while(temp.getNext() != null)
            {
                temp = temp.getNext();
            }
            //Parado en el último
            temp.setNext(new Node(pet));
        }
        count++;
    }

    public void addToStart(Pet pet)
    {
        if( head == null)
        {
            head = new Node(pet);
        }
        else
        {
            Node newNode= new Node(pet);
            newNode.setNext(head);
            head = newNode;
        }
        count++;
    }

    public void addToPosition(int position,Pet pet) throws Exception
    {
        if(position>0 && position <= this.count+1)
        {
            if (position==1)
            {
                this.addToStart(pet);
            }
            else
            {
                Node temp = head;
                int count =1;
                while(temp != null)
                {
                    if(count == position -1)
                    {
                        Node newNode = new Node(pet);
                        newNode.setNext(temp.getNext());
                        temp.setNext(newNode);
                        this.count++;
                        break;
                    }
                    temp = temp.getNext();
                    count++;
                }
            }
        }
        else
        {
            throw new Exception("La posición no es válida");
        }
    }

        public void invert() throws Exception
        {
            if (this.head != null)
            {
                ListSE newList = new ListSE();
                Node temp = this.head;
                while (temp != null)
                {
                    newList.addToStart(temp.getData());
                    temp = temp.getNext();
                }
                this.head = newList.head;
            }
            else
            {
                throw new Exception("La lista está vacía.");
            }
        }

    public void deleteToPosition(int position) throws Exception
    {
        if(position>0 && position <= this.count)
        {
            if (position==1)
            {
                this.head = this.head.getNext();
                this.count--;
            }
            else
            {
                Node temp = head;
                int count =1;
                while(temp != null)
                {
                    if(count == position -1)
                    {
                        temp.setNext(temp.getNext().getNext());
                        this.count--;
                        break;
                    }
                    temp = temp.getNext();
                    count++;
                }
            }
        }
        else
        {
            throw new Exception("La posición no es válida");
        }
    }

    public void deleteById(String id) throws Exception
    {
        Node temp = head;
        while(temp.getNext() != null)
        {
            if(temp.getNext().getData().getId().equals(id))
            {
                temp.setNext(temp.getNext().getNext());
                int existing_id = 0;

                if(existing_id != 0)
                {
                    throw new Exception("El id introducido no existe.");
                }
                this.count--;
            }
        temp = temp.getNext();
        }
    }

    public void verifyById(String id) throws Exception
    {
        if (this.head != null)
        {
            Node temp = this.head;
            boolean flag = false;
            while (temp != null)
            {
                if (temp.getData().getId() == id)
                {
                    flag = true;
                    break;
                }
                temp = temp.getNext();
            }
            if (flag == false)
            {
                throw new Exception("El id no se encuentra en la lista.");
            }
        }
    }

}
