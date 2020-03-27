package model;

import java.io.Serializable;

public class Book implements Serializable{
    public int id;
    public String name;
    public String author;

    @Override
    public String toString(){
        return "Book{id="+id+", name="+name+", author="+author+"}";
    }

    public Book(int id, String name, String author){
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public void setName(String name ){
        this.name = name;
    }

    public void setAuthor(String author){
        this.author = author;
    }
}
