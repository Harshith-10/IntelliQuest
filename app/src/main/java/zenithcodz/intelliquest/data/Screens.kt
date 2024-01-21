package zenithcodz.intelliquest.data

import zenithcodz.intelliquest.R

sealed class Screen(
    val activeIcon: Int,
    val inactiveIcon: Int,
    val title: String
) {
    data object Home : Screen(
        activeIcon = R.drawable.home_filled_24,
        inactiveIcon = R.drawable.home_outlined_24,
        title = "Home"
    )

    data object Courses : Screen(
        activeIcon = R.drawable.courses_filled_24,
        inactiveIcon = R.drawable.courses_outlined_24,
        title = "Courses"
    )

    data object Profile : Screen(
        activeIcon = R.drawable.profile_filled_24,
        inactiveIcon = R.drawable.profile_outlined_24,
        title = "Profile"
    )
}