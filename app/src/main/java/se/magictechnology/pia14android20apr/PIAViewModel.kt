package se.magictechnology.pia14android20apr

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PIAViewModel : ViewModel() {

    private var _menuitems = MutableStateFlow(listOf<MenuItem>())
    val menuitems: StateFlow<List<MenuItem>> = _menuitems.asStateFlow()


    fun loadmenu() {
        var tempmenuitems = mutableListOf<MenuItem>()

        var m1 = MenuItem(title = "Pizza", description = "Pizza with cheese", price = "99kr", menutype = "main", image = "")
        var m2 = MenuItem(title = "Hamburger", description = "Hamburger with cheese", price = "129kr", menutype = "main", image = "")

        tempmenuitems.add(m1)
        tempmenuitems.add(m2)

        _menuitems.value = tempmenuitems
    }

}