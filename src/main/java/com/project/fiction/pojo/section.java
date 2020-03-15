package com.project.fiction.pojo;

/**
 * 章节表
 */
public class section {
    private Integer section_id;
    private String section_name;
    private Integer bookid;
    private Integer section_number;
    private String section_path;

    public Integer getSection_id() {
        return section_id;
    }

    public void setSection_id(Integer section_id) {
        this.section_id = section_id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getSection_number() {
        return section_number;
    }

    public void setSection_number(Integer section_number) {
        this.section_number = section_number;
    }

    public String getSection_path() {
        return section_path;
    }

    public void setSection_path(String section_path) {
        this.section_path = section_path;
    }

    public section(Integer section_id, String section_name, Integer bookid, Integer section_number, String section_path) {
        this.section_id = section_id;
        this.section_name = section_name;
        this.bookid = bookid;
        this.section_number = section_number;
        this.section_path = section_path;
    }

    public section() {
        super();
    }
}
