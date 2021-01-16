import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    val state = remember { AppState }

    MaterialTheme {
        Scaffold(
            topBar = {
                Header(
                    hideDone = state.hideDone,
                    onVisibilityChange = { changed -> state.changeHideDone(changed) }
                )
            },
            bottomBar = {
                Footer(
                    tab = state.tab,
                    onLocationChange = { nextTab -> state.navigateTo(nextTab) }
                )
            }
        ) { innerPadding ->
            when (state.tab) {
                Location.LIST ->
                    ScrollableColumn(modifier = Modifier.padding(innerPadding)) {
                        TodoList(
                            todos = state.todos.values.toList(),
                            hideDone = state.hideDone,
                            onChange = { id, checked -> state.changeTodoStatus(id, checked) },
                            onDelete = { id -> state.deleteTodo(id) },
                        )
                    }
                Location.MANAGE ->
                    ScrollableColumn(modifier = Modifier.padding(16.dp)) {
                        TodoManager { text -> state.addTodo(text) }
                    }
            }
        }
    }
}
