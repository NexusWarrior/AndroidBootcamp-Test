package ru.example.androidcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.example.androidcompose.ui.theme.MintGreen

@Composable
fun HeaderCalendar() {
    // 1. Состояние пейджера (начальная страница 0)
    val pagerState = rememberPagerState(pageCount = { 10 })

    // Состояние выбранной даты (общая для всех страниц)
    var selectedDate by remember { mutableStateOf("27") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.5.dp)
    ) {
        // 2. Горизонтальный динамический календарь
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) { page ->
            // Содержимое одной страницы (недели)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val weekDates = getDatesForPage(page)

                weekDates.forEach { (day, date) ->
                    DayItem(
                        day = day,
                        date = date,
                        isSelected = date == selectedDate,
                        onDateClick = { selectedDate = date }
                    )
                }
            }
        }
    }
}

@Composable
fun DayItem(day: String, date: String, isSelected: Boolean, onDateClick: () -> Unit) {
    // 4. Добавляем clickable к Column, чтобы весь элемент реагировал на нажатие
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null // Убираем стандартный серый квадрат при клике для красоты
        ) {
            onDateClick()
        }
    ) {
        Text(text = day, color = Color.Gray, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(7.dp))
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(
                    color = if (isSelected) MintGreen else Color.Transparent,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = date,
                color = if (isSelected) Color.White else Color.Black,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                fontSize = 20.sp
            )
        }
    }
}

// Функция для получения списка дат недели на основе индекса страницы
// 0 — текущая неделя, 1 — следующая и т.д.
fun getDatesForPage(page: Int): List<Pair<String, String>> {
    val days = listOf("Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс")
    val startDate = 1 + (page * 7) // Простая логика: 1, 8, 15...
    return days.mapIndexed { index, day ->
        day to (startDate + index).toString()
    }
}

@Preview
@Composable
fun HeaderCalendarPreview() {
    HeaderCalendar()
}