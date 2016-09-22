package com.practice.services.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by janardhan.nellibanda on 9/21/2016.
 */
@XmlRootElement(name = "bookResponse")
public class BookResponse {

    private List<Books> books;
    private Error error;


    @XmlElement(name = "book")
    @XmlElementWrapper(name = "books")
    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @XmlElement(name = "error")
    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
