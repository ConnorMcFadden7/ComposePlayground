package com.connor.composedemo.onboarding.view

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.connor.composedemo.R
import com.connor.composedemo.ui.theme.ConnorComposeDemoTheme
import com.connor.composedemo.ui.utils.AppButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

class OnboardingActivity : ComponentActivity() {

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //todo Do we need to call this everytime?
            ConnorComposeDemoTheme {
                BuildOnboarding()
            }
        }
    }

    @ExperimentalPagerApi
    @Composable
    fun BuildOnboarding() {
        val context = LocalContext.current

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            val pagerState = rememberPagerState()

            HorizontalPager(
                count = 2,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                state = pagerState
            ) { page ->
                
                OnboardingPagerItem(page = page, modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                )
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                activeColor = MaterialTheme.colors.primary
            )

            AppButton(
                buttonText = stringResource(id = R.string.onboarding_get_started_button_cta),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                //
            }
            AppButton(
                buttonText = stringResource(id = R.string.onboarding_already_have_account_cta),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                val intent = Intent(context, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}