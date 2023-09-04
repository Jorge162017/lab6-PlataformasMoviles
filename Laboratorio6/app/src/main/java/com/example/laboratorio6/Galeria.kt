package com.example.laboratorio6
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio6.ui.theme.Laboratorio6Theme


class Galeria : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Laboratorio6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting()
                }
            }
        }
    }
}


@Composable
fun Greeting() {
    val context = LocalContext.current
    val imageResources = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10
    )

    var currentImage by remember { mutableStateOf(0) }
    val imageDescriptions = listOf(
        "Penny",
        "Jessie",
        "Bo",
        "Edgar",
        "Nita",
        "El Primo",
        "Shelly",
        "Poco",
        "Crow",
        "Dynamike",

    )
    //val currentDescription by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(1100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Brawls",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp
            )
            Button(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
            ) {
                Text("Log Out", fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
            }
        }

        Image(
            painter = painterResource(id = imageResources[currentImage]), contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                //.border(2.dp, Color.Black)
                .shadow(elevation = 15.dp, shape = RoundedCornerShape(20.dp))
        )
        Text(
            text = imageDescriptions[currentImage], // Muestra la descripción actual
            modifier = Modifier
                .wrapContentSize(Alignment.TopCenter)
                .padding(16.dp),
            fontSize = 16.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            //boton para regresar a la imagen anterior
            Button(
                onClick = {
                    if (currentImage > 0 ) {
                        currentImage -= 1
                    }
                },
                enabled = currentImage > 0
            ) {
                Text("BACK", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            }
            //boton para ir a la siguiente imagen
            Button(
                onClick = {
                    if (currentImage < imageResources.size - 1) {
                        currentImage += 1
                    }
                },
                enabled = currentImage < imageResources.size - 1
            ) {
                Text("NEXT", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Laboratorio6Theme {
        Greeting()
    }
}
