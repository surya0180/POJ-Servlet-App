package com.projects.todo.beans;

public class TodoBean {
    private int id;
    private String title;
    private String summary;
    private boolean iscompleted;

    public TodoBean(String title, String summary, boolean iscompleted) {
        super();
        this.title = title;
        this.summary = summary;
        this.iscompleted = iscompleted;
    }

    public TodoBean(int id, String title, String summary, boolean iscompleted) {
        super();
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.iscompleted = iscompleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isIscompleted() {
        return iscompleted;
    }

    public void setIscompleted(boolean iscompleted) {
        this.iscompleted = iscompleted;
    }
}
