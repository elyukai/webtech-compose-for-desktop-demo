import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoManager(add: (String) -> Unit) {
    var newTodoInput by remember { mutableStateOf("") }

    TextField(
        value = newTodoInput,
        onValueChange = { newValue -> newTodoInput = newValue },
        modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp)
    )

    Button(
        onClick = {
            add(newTodoInput)
            newTodoInput = ""
        },
        enabled = newTodoInput.isNotEmpty(),
        modifier = Modifier.padding(16.dp, 8.dp)
    ) {
        Text("Add todo")
    }
}
