package ru.example.androidcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.example.androidcompose.R
import ru.example.androidcompose.components.GradientButton
import ru.example.androidcompose.ui.theme.LightGray
import ru.example.androidcompose.ui.theme.MintGreen
import ru.example.androidcompose.ui.theme.White
import ru.example.androidcompose.ui.theme.backgroundGradient
import ru.example.androidcompose.ui.theme.buttonGradient


@Composable
fun Registration() {

    var email by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    val isFormValid = email.isNotBlank() && password.isNotBlank()

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
            modifier = Modifier.padding(14.5.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(24.dp)
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
                modifier = Modifier.padding(vertical = 14.5.dp),
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

                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Почта:", color = LightGray) },
                        modifier = Modifier.fillMaxWidth(),

                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = MintGreen,
                            unfocusedIndicatorColor = LightGray
                        ),

                        shape = RoundedCornerShape(0.dp)
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Пароль", color = LightGray) },
                        modifier = Modifier.fillMaxWidth(),

                        visualTransformation =
                            if (isPasswordVisible)
                                VisualTransformation.None
                            else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                                Icon(
                                    painter = painterResource(
                                        id = if (isPasswordVisible) R.drawable.ic_visibilty_on else R.drawable.ic_visibility_off
                                    ),
                                    contentDescription = "Показать/скрыть пароль",
                                    tint = LightGray
                                )
                            }
                        },

                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = MintGreen,
                            unfocusedIndicatorColor = LightGray
                        )
                    )

                    Spacer(modifier = Modifier.height(54.dp))

                    GradientButton(
                        modifier = Modifier,
                        text = "Зарегистрироваться",
                        gradient =
                            if (isFormValid) buttonGradient
                            else Brush.linearGradient(listOf(LightGray, LightGray)),
                        enabled = isFormValid,
                        onClick = {}
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    TextButton(
                        onClick = {}
                    ) {
                        Text(
                            text = "Войти",
                            color =
                                if (isFormValid) MintGreen
                                else LightGray,
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