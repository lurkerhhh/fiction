package com.project.fiction.pojo;

/**
 *
 * 用户表
 *
 */
public class bookuser {
    //用户ID
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //用户角色
    private Integer userrole;
    //用户邮箱
    private String useremail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserrole() {
        return userrole;
    }

    public void setUserrole(int userrole) {
        this.userrole = userrole;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public bookuser(Integer id, String username, String password, int userrole, String useremail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userrole = userrole;
        this.useremail = useremail;
    }

    public bookuser() {
        super();
    }
}
