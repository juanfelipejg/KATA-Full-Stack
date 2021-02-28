package co.com.sofka.crud.dto;

public class CategoryTodoDTO {

    private Long idCategory;
    private String nameCategory;
    private String nameTodo;
    private boolean completed;

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameTodo() {
        return nameTodo;
    }

    public void setNameTodo(String nameTodo) {
        this.nameTodo = nameTodo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
