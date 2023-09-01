package com.example.laboratorio6

import android.content.Intent
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import com.example.laboratorio6.ui.theme.Laboratorio6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login("jorge")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var text by remember { mutableStateOf(TextFieldValue(name)) }
    var passwordText by remember { mutableStateOf(TextFieldValue("")) }
    Column {

        Text(
            text = "Bienvenido ${text.text}!",
            modifier = modifier.padding(20.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp


        )
        TextField(
            value = text,
            onValueChange = { newText ->
                if (newText.text.length <= 10) {
                    text = newText
                }
            },
            label = { Text("Username (max 10 characters)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(60.dp)
        )

        Spacer(modifier = Modifier.height(10.dp)
        )

        TextField(
            value = passwordText,
            onValueChange = { newText ->
                if (newText.text.length <= 8) {
                    passwordText = newText
                }
            },
            label = { Text("Password (max 8 characters)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password, // Cambia a KeyboardType.Password
                imeAction = ImeAction.Done
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(60.dp)
        )

        Spacer(modifier = Modifier.height(10.dp)
        )

        Button(
            onClick = {
                if (isValidCredentials(text.text, passwordText.text)) {
                    val intent = Intent(context, Galeria::class.java)
                    context.startActivity(intent)
                } else {
                    // Mostrar mensaje de error o manejar la validación incorrecta
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Login")
        }
    }
}

// Función para validar las credenciales
fun isValidCredentials(username: String, password: String): Boolean {
    return username == "jorge" && password == "12345"
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Laboratorio6Theme {
        Login("jorge")
    }
}