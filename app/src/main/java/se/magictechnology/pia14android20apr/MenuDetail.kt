package se.magictechnology.pia14android20apr

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MenuDetail() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("MENUDETAIL")
    }
}


@Preview(showBackground = true)
@Composable
fun MenuDetailPreview() {
    MenuDetail()
}