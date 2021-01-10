import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.ListItem
import androidx.compose.runtime.Composable

@Composable
fun TodoList(todos: List<Todo>, onCheckedChange: (Int, Boolean) -> Unit, hideDone: Boolean) {
    Column {
        todos.filter {
            if (it.done) {
                !hideDone
            } else true
        }.forEach {
            TodoListItem(it, onCheckedChange)
        }
    }
}
