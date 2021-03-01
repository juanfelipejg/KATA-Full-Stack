import { useContext, useEffect } from "react"
import Store from '../storeProvider'
import TodoList from '../todo/TodoList'
import TodoForm from '../todo/TodoForm'

const HOST_API = "http://localhost:8080/api";

const CategoryList = () => {

    const { dispatch, state: { category } } = useContext(Store);
    const currentList = category.list;

    useEffect(() => {
        fetch(`${HOST_API}/categories`)
            .then(response => response.json())
            .then((list) => {
                console.log(list)
                const action = { type: "update-list-category", list }
                dispatch(action)
            })
    }, [dispatch]);


    const onDelete = (id) => {
        fetch(`${HOST_API}/${id}/category`, {
            method: "DELETE"
        }).then((list) => {
            dispatch({ type: "delete-category", id })
        })
    };


    return currentList.map((category) => {
        return <div key = {category.id} className = "container p-4 category-div">
           <div><span className = "title">{category.name} </span><button className="btn btn-danger" onClick={() => onDelete(category.id)}>Eliminar</button> </div> 
           
           <br />         
            <TodoForm category_id = {category.id}/>
            <TodoList category_id = {category.id}/>
            <hr />
        </div>
    })
}

export default CategoryList;