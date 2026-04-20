package se.magictechnology.pia14android20apr

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MenuList(piavm : PIAViewModel = viewModel(), goDetail: () -> Unit) {

    val menuitems = piavm.menuitems.collectAsState()

    LaunchedEffect(true) {
        piavm.loadmenu()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text("MENULIST")

        Button(onClick = {
            goDetail()
        }) {
            Text("GO DETAIL")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MenuListPreview() {
    MenuList(goDetail = {})
}