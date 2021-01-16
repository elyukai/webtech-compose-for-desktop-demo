import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

enum class Location {
    LIST,
    MANAGE
}

object AppState {
    var todos by mutableStateOf(
        mapOf(
            1 to Todo(1, "Clean dishes", false),
            2 to Todo(2, "Homework", true),
            3 to Todo(3, "Read the book", false),
            4 to Todo(4, "Read the book", false),
            5 to Todo(5, "Read the book", false),
            6 to Todo(6, "Read the book", false),
            7 to Todo(7, "Read the book", false),
            8 to Todo(8, "Read the book", false),
            9 to Todo(9, "Read the book", false),
            10 to Todo(10, "Read the book", false)
        )
    )
    var lastId by mutableStateOf(todos.size)
    var hideDone by mutableStateOf(false)
    var tab by mutableStateOf(Location.LIST)

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

    fun navigateTo(nextTab: Location) {
        tab = nextTab
    }
}
