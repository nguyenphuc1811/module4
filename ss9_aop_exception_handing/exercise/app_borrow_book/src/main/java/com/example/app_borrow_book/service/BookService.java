package com.example.app_borrow_book.service;

import com.example.app_borrow_book.model.Book;
import com.example.app_borrow_book.model.CodeBook;
import com.example.app_borrow_book.repository.IBookRepository;
import com.example.app_borrow_book.repository.ICodeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private ICodeBookRepository codeBookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(int id) {
        return bookRepository.getReferenceById(id);
    }

    public int borrowBook(int id) {
        findById(id).setQuantity(findById(id).getQuantity() - 1);
        int code = (int) Math.floor(((Math.random() * 89999) + 10000));
        CodeBook codeBook = new CodeBook();
        codeBook.setCodeBook(code);
        codeBook.setBook(findById(id));
        findById(id).getCodeBookList().add(codeBook);
        codeBookRepository.save(codeBook);
        return code;
    }

    public Book payBook(int codeBook){
       return bookRepository.payBook(codeBook);
    }

    public void payBookConfirm(int id){
        findById(id).setQuantity(findById(id).getQuantity() + 1);

    }
}
