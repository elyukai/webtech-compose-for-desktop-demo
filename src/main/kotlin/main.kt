import androidx.compose.desktop.Window
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


fun main() = Window(title = "Todolist") {
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
    var hideDone by remember { mutableStateOf(false) }
    var id = 3

    MaterialTheme {
        ScrollableColumn {
            ListItem(
                    trailing = {
                        Switch(
                                checked = hideDone,
                                onCheckedChange = { checked -> hideDone = checked }
                        )
                    },
                    text = {
                        Text("Hide finished")
                    },
                    modifier = Modifier.clickable {
                        hideDone = !hideDone
                    }
            )

            Divider(
                    Modifier.padding(0.dp, 8.dp)
            )

            TodoList(
                    todos = todoMp.values.toList(),
                    onCheckedChange = { id, checked ->
                        todoMp = todoMp.mapValues {
                            if (it.value.id == id) {
                                Todo(id, it.value.text, checked)
                            } else it.value
                        }
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
                        modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 0.dp)
                ) {
                    Text("Remove todo")
                }

            }

            Divider(
                    Modifier.padding(0.dp, 8.dp)
            )
        }
    }
}
