import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun Footer(tab: Location, onLocationChange: (Location) -> Unit) {
    BottomNavigation(elevation = 50.dp, modifier = Modifier.zIndex(10f)) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.List) },
            label = { Text("List") },
            selected = tab == Location.LIST,
            onClick = { onLocationChange(Location.LIST) }
        )

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Edit) },
            label = { Text("Manage") },
            selected = tab == Location.MANAGE,
            onClick = { onLocationChange(Location.MANAGE) }
        )
    }
}
