import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun Header(hideDone: Boolean, onVisibilityChange: (Boolean) -> Unit) {
    var showOptions by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "TodoApp") },
        actions = {
            IconButton({ showOptions = !showOptions }) {
                DropdownMenu(
                    toggle = { Icon(Icons.Filled.MoreVert) },
                    expanded = showOptions,
                    onDismissRequest = { showOptions = false }
                ) {
                    DropdownMenuItem({ onVisibilityChange(!hideDone) }, Modifier.preferredWidth(200.dp)) {
                        Text(if (hideDone) "Show done" else "Hide done")
                    }
                }
            }
        },
        modifier = Modifier.zIndex(10f).shadow(4.dp)
    )
}
