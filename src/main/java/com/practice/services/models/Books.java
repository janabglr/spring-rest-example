package com.practice.services.models;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by janardhan.nellibanda on 9/21/2016.
 */
public class Books {

    private String bookId;
    private String bookName;
    private String availableQty;

    @XmlElement(name = "bookId")
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @XmlElement(name = "bookName")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @XmlElement(name = "availableQty")
    public String getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(String availableQty) {
        this.availableQty = availableQty;
    }
}
