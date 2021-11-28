package com.connor.composedemo.onboarding.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.connor.composedemo.R

@Composable
internal fun OnboardingPagerItem(
    page: Int,
    modifier: Modifier = Modifier,
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        val pageImage = when (page) {
            0 -> painterResource(id = R.drawable.search)
            1 -> painterResource(id = R.drawable.beach_chair)
            else -> painterResource(id = -1)
        }

        val pageTitleText = when (page) {
            0 -> stringResource(id = R.string.onboarding_page_one_title)
            1 -> stringResource(id = R.string.onboarding_page_two_title)
            else -> ""
        }

        val pageDescText = when (page) {
            0 -> stringResource(id = R.string.onboarding_page_one_desc)
            1 -> stringResource(id = R.string.onboarding_page_two_desc)
            else -> ""
        }

        Image(
            painter = pageImage,
            contentDescription = "onboarding image",
            Modifier
                .height(200.dp)
                .width(200.dp)
        )

        Text(
            text = pageTitleText,
            fontWeight = FontWeight.Black,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp, 64.dp, 16.dp, 0.dp)
        )
        Text(
            text = pageDescText,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
        )
    }
}