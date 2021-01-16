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
fun Header(hideDone: Boolean, onVisibilityChange: (Boolean) -> Unit) {
    var showOptions: Boolean by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "TodoApp") },
        actions = {
            IconButton({ showOptions = !showOptions }) {
                DropdownMenu(
                    toggle = { Icon(Icons.Filled.MoreVert) },
                    expanded = showOptions,
                    onDismissRequest = { showOptions = false }
                ) {
                    DropdownMenuItem({ onVisibilityChange(!hideDone) }) {
                        Text(if (hideDone) "Show done" else "Hide done")
                    }
                }
            }
        }
    )

    TabRow(selectedTabIndex = 0) {
        Tab(true, {}) {
            Text("View")
        }
        Tab(false, {}) {
            Text("Manage")
        }
    }
}
