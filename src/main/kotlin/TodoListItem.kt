import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration

val doneStyle = TextStyle(
    color = Color(160, 160, 160),
    textDecoration = TextDecoration.LineThrough
)

@Composable
fun TodoListItem(todo: Todo, onChange: (Int, Boolean) -> Unit, onDelete: (Int) -> Unit) {
    ListItem(
        // ...
        icon = {
            Checkbox(
                todo.done,
                onCheckedChange = { checked -> onChange(todo.id, checked) }
            )
        },
        text = {
            Text(
                todo.text,
                style =
                if (todo.done) AmbientTextStyle.current.plus(doneStyle)
                else AmbientTextStyle.current
            )
        },
        trailing = {
            IconButton(onClick = { onDelete(todo.id) }) {
                Icon(Icons.Filled.Delete)
            }
        },
        modifier = Modifier.clickable { onChange(todo.id, !todo.done) }
    )
}
