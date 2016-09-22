package com.practice.services.models;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by janardhan.nellibanda on 9/21/2016.
 */
@XmlRootElement(name = "bookPayload")
public class BookPayload {

    private BookRequest bookRequest;

    @XmlElement(name = "bookRequest")
    public BookRequest getBookRequest() {
        return bookRequest;
    }

    public void setBookRequest(BookRequest bookRequest) {
        this.bookRequest = bookRequest;
    }
}
