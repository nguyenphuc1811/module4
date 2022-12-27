package com.example.app_borrow_book.service;

import com.example.app_borrow_book.model.CodeBook;
import com.example.app_borrow_book.repository.ICodeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeBookService implements ICodeBookService {

    @Autowired
    private ICodeBookRepository codeBookRepository;

    @Override
    public CodeBook findByCodeBook(int codeBook) {
        return codeBookRepository.findByCodeBook(codeBook);
    }

    public void removeCodeBook(int codeBook) {
        codeBookRepository.delete(findByCodeBook(codeBook));
    }
}
