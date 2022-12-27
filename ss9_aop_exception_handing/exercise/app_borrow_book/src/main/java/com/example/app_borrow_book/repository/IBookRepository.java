package com.example.app_borrow_book.repository;

import com.example.app_borrow_book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select b.* from `book` b join `code_book` cb on b.id = cb.book_id where cb.code_book = :codeBook" , nativeQuery = true)
    Book payBook(@Param("codeBook") int codeBook);

}
