import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoManager(add: (String) -> Unit) {
    var newTodoInput by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        TextField(
            value = newTodoInput,
            onValueChange = { newValue -> newTodoInput = newValue },
            modifier = Modifier.fillMaxSize()
        )

        Spacer(modifier = Modifier.preferredHeight(16.dp))

        Button(
            onClick = {
                add(newTodoInput)
                newTodoInput = ""
            },
            enabled = newTodoInput.isNotEmpty(),
            modifier = Modifier.preferredHeight(48.dp)
        ) {
            Text("Add todo".toUpperCase())
        }
    }
}
