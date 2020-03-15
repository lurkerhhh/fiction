package com.project.fiction.pojo;

/**
 *  书籍信息表
 */
public class bookinformation {
    //书籍ID
    private Integer id;
    //书籍名称
    private String bookname;
    //作者姓名
    private String authod;
    //简介
    private String synopsis;
    //图片地址
    private String imagepath;
    //书籍地址
    private String bookpath;
    //书籍类型
    private String type;
    //书籍总字数
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthod() {
        return authod;
    }

    public void setAuthod(String authod) {
        this.authod = authod;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getBookpath() {
        return bookpath;
    }

    public void setBookpath(String bookpath) {
        this.bookpath = bookpath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public bookinformation(Integer id, String bookname, String authod, String synopsis, String imagepath, String bookpath, String type) {
        this.id = id;
        this.bookname = bookname;
        this.authod = authod;
        this.synopsis = synopsis;
        this.imagepath = imagepath;
        this.bookpath = bookpath;
        this.type = type;
    }

    public bookinformation() {
        super();
    }
}
