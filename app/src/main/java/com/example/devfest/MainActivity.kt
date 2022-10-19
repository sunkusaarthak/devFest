package com.example.devfest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.devfest.ui.theme.DevFestTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevFestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                ) {
                    Greeting()
                    vizag()
                    lastCard("Sundar Pichai", "CEO", "3")
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Surface(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google Image",
                modifier = Modifier.size(100.dp, 300.dp),
                alignment = Alignment.TopStart
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.gdg),
                contentDescription = "Google Developer Group Image",
                modifier = Modifier.size(100.dp, 100.dp),
                alignment = Alignment.TopEnd
            )
        }
    }
}

@Composable
fun vizag() {
    Row(modifier = Modifier.height(100.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.vizag),
            contentDescription = "vizag",
            modifier = Modifier
                .fillMaxWidth())
    }
}

@Composable
fun lastCard(name: String, designation: String, reserved: String) {
        val fontFamily = FontFamily(
            Font(R.font.googlesans_regular, FontWeight.Normal),
            Font(R.font.googlesans_bold, FontWeight.Bold)
        )
        Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Start, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)){
            Column {
                Text(
                    "$name",
                    Modifier
                        .padding(0.dp, 0.dp, 0.dp, 5.dp)
                        .width(150.dp),
                    fontSize = 35.sp,
                    lineHeight = 40.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff7d7d7d)
                )
                Text("$designation", Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp), fontFamily = fontFamily, color = Color(0xffababab))
                Spacer(modifier = Modifier.size(0.dp, 5.dp))
                Row(verticalAlignment = Alignment.Bottom    ) {
                    Text("Reserved", Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp), fontSize = 20.sp, fontFamily = fontFamily, color = Color(0xffababab))
                    Text("$reserved", Modifier.padding(16.dp, 0.dp, 0.dp, 16.dp), fontSize = 30.sp, fontFamily = fontFamily, color = Color(0xff7d7d7d), fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.sundar),
                contentDescription = "Profile Image",

                modifier = Modifier
                    .size(150.dp, 160.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(2.dp, Color.White, RoundedCornerShape(16.dp))
                ,
                contentScale = ContentScale.Crop,
            )
        }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DevFestTheme {
        Greeting()
        vizag()
        lastCard("Sundar Pichai", "CEO", "3")
    }
}