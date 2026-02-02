package ru.example.androidcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.example.androidcompose.R
import ru.example.androidcompose.ui.theme.White
import ru.example.androidcompose.ui.theme.activityCardGradient1

@Composable
fun ActivityCard(
    title: String,
    time: String,
    date: String,
    gradient: Brush
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 21.5.dp),
        shape = RoundedCornerShape(25.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = gradient) // Фон
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Spacer(
                    modifier = Modifier.height(17.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title, // Название мероприятия
                        color = White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(35.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_action_menu),
                            contentDescription = null,
                            tint = White
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 5.dp
                        )
                ) {
                    Text(
                        text = time, // Время проведения
                        color = White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 21.dp,
                            horizontal = 5.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(23.dp),
                        painter = painterResource(
                            R.drawable.ic_calendar
                        ),
                        contentDescription = null,
                        tint = White
                    )
                    Spacer(
                        modifier = Modifier.width(11.dp)
                    )
                    Text(
                        text = date, // Дата проведения
                        color = White,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun ActivityCardPreview() {
    Column {
        ActivityCard(
            gradient = activityCardGradient1,
            title = "Cинхронизация проекта",
            time = "10:00 - 11:00",
            date = "15 Марта, 2026"
        )
    }
}