package com.crud.library.mapper;

import com.crud.library.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(userDto.getUsername(), userDto.getLastname());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(user.getUsername(), user.getLastname());
    }

    public Book mapToBook(final BookDto bookDto) {
        return new Book(bookDto.getTitle(), bookDto.getAuthor(), bookDto.getPublicationYear());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(book.getTitle(), book.getAuthor(), book.getPublicationYear());
    }

    public Copies mapToCopies(final CopiesDto copiesDto) {
        return new Copies(copiesDto.getBookId(), copiesDto.getStatus());
    }

    public CopiesDto mapToCopiesDto(final Copies copies) {
        return new CopiesDto(copies.getId(), copies.getBookId(), copies.getStatus());
    }

    public List<CopiesDto> mapToCopiesList(final List<Copies> copiesList) {
        return copiesList.stream()
                .map(e -> new CopiesDto(e.getId(), e.getBookId(), e.getStatus()))
                .collect(Collectors.toList());
    }

    public RentalDto mapToRentalDto(final Rental rent) {
        return new RentalDto(rent.getUserId(), rent.getCopiesId(), rent.getRentDate(), rent.getReturnDate());
    }
}
