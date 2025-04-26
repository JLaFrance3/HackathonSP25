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
            JobScreen.name -> JobScreen
            PetSuppliesScreen.name -> PetSuppliesScreen
            ProfileScreen.name -> ProfileScreen
            SavedJobsScreen.name -> SavedJobsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route not recognized")
        }
    }
}