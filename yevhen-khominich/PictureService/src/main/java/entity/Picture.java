package entity;

import java.sql.Date;

public class Picture {

    private long id;
    private String fileName;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Picture() {
    }


    public Picture(long id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String name) {
        this.fileName = fileName;
    }


}
