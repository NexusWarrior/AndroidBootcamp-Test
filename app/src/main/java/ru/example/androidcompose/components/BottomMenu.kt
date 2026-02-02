package ru.example.androidcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.example.androidcompose.R
import ru.example.androidcompose.ui.theme.Gray
import ru.example.androidcompose.ui.theme.MintGreen
import ru.example.androidcompose.ui.theme.White

@Composable
fun BottomMenu(num: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(color = White),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround, // Равномерно распределяет иконки
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                modifier = Modifier.size(45.dp),
                painter = painterResource(R.drawable.ic_calendar),
                contentDescription = "Календарь",
                tint = if (num == 1) MintGreen else Gray,
            )

            Icon(
                modifier = Modifier.size(45.dp),
                painter = painterResource(R.drawable.ic_invitations),
                contentDescription = "Приглашения",
                tint = if (num == 2) MintGreen else Gray
            )

            Icon(
                modifier = Modifier.size(45.dp),
                painter = painterResource(R.drawable.ic_profile),
                contentDescription = "Профиль",
                tint = if (num == 3) MintGreen else Gray
            )
        }
    }
}

@Composable
@Preview
fun BottomMenuPreview() {
    BottomMenu(num = 0)
}