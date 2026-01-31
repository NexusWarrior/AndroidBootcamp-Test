package ru.example.androidcompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ru.example.androidcompose.R
import ru.example.androidcompose.ui.theme.LightGray
import ru.example.androidcompose.ui.theme.MintGreen

@Composable
fun LoginTextField(
    label: String,
    isPassword: Boolean = false
) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text, // Текст, который вводит пользователь
        onValueChange = { text = it }, // Обновляем текст при печати
        label = { Text(label, color = LightGray) }, // Текст-подсказка
        modifier = Modifier.fillMaxWidth(),

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent, // Цвет контейнера при нажатии
            unfocusedContainerColor = Color.Transparent, // Цвет контейнера в покое
            focusedIndicatorColor = MintGreen, // Цвет линии при нажатии
            unfocusedIndicatorColor = LightGray // Цвет линии в покое
        ),

        // Пароль точками
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,

        // Убираем стандартное округления углов TextField
        shape = RoundedCornerShape(0.dp)
    )
}

@Composable
fun PasswordTextField(
    label: String
) {
    var password by remember { mutableStateOf("") }

    var isPasswordVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(label, color = LightGray) },
        modifier = Modifier.fillMaxWidth(),

        visualTransformation =
            if (isPasswordVisible)
                VisualTransformation.None
            else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    painter = painterResource(
                        id = if (isPasswordVisible) R.drawable.ic_visibalty_on else R.drawable.ic_visibility_off
                    ),
                    contentDescription = "Показать/скрыть пароль",
                    tint = LightGray
                )
            }
        },

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = LightGray,
            unfocusedIndicatorColor = LightGray
        )
    )
}