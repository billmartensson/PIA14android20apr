package se.magictechnology.pia14android20apr

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun News(piavm : PIAViewModel = viewModel()) {

    val newsitems = piavm.newsitems.collectAsState()

    LaunchedEffect(true) {
        piavm.loadnews()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text("NEWS")

        LazyColumn() {
            items(newsitems.value.size) { index ->
                Row(modifier = Modifier.padding(10.dp)) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(newsitems.value[index].title)
                        Text(newsitems.value[index].description)
                    }

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewsPreview() {
    News()
}