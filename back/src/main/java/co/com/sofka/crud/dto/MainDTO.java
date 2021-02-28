package co.com.sofka.crud.dto;


public class MainDTO {

    private Iterable<CategoryDTO> categories;
    private Iterable<TodoDTO> todos;

    public Iterable<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Iterable<CategoryDTO> categories) {
        this.categories = categories;
    }

    public Iterable<TodoDTO> getTodos() {
        return todos;
    }

    public void setTodos(Iterable<TodoDTO> todos) {
        this.todos = todos;
    }
}
