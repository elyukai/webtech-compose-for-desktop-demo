import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

object AppState {
    var todos by mutableStateOf(
        mapOf(
            Pair(1, Todo(1, "Clean dishes", false)),
            Pair(2, Todo(2, "Homework", true)),
            Pair(3, Todo(3, "Read the book", false))
        )
    )
    var lastId by mutableStateOf(3)
    var hideDone by mutableStateOf(false)

    fun changeTodoStatus(id: Int, checked: Boolean) {
        todos = todos.mapValues { (_, todo) -> if (id == todo.id) Todo(id, todo.text, checked) else todo }
    }

    fun addTodo(text: String) {
        lastId += 1
        todos = todos.plus(lastId to Todo(lastId, text, false))
    }

    fun deleteTodo(id: Int) {
        todos = todos.minus(id)
    }

    fun changeHideDone(nextValue: Boolean) {
        hideDone = nextValue
    }
}
