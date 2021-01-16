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
fun TodoList(todos: List<Todo>, onChange: (Int, Boolean) -> Unit, onDelete: (Int) -> Unit, hideDone: Boolean){
    Column {
        todos.filter {
            if (it.done) !hideDone else true
        }.forEach {
            TodoListItem(it, onChange, onDelete)
        }
    }
}
