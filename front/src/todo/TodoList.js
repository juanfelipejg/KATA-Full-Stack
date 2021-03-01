import { useContext, useEffect } from "react"
import Store from '../storeProvider'

const HOST_API = "http://localhost:8080/api";

const TodoList = (props) => {
    const { dispatch, state: { todo } } = useContext(Store);
    const currentList = todo.list;

    useEffect(() => {
        fetch(`${HOST_API}/todos`)
            .then(response => response.json())
            .then((list) => {
                console.log(list)
                const action = { type: "update-list", list }
                dispatch(action)
            })
    }, [dispatch]);

    const onChange = (event, todo) => {
        const request = {
            name: todo.name,
            id: todo.id,
            completed: event.target.checked
        };
        fetch(HOST_API + "/todo", {
            method: "PUT",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then((todo) => {
                dispatch({ type: "update-item", item: todo });
            });
    };

    const decorationDone = {
        textDecoration: 'line-through'
    };

    const onDelete = (id) => {
        fetch(HOST_API + "/" + id + "/todo", {
            method: "DELETE"
        }).then((list) => {
            dispatch({ type: "delete-item", id })
        })
    };

    const onEdit = (todo) => {

        fetch(`${HOST_API}/${todo.id}/todo`)
        .then(response => response.json())
        .then(response => console.log(response))
      
        dispatch({ type: "edit-item", item: todo })
      };

    return <div className="centered ">
        <table className="table table-striped">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Tarea</td>
                    <td>¿Completado?</td>
                </tr>
            </thead>
            <tbody>
                {currentList.filter((todo) => todo.categoryId === props.category_id).map((todo) => {
                    return <tr key={todo.id} style={todo.completed ? decorationDone : {}}>
                        <td>{todo.id}</td>
                        <td>{todo.name}</td>
                        <td><input type="checkbox" defaultChecked={todo.completed} onChange={(event) => onChange(event, todo)}></input></td>
                        <td><button className="btn btn-danger" onClick={() => onDelete(todo.id)}>Eliminar</button></td>
                        <td><button className="btn btn-primary" onClick={() => onEdit(todo)}>Editar</button></td>
                    </tr>
                })}
            </tbody>
        </table>
    </div>
}

export default TodoList;