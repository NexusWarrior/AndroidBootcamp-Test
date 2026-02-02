package ru.example.androidcompose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.example.androidcompose.components.ActivityCard
import ru.example.androidcompose.components.AddMeetingButton
import ru.example.androidcompose.components.BottomMenu
import ru.example.androidcompose.components.HeaderCalendar
import ru.example.androidcompose.ui.theme.Black
import ru.example.androidcompose.ui.theme.LineGrey
import ru.example.androidcompose.ui.theme.White
import ru.example.androidcompose.ui.theme.activityCardGradient1
import ru.example.androidcompose.ui.theme.activityCardGradient2
import ru.example.androidcompose.ui.theme.activityCardGradient3

@Composable
fun MyMeetings() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        bottomBar = {
            Box(modifier = Modifier.navigationBarsPadding()) {
                BottomMenu(num = 1)
            }
        },
        floatingActionButton = {
            AddMeetingButton {}
        },
        containerColor = White
    ) { innerPadding -> // innerPadding учитывает высоту BottomBar

        // LazyColumn - прокручиваемый список
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item {
                Column(modifier = Modifier.padding(top = 24.dp)) {
                    Text(
                        text = "Мои встречи",
                        color = Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(21.dp))

                    HeaderCalendar()

                    Spacer(modifier = Modifier.height(10.dp))

                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(elevation = 4.dp),
                        thickness = 1.dp,
                        color = LineGrey,
                    )

                    Spacer(modifier = Modifier.height(37.dp))
                }
            }

            // Список карточек
            items(
                listOf(
                    activityCardGradient1 to "15 Марта, 2026",
                    activityCardGradient2 to "16 Марта, 2026",
                    activityCardGradient3 to "17 Марта, 2026"
                )
            ) { (gradient, date) ->
                ActivityCard(
                    title = "Синхронизация проекта",
                    time = "10:00 - 11:00",
                    date = date,
                    gradient = gradient
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item { Spacer(modifier = Modifier.height(80.dp)) }
        }
    }
}

@Preview
@Composable
fun MyMeetingsPreview() {
    MyMeetings()
}