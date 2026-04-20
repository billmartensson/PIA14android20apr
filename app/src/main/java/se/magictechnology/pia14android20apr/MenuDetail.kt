package se.magictechnology.pia14android20apr

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MenuDetail(piavm : PIAViewModel = viewModel(), currentmenuitem : MenuItem) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("MENUDETAIL")

        Text(currentmenuitem.title)
    }
}


@Preview(showBackground = true)
@Composable
fun MenuDetailPreview() {
    MenuDetail(currentmenuitem = MenuItem("Test", "Test test", "99kr", "", ""))
}