package ru.example.androidcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.example.androidcompose.components.GradientButton
import ru.example.androidcompose.components.LoginTextField
import ru.example.androidcompose.components.PasswordTextField
import ru.example.androidcompose.ui.theme.MintGreen
import ru.example.androidcompose.ui.theme.White
import ru.example.androidcompose.ui.theme.backgroundGradient
import ru.example.androidcompose.ui.theme.buttonGradient


@Composable
fun Registration() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = backgroundGradient
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(14.5.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(24.dp)
            ) {
                // TODO: Добавить иконку приложения
                Text(
                    text = "MeetFlow",
                    color = White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Surface(
                modifier = Modifier
                    .padding(vertical = 14.5.dp),
                shape = RoundedCornerShape(25.dp),
                color = Color.White,
                shadowElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Регистрация",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    LoginTextField(label = "Почта:")

                    Spacer(modifier = Modifier.height(16.dp))

                    PasswordTextField(label = "Пароль:")

                    Spacer(modifier = Modifier.height(40.dp))

                    GradientButton(
                        text = "Зарегистрироваться",
                        gradient = buttonGradient
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    TextButton(
                        onClick = {},
                    ) {
                        Text(
                            text = "Войти",
                            color = MintGreen,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Show() {
    Registration()
}
