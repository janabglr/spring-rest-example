package com.practice.services.services;

import com.practice.services.models.BookRequest;
import com.practice.services.models.BookResponse;
import com.practice.services.models.Books;
import com.practice.services.models.Error;
import org.springframework.util.NumberUtils;

import java.util.*;

/**
 * Created by janardhan.nellibanda on 9/21/2016.
 */
public class BookAccessService {

    private static Map<String, BookResponse> map = new LinkedHashMap<String, BookResponse>();
    public BookResponse getAllBooks(final String limit) throws Exception {
        BookResponse bookResponse = new BookResponse();
        List<Books> bookses = new ArrayList<Books>();
        int index;
        int n = 0;
        Iterator iterator = map.entrySet().iterator();
        if (limit != null && limit.matches("[0-9]")) {
            index = Integer.parseInt(limit);
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                if(n < index){
                    bookses.addAll(map.get(entry.getKey()).getBooks());
                }
                n ++;
            }
        } else if (limit != null) {
            throw new Exception("Invalid value passed for Limit");
        } else {
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                bookses.addAll(map.get(entry.getKey()).getBooks());
            }
        }
        bookResponse.setBooks(bookses);
        return bookResponse;
    }

    public BookResponse addBooks(final BookRequest bookRequest){
        BookResponse bookResponse = new BookResponse();
       List<Books> bookses = new ArrayList<Books>();
        Books books = new Books();
        books.setBookId(bookRequest.getBookId());
        books.setBookName(bookRequest.getBookName());
        books.setAvailableQty(bookRequest.getQuantity());
        bookses.add(books);
        bookResponse.setBooks(bookses);
        map.put(bookRequest.getBookId(), bookResponse);
        return bookResponse;
    }

    public BookResponse updateBooks(final BookRequest bookRequest){
        BookResponse bookResponse = new BookResponse();
        List<Books> bookses = new ArrayList<Books>();
        Books books = new Books();
        if (bookRequest.getBookId() != null) {
            books.setBookId(bookRequest.getBookId());
        }
        if (bookRequest.getBookName() != null) {
            books.setBookName(bookRequest.getBookName());
        }
        if (bookRequest.getQuantity() != null) {
            books.setAvailableQty(bookRequest.getQuantity());
        }
        bookses.add(books);
        bookResponse.setBooks(bookses);
        map.put(bookRequest.getBookId(), bookResponse);
        return bookResponse;
    }

    public BookResponse deleteBooks(final BookRequest bookRequest) throws Exception {
        BookResponse bookResponse = null;
        if (map.get(bookRequest.getBookId()) != null) {
            bookResponse = new BookResponse();
            map.remove(bookRequest.getBookId());
        } else {
            throw new Exception("Book ID Not Found");
        }
        return bookResponse;
    }
}
