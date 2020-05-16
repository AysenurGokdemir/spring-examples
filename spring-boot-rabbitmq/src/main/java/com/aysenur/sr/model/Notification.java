package com.aysenur.sr.model;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable { //nesneyi serialize edip kuyruğa gnderiyoruz almak istegigimiz zamanda java tarafında anlamlı bir sekilde prosesses edebilmek için implemente etmeliyiz
    //bunlarla notificationı kuyruga atıcaz kuyruktanda bir baskası alıp process edecek

    private String notificationId;
     private Date createdAt;
     private  Boolean seen;
     private String message;

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", createdAt=" + createdAt +
                ", seen=" + seen +
                ", message='" + message + '\'' +
                '}';
    }
}
