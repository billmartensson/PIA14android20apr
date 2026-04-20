package se.magictechnology.pia14android20apr

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request

class PIAViewModel : ViewModel() {

    private val client = OkHttpClient()

    private var _menuitems = MutableStateFlow(listOf<MenuItem>())
    val menuitems: StateFlow<List<MenuItem>> = _menuitems.asStateFlow()

    fun loadmenu() {
        val apiurl = "https://firebasestorage.googleapis.com/v0/b/pia14-bdf2a.firebasestorage.app/o/menudata.json?alt=media&token=f6387a91-8968-4f81-be35-2949844e6bf5"

        CoroutineScope(Dispatchers.IO).launch {
            val request = Request.Builder()
                .url(apiurl)
                .build()

            client.newCall(request).execute().use { response ->

                //response.code

                if (!response.isSuccessful) {
                    //"Unexpected code $response"
                    Log.d("PIA14DEBUG", "API FAIL")
                } else {
                    Log.d("PIA14DEBUG", "API OK")
                }

                val theresponsetext = response.body!!.string()
                Log.d("PIA14DEBUG", theresponsetext)

                val apidata = Json {ignoreUnknownKeys = true}.decodeFromString<MenulistAPI>(theresponsetext)

                _menuitems.value = apidata.menu
            }

        }
    }

}