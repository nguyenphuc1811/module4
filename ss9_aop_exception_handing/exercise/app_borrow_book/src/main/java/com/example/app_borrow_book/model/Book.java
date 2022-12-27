package com.example.app_borrow_book.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private List<CodeBook> codeBookList;

    public List<CodeBook> getCodeBookList() {
        return codeBookList;
    }

    public void setCodeBookList(List<CodeBook> codeBookList) {
        this.codeBookList = codeBookList;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
