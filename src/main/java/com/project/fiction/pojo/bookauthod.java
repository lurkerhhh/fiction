package com.project.fiction.pojo;

public class bookauthod {
    //作者ID
    private int authod_id;
    //作者姓名
    private String authod_name;
    //作者邮箱
    private String authod_email;
    //作者所有文章总字数
    private int authod_number;
    //作者对应的用户id
    private int user_id;

    public int getAuthod_id() {
        return authod_id;
    }

    public void setAuthod_id(int authod_id) {
        this.authod_id = authod_id;
    }

    public String getAuthod_name() {
        return authod_name;
    }

    public void setAuthod_name(String authod_name) {
        this.authod_name = authod_name;
    }

    public String getAuthod_email() {
        return authod_email;
    }

    public void setAuthod_email(String authod_email) {
        this.authod_email = authod_email;
    }

    public int getAuthod_number() {
        return authod_number;
    }

    public void setAuthod_number(int authod_number) {
        this.authod_number = authod_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
