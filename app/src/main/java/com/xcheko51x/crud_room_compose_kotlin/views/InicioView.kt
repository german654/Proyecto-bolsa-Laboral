import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.xcheko51x.crud_room_compose_kotlin.viewmodels.UsuariosViewModel
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Favorite
import com.xcheko51x.crud_room_compose_kotlin.models.Usuarios

@Composable
fun InicioView(navController: NavController, viewModel: UsuariosViewModel) {
    Scaffold(
        topBar = {
            TopBarCustom()
        },
        bottomBar = {
            BottomNavigationBar(navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("agregar") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxSize()
        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            FilterChips()
            Spacer(modifier = Modifier.height(16.dp))
            UserList(navController, viewModel)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarCustom() {
    TopAppBar(
        title = {
            Text(text = "Computrabajo", fontWeight = FontWeight.Bold, color = Color.White)
        },
        actions = {
            IconButton(onClick = { /* Handle menu click */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF007BFF))
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Cargo o ca") },
            modifier = Modifier.weight(1f),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF0F0F0)
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = { /* Handle search click */ },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007BFF))
        ) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
        }
    }
}

@Composable
fun FilterChips() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        FilterChip(text = "Ordenar")
        FilterChip(text = "Email")
        FilterChip(text = "Nombre")
    }
}

@Composable
fun FilterChip(text: String) {
    Button(
        onClick = { /* Handle filter click */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE0E0E0)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(text = text, fontSize = 12.sp, color = Color.Black)
    }
}

@Composable
fun UserList(navController: NavController, viewModel: UsuariosViewModel) {
    val state = viewModel.state

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(state.listaUsuarios.size) { index ->
            UserCard(navController, viewModel, state.listaUsuarios[index])
        }
    }
}

@Composable
fun UserCard(navController: NavController, viewModel: UsuariosViewModel, user: Usuarios) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = user.usuario, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = user.email, color = Color.Gray)
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { navController.navigate("editar/${user.id}/${user.usuario}/${user.email}") }
                ) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar")
                }
                IconButton(
                    onClick = { viewModel.borrarUsuario(user) }
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Eliminar")
                }
            }
        }
    }
}

@Composable
fun JobCard() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Recepcionista", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "Clínica Peruano Suiza", color = Color.Gray)
            Text(text = "Cusco, Cusco", color = Color.Gray)
            Text(text = "Hace 3 minutos", color = Color.Gray, fontSize = 12.sp)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Color.White
    ) {
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar") },
            label = { Text("Buscar") },
            selected = false,
            onClick = { /* Handle click */ }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favoritos") },
            label = { Text("Favoritos") },
            selected = false,
            onClick = { /* Handle click */ }
        )
        // Add more items as needed
    }
}
