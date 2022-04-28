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
        boolean flag = false;
        if (this.head.getData().getId().compareTo(id) == 0)
        {
            this.head = this.head.getNext();
            this.count --;
            flag = true;
        }
        else {
            Node temp = this.head;
            while (temp != null)
            {
                if (temp.getNext().getData().getId().compareTo(id) == 0)
                {
                    temp.setNext(temp.getNext().getNext());
                    this.count--;
                    flag = true;
                    break;
                }
                temp = temp.getNext();
            }
        }
        if (!flag)
        {
            throw new Exception("El id no es válido.");
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
                if (temp.getData().getId().compareTo(id) == 0)
                {
                    flag = true;
                    break;
                }
                temp = temp.getNext();
            }
            if (!flag)
            {
                throw new Exception("El id no se encuentra en la lista.");
            }
        }
    }

    public void changeFirstLast() throws Exception
    {
        if (this.count > 1)
        {
            Node temp = this.head;
            Pet temp1 = this.head.getData();
            while (temp != null)
            {
                if (temp.getNext() == null)
                {
                    this.head.setData(temp.getData());
                    temp.setData(temp1);
                    break;
                }
                temp = temp.getNext();
            }
        }
        else {
            throw new Exception("La lista no es válida para la operación.");
        }
    }

    public void clear()
    {
        this.head = null;
    }

    public void mixByGender() throws Exception
    {
        if (this.head != null)
        {
            if (this.count > 1)
            {
                ListSE listMales = new ListSE();
                ListSE listFemales = new ListSE();
                Node temp = this.head;
                while (temp != null)
                {
                    if (temp.getData().getGender() == 'M')
                    {
                        listMales.add(temp.getData());
                    }
                    else
                    {
                        listFemales.add(temp.getData());
                    }
                    temp = temp.getNext();
                }
                if (listMales.count == 0 || listFemales.count == 0)
                {
                    throw new Exception("Sólo hay datos de un género.");
                }
                else
                {
                 Node tempH = listFemales.head;
                 int position = 2;
                 while (tempH != null)
                 {
                     if (position > listMales.count)
                     {
                         listMales.add(tempH.getData());
                     }
                     else
                     {
                         listMales.addToPosition(position, tempH.getData());
                     }
                     tempH = tempH.getNext();
                     position = position + 2;
                 }
                 this.head = listMales.head;
                }
            }
            else
            {
                throw new Exception("No hay datos suficientes para intercalar");
            }
        }
        else {
            throw new Exception("No hay datos para intercalar.");
        }
    }

}
