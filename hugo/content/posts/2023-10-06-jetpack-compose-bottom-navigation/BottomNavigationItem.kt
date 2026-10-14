package com.swiswiswift.swiswikotlin

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val id: Route,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)
