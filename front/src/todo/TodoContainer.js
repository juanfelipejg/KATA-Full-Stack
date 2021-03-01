import TodoForm from './TodoForm'
import TodoList from './TodoList'

const TodoContainer = () => {

    return <div  className = "container-md p-5">
        <TodoForm />
        <TodoList />
    </div>
}

export default TodoContainer