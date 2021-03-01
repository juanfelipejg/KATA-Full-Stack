function TodoReducer(state, action) {
    switch (action.type) {
        case 'update-item':
            const todoUpItem = state.todo;
            const listUpdateEdit = todoUpItem.list.map((item) => {
                if (item.id === action.item.id) {
                    return action.item;
                }
                return item;
            });
            todoUpItem.list = listUpdateEdit;
            todoUpItem.item = {};
            return { ...state, todo: todoUpItem }
            
        case 'delete-item':
            const todoUpDelete = state.todo;
            const listUpdate = todoUpDelete.list.filter((item) => {
                return item.id !== action.id;
            });
            todoUpDelete.list = listUpdate;
            return { ...state, todo: todoUpDelete }

        case 'update-list':
            console.log(state.todo)
            const todoUpList = state.todo;
            todoUpList.list = action.list;
            return { ...state, todo: todoUpList }

        case 'edit-item':
            const todoUpEdit = state.todo;
            todoUpEdit.item = action.item;
            return { ...state, todo: todoUpEdit }

        case 'add-item':
            const todoUp = state.todo.list;
            todoUp.push(action.item);
            return { ...state, todo: { list: todoUp, item: {} } }

        case 'delete-category':
            const categoryUpDelete = state.category;
            const categoryUpdate = categoryUpDelete.list.filter((item) => {
                return item.id !== action.id;
            });
            categoryUpDelete.list = categoryUpdate;
            return { ...state, category: categoryUpDelete }

        case 'update-list-category':
            const categoryUpList = state.category;
            categoryUpList.list = action.list;
            return { ...state, category: categoryUpList }

        case 'add-category':
            const categoryUp = state.category.list;
            categoryUp.push(action.item);
            return { ...state, category: { list: categoryUp } }

        default:
            return state;
    }
}

export default TodoReducer;