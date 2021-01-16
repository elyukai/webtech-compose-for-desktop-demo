import androidx.compose.runtime.Composable

@Composable
fun TodoList(
    todos: List<Todo>,
    onChange: (Int, Boolean) -> Unit,
    onDelete: (Int) -> Unit,
    hideDone: Boolean
) {
    todos.filter {
        if (it.done) !hideDone else true
    }.forEach {
        TodoListItem(it, onChange, onDelete)
    }
}
