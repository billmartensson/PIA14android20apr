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

    private var _menutypes = MutableStateFlow(listOf<MenuType>())
    val menutypes: StateFlow<List<MenuType>> = _menutypes.asStateFlow()

    private var _menuitems = MutableStateFlow(listOf<MenuItem>())
    val menuitems: StateFlow<List<MenuItem>> = _menuitems.asStateFlow()

    private var _newsitems = MutableStateFlow(listOf<NewsItem>())
    val newsitems: StateFlow<List<NewsItem>> = _newsitems.asStateFlow()

    private var _restaurants = MutableStateFlow(listOf<Restaurant>())
    val restaurants: StateFlow<List<Restaurant>> = _restaurants.asStateFlow()


    fun loadconfig() {
        // https://firebasestorage.googleapis.com/v0/b/pia14-bdf2a.firebasestorage.app/o/piaconfig.json?alt=media&token=f44afc3f-d42a-49fa-9ddc-6cc7d2159fa6

        val apiurl = "https://firebasestorage.googleapis.com/v0/b/pia14-bdf2a.firebasestorage.app/o/piaconfig.json?alt=media&token=f44afc3f-d42a-49fa-9ddc-6cc7d2159fa6"

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

                val apidata = Json {ignoreUnknownKeys = true}.decodeFromString<PiaconfigAPI>(theresponsetext)

                _menutypes.value = apidata.menutypes
            }

        }
    }

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

    fun loadnews() {
        val apiurl = "https://firebasestorage.googleapis.com/v0/b/pia14-bdf2a.firebasestorage.app/o/newsdata.json?alt=media&token=af28a491-c44e-4d4c-9cd8-706379a4ed74"

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

                val apidata = Json {ignoreUnknownKeys = true}.decodeFromString<NewsAPI>(theresponsetext)

                _newsitems.value = apidata.news
            }

        }
    }

    fun loadrestaurants() {
        val apiurl = "https://firebasestorage.googleapis.com/v0/b/pia14-bdf2a.firebasestorage.app/o/restaurants.json?alt=media&token=86a38952-aa48-4cfe-b425-03b753d742ad"

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

                val apidata = Json {ignoreUnknownKeys = true}.decodeFromString<RestuarantsAPI>(theresponsetext)

                _restaurants.value = apidata.restaurants
            }

        }
    }
}