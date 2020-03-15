package com.project.fiction.pojo;

/**
 *    书架表
 */
public class bookrack {
    //用户ID
    private Integer userid;
    //书籍名称
    private String bookname;
    //作者
    private String authod;
    //最后一次阅读位置
    private Integer lastid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public Integer getLastid() {
        return lastid;
    }

    public void setLastid(Integer lastid) {
        this.lastid = lastid;
    }

    public bookrack(Integer userid, String bookname, String authod, Integer lastid) {
        this.userid = userid;
        this.bookname = bookname;
        this.authod = authod;
        this.lastid = lastid;
    }

    public bookrack() {
        super();
    }
}
