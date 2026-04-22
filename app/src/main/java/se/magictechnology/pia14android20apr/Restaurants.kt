package se.magictechnology.pia14android20apr

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PinConfig
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.MarkerState.Companion.invoke
import com.google.maps.android.compose.Polygon
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun Restaurants(piavm : PIAViewModel = viewModel()) {

    val restaurants = piavm.restaurants.collectAsState()

    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 12f)
    }

    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }


    Column(modifier = Modifier.fillMaxSize()) {
        Text("RESTAURANTS")

        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(Color.Blue)
            ,
            cameraPositionState = cameraPositionState,
            properties = properties
        ) {

            val pinConfig = PinConfig.builder()
                .setBackgroundColor(Color.Magenta.hashCode())
                .build()

            restaurants.value.forEach { rest ->
                AdvancedMarker(
                    state = MarkerState(position = LatLng(rest.lat, rest.lng)),
                    title = rest.address,
                    pinConfig = pinConfig,
                    onClick = { marker ->
                        false
                    },
                    onInfoWindowClick = { marker ->

                    }
                )
            }


        }

        LazyColumn() {
            items(restaurants.value) { restaurant ->
                Column() {
                    Text(restaurant.address)
                    Text(restaurant.description)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RestaurantsPreview() {
    Restaurants()
}