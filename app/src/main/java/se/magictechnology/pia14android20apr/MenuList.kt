package se.magictechnology.pia14android20apr

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MenuList(piavm : PIAViewModel = viewModel(), goDetail: (gomenu : MenuItem) -> Unit) {

    val menuitems = piavm.menuitems.collectAsState()

    LaunchedEffect(true) {
        piavm.loadmenu()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text("MENULIST")

        LazyColumn() {
            items(menuitems.value.size) { index ->
                Row(modifier = Modifier.padding(10.dp).clickable {
                    goDetail(menuitems.value[index])
                }) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(menuitems.value[index].title)
                        Text(menuitems.value[index].description)
                    }
                    Text(menuitems.value[index].price)

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