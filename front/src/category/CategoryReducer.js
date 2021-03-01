function CategoryReducer(state, action) {
    switch (action.type) {
        case 'delete-category':
            const todoUpDelete = state.category;
            const listUpdate = todoUpDelete.list.filter((item) => {
                return item.id !== action.id;
            });
            todoUpDelete.list = listUpdate;
            return { ...state, category: todoUpDelete }
        case 'update-list-category':
            const todoUpList = state.category;
            todoUpList.list = action.list;
            return { ...state, category: todoUpList }
        case 'add-category':
            const todoUp = state.category.list;
            todoUp.push(action.item);
            return { ...state, category: { list: todoUp} }
        default:
            return state;
    }
}

export default CategoryReducer;