package com.crud.library.repository;

import com.crud.library.domain.RentalDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public Long getAllAvialableCopies(Long bookId) {
        String SearchQuery = "SELECT count(*) FROM LIBRARY_CRUD.COPIES c\n" +
                "JOIN LIBRARY_CRUD.BOOKS B\n" +
                "ON B.ID = C.BOOK_ID\n" +
                "WHERE C.STATUS='FREE' AND B.ID= " + bookId;
        return (Long) em.createNativeQuery(SearchQuery).getSingleResult();
    }

    public RentalDto returnBorrowedBook(Long copiesId) {
        String SearchQuery = "SELECT * FROM LIBRARY_CRU.RENTAL WHERE COPIES_ID = " +
                copiesId + " AND RETURN_DATE IS NULL";
        return (RentalDto) em.createNativeQuery(SearchQuery, RentalDto.class);
    }
}