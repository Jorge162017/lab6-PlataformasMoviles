package com.example.laboratorio6
import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.remember
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
                    Greeting("Brawls")
                }
            }
        }
    }
}
data class CarouselItem(
    val title: String,
    val description: String,
    val imageResId: Int
)




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "$name",
            modifier = modifier
                .fillMaxSize()
                .fillMaxWidth()
                .wrapContentSize(Alignment.TopCenter),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp
        )
        val carouselItems = listOf(
            CarouselItem("Penny", "Descripción penny", R.drawable.image1),
            CarouselItem("Jessie", "Descripción jessie", R.drawable.image2),
            // Agrega más elementos según sea necesario
        )
        //ImageCarousel(items = carouselItems)

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Laboratorio6Theme {
        Greeting("Brawls")
    }
}
