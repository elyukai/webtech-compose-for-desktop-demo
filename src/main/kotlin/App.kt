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
    var todoMp by remember {
        mutableStateOf(
            mapOf(
                Pair(1, Todo(1, "Clean dishes", false)),
                Pair(2, Todo(2, "Homework", true)),
                Pair(3, Todo(3, "Read the book", false))
            )
        )
    }
    var newTodoInput by remember { mutableStateOf("") }
    var hideDone: Boolean by remember { mutableStateOf(false) }
    var showOptions: Boolean by remember { mutableStateOf(false) }
    var id by remember { mutableStateOf(3) }

    MaterialTheme {
        ScrollableColumn {
            TopAppBar(
                title = { Text(text = "TodoApp") },
                actions = {
                    IconButton(
                        {
                            showOptions = !showOptions
                        }
                    ) {
                        DropdownMenu({ Icon(Icons.Filled.MoreVert) }, showOptions, { showOptions = false}) {
                            DropdownMenuItem({ hideDone = !hideDone }) {
                                Text(if (hideDone) "Show done" else "Hide done")
                            }
                        }
                    }
                }
            )
            TabRow(selectedTabIndex = 0) {
                Tab(true, {}) {
                    Text("List")
                }
                Tab(false, {}) {
                    Text("Add")
                }
            }

            TodoList(
                todos = todoMp.values.toList(),
                onCheckedChange = { id, checked ->
                    todoMp = todoMp.mapValues {
                        if (it.value.id == id) {
                            Todo(id, it.value.text, checked)
                        } else it.value
                    }
                },
                onRemove = {
                    id -> todoMp.forEach { (key, item) -> if (item.id == id) todoMp -= key }
                },
                hideDone = hideDone
            )

            Divider(
                Modifier.padding(0.dp, 8.dp)
            )

            TextField(
                value = newTodoInput,
                onValueChange = { newValue -> newTodoInput = newValue },
                modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp)
            )

            Row {
                Button(
                    onClick = {
                        id += 1
                        todoMp = todoMp + (id to Todo(id, newTodoInput, false))
                        newTodoInput = ""
                    },
                    enabled = newTodoInput.isNotEmpty(),
                    modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 0.dp)
                ) {
                    Text("Add todo")
                }

                Button(
                    onClick = {
                        todoMp.forEach { (key, item) -> if (item.done) todoMp -= key }
                    },
                    enabled = todoMp.isNotEmpty(),
                    modifier = Modifier.padding(0.dp, 8.dp, 16.dp, 0.dp)
                ) {
                    Text("Remove todo")
                }
            }
            Spacer(Modifier.preferredHeight(16.dp))
        }
    }
}
