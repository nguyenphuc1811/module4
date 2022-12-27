package com.example.app_borrow_book.repository;

import com.example.app_borrow_book.model.CodeBook;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICodeBookRepository extends JpaRepository<CodeBook, Integer> {

    CodeBook findByCodeBook(int codeBook);
}
