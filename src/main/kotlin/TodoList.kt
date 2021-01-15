import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ListItem
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoList(todos: List<Todo>, onCheckedChange: (Int, Boolean) -> Unit, onRemove: (Int) -> Unit, hideDone: Boolean){
    Column {
        val filteredTodos = todos.filter {
            if (it.done) {
                !hideDone
            } else true
        }

        if (filteredTodos.isEmpty())
            Text(text = "Nothing to do! Yay!", modifier = Modifier.padding(16.dp))
        else filteredTodos.forEach {
            TodoListItem(it, onCheckedChange, onRemove)
        }
    }
}
