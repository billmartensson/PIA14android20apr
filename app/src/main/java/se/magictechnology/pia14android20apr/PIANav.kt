package se.magictechnology.pia14android20apr

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute

@Composable
fun PIANav(
    modifier: Modifier = Modifier,
    piavm : PIAViewModel = viewModel(),
    navController: NavHostController,
    startDestination: String
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        // MENU
        navigation(route = PIARoute.MENUMAIN.name, startDestination = PIARoute.MENULIST.name) {
            composable(PIARoute.MENULIST.name) {
                MenuList(piavm = piavm, goDetail = { menuitem ->
                    navController.navigate(menuitem)
                })
            }

            composable<MenuItem> { backStackEntry ->
                val menuitem : MenuItem = backStackEntry.toRoute()
                MenuDetail(piavm = piavm, currentmenuitem = menuitem)
            }

        }

        // NEWS
        navigation(route = PIARoute.NEWSMAIN.name, startDestination = PIARoute.NEWS.name) {
            composable(PIARoute.NEWS.name) {
                News(piavm = piavm)
            }
        }

        // RESTAURANTS
        navigation(route = PIARoute.RESTAURANTSMAIN.name, startDestination = PIARoute.RESTURANTS.name) {
            composable(PIARoute.RESTURANTS.name) {
                Restaurants(piavm = piavm)
            }
        }

    }
}