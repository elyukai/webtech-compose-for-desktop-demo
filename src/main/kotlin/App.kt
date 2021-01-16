import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    val state = remember { AppState }

    MaterialTheme {
        ScrollableColumn {
            Header(hideDone = state.hideDone) { nextHideDone ->
                state.changeHideDone(nextHideDone)
            }

            TodoList(
                todos = state.todos.values.toList(),
                hideDone = state.hideDone,
                onChange = { id, checked ->
                    state.changeTodoStatus(id, checked)
                },
                onDelete = { id -> state.deleteTodo(id) },
            )

            Divider(Modifier.padding(0.dp, 8.dp))

            TodoManager { text -> state.addTodo(text) }
        }
    }
}
