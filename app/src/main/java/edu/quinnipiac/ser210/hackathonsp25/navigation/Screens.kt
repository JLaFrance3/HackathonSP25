package edu.quinnipiac.ser210.hackathonsp25.navigation

enum class Screens {
    HomeScreen,
    JobScreen,
    PetSuppliesScreen,
    ProfileScreen,
    SavedJobsScreen;
    companion object {
        fun fromRoute(route: String?): Screens
                = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailScreen.name -> DetailScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route not recognized")
        }
    }
}