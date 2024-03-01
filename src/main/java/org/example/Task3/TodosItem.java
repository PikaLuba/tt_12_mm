package org.example.Task3;

import java.util.Objects;

public class TodosItem {
    private int userId;
    private int id;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    private String title;
    private String completed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodosItem todosItem = (TodosItem) o;
        return userId == todosItem.userId && id == todosItem.id && Objects.equals(completed, todosItem.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id, completed);
    }

    @Override
    public String toString() {
        return "TodosItem{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }
}
