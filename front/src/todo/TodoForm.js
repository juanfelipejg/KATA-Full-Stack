import React, { useRef, useContext, useState } from 'react';
import Store from '../storeProvider'


const HOST_API = "http://localhost:8080/api";

const TodoForm = (props) => {

    const formRef = useRef(null);
    const { dispatch, state: { todo } } = useContext(Store);

    const item = todo.item;
    const [state, setState] = useState(item);

    const [state_id, set_id] = useState(props.category_id)

    const onAdd = (event) => {
        event.preventDefault();

        const request = {
            name: state.name,
            id: null,
            completed: false,
            categoryId: props.category_id
        };


        fetch(HOST_API + "/todo", {
            method: "POST",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then((todo) => {
                dispatch({ type: "add-item", item: todo });
                setState({ name: "" });
                formRef.current.reset();
            });
    }


    const onEdit = (event) => {
        event.preventDefault();

        const request = {
            name: state.name,
            id: item.id,
            completed: item.isCompleted,
            categoryId: props.category_id
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
                setState({ name: "" });
                formRef.current.reset();
            });
    }

    return <form ref={formRef} className="row g-2 form-centered">
        <div className="col-auto">
            <input type="text" className="form-control" name="name" placeholder="¿Qué piensas hacer hoy?" defaultValue={item.name} onChange={(event) => {
                setState({ ...state, name: event.target.value })
            }}>
            </input>
        </div>
        <div className="col-auto">
            {item.id && <button className="btn btn-secondary" onClick={onEdit}>Actualizar</button>}
            {!item.id && <button className="btn btn-primary" onClick={onAdd}>Crear</button>}
        </div>
    </form>
}

export default TodoForm;