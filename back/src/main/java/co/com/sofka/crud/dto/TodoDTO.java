package co.com.sofka.crud.dto;

public class TodoDTO {

    private Long idTodo;
    private String nameTodo;
    private boolean completed;
    private Long groupId;
    private String groupName;

    public Long getIdTodo() {
        return idTodo;
    }

    public void setIdTodo(Long idTodo) {
        this.idTodo = idTodo;
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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
