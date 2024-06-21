package com.example.onboarding.onBoardView


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.onboarding.data.PageData
import com.example.onboarding.R
import com.example.onboarding.dataStore.StoreBoarding

@Composable
fun MainOnBoarding(navController: NavController, store: StoreBoarding) {
    val items = ArrayList<PageData>()
    items.add(
        PageData(
            R.raw.page1,
            "Title 1",
            "Lorem impusum dale boca dale boca dale boca"
        )
    )
    items.add(
        PageData(
            R.raw.page2,
            "Title 2",
            "Lorem impusum dale boca dale boca dale boca"
        )
    )
    items.add(
        PageData(
            R.raw.page3,
            "Title 3",
            "Lorem impusum dale boca dale boca dale boca"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = { items.size },
        initialPage = 0
    )

    OnBoardingPage(item = items, pagerState = pagerState, modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White),
        navController,
        store)
}