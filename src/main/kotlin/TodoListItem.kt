import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun TodoListItem(todo: Todo, onCheckedChange: (Int, Boolean) -> Unit) {
    ListItem(
        icon = {
            Checkbox(
                checked = todo.done,
                onCheckedChange = { checked ->
                    onCheckedChange(todo.id, checked)
                }
            )
        },
        text = {
            Text(
                text = todo.text,
                style = if (todo.done) {
                    AmbientTextStyle.current.plus(
                        TextStyle(
                            color = Color(160, 160, 160),
                            textDecoration = TextDecoration.LineThrough
                        )
                    )
                } else AmbientTextStyle.current
            )
        }
    )
}