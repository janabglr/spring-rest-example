package com.practice.services.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by janardhan.nellibanda on 9/21/2016.
 */
@XmlRootElement(name = "bookRequest")
public class BookRequest {

    private String bookId;
    private String bookName;
    private String quantity;
    private String action;

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
    @XmlElement(name = "quantity")
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    @XmlElement(name = "action")
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
