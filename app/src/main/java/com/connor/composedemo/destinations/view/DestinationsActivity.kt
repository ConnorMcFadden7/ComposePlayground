package com.connor.composedemo.destinations.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.connor.composedemo.R
import com.connor.composedemo.destinations.api.model.Destination

//todo if I have time add searching
class DestinationsActivity : ComponentActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDestinationList(getDestinations() + getDestinations() + getDestinations())
        }
    }

    @Composable
    fun ComposeDestinationList(destinations: List<Destination>) {
        // LazyColumn = It'll only draw out views which are visible to the user. The principles
        // RE recycling are the same as RecyclerView https://developer.android.com/jetpack/compose/lists
        LazyColumn(Modifier.padding(16.dp)) {
            items(destinations.size) { index ->
                Spacer(modifier = Modifier.padding(4.dp))
                LazyRow {
                    item {
                        Image(
                            painter = painterResource(id = destinations[index].flag),
                            contentDescription = "flag"
                        )

                        Column(Modifier.padding(horizontal = 8.dp)) {
                            Text(text = destinations[index].cityTown, fontWeight = FontWeight.Bold)
                            Text(text = destinations[index].country)
                        }
                    }
                }


                Spacer(modifier = Modifier.padding(4.dp))
                Divider(color = Color.LightGray)

            }
        }
    }

    private fun getDestinations(): List<Destination> {
        val destinations = mutableListOf<Destination>()

        destinations.add(Destination(R.drawable.ic_canada, "Banff Town", "Canada"))
        destinations.add(Destination(R.drawable.ic_philippines, "Manila", "Philippines"))
        destinations.add(Destination(R.drawable.ic_ireland, "Dublin", "Ireland"))
        destinations.add(Destination(R.drawable.ic_switzerland, "Zurich", "Switzerland"))
        destinations.add(Destination(R.drawable.ic_italy, "Lake Garda", "Italy"))
        destinations.add(Destination(R.drawable.ic_canada, "Toronto", "Canada"))

        return destinations
    }

}