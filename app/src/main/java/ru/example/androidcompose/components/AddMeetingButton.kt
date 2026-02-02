package ru.example.androidcompose.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.example.androidcompose.R
import ru.example.androidcompose.ui.theme.MintGreen
import ru.example.androidcompose.ui.theme.White

@Composable
fun AddMeetingButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = MintGreen,
        shape = RoundedCornerShape(25),
        modifier = Modifier.size(60.dp),
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 6.dp)
    ) {
        Icon(
            modifier = Modifier.size(30.dp),
            painter = painterResource(R.drawable.ic_plus),
            contentDescription = "Создать встречу",
            tint = White
        )
    }
}

@Composable
@Preview
fun AddMeetingPreview() {
    AddMeetingButton(onClick = {})
}