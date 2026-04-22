package se.magictechnology.pia14android20apr

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@Composable
fun MenuList(piavm : PIAViewModel = viewModel(), goDetail: (gomenu : MenuItem) -> Unit) {

    val menuitems = piavm.menuitems.collectAsState()
    val menutypes = piavm.menutypes.collectAsState()

    LaunchedEffect(true) {
        piavm.loadconfig()
        piavm.loadmenu()
        piavm.loadrestaurants()
    }

    fun getAllMenutypes() {
        val menutypes = menuitems.value.map { it.menutype }.distinct()


    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text("MENULIST")

        LazyColumn() {
            items(menutypes.value) { menutype ->
                Text(text = menutype.title, fontSize = 24.sp)

                menuitems.value.filter { it.menutype == menutype.menukey }.forEach { menu ->
                    Row(modifier = Modifier.padding(10.dp).clickable {
                        goDetail(menu)
                    }) {
                        AsyncImage(
                            model = menu.image,
                            contentDescription = "",
                            modifier = Modifier.width(100.dp).height(100.dp)
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            Text(menu.menutype)
                            Text(menu.title)
                            Text(menu.description)
                        }
                        Text(menu.price)

                    }
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun MenuListPreview() {
    MenuList(goDetail = {})
}