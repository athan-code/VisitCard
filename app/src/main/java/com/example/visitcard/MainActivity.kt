package com.example.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitcard.ui.theme.VisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisitCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting()
                }
            }
        }
    }
}

// VISIT CARD COMPOSABLE :
@Composable
fun VisitCard(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(25.dp)
            .fillMaxSize()
    ) {
        Entete(
            image = painterResource(id = R.drawable.android_logo),
            name = "athan-code",
            title = "Développeur Android Kotlin",
            modifier = Modifier
                .weight(3f)
        )
        TripleCoordonnees(
            "+33(0) 7 55 32 48 96",
            "25 rue Alexandre le Grand",
            "athan-code@gmail.com",
            Icons.Rounded.Phone,
            Icons.Rounded.Home,
            Icons.Rounded.Email,
            modifier = Modifier
                .weight(1f)
        )
    }
}

/*
*******************************
* LES COMPOSANTS INDIVIDUELS :
*******************************
*/

// ENTETE DE PRESENTATION :
@Composable
fun Entete(
    image: Painter,
    name: String,
    title: String,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(116.dp)
        )
        Text(
            text = name,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic)
    }
}

@Composable
fun Coordonnees(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
//            .fillMaxWidth(),
//            .padding(start = 80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            tint = Color(0xFF00DD7A),
            contentDescription = null,
            modifier = Modifier
                .size(28.dp)
//                .weight(1f)
        )
        Text(
            text = text,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(start = 8.dp)
//                .weight(4f)
        )
    }
}

@Composable
fun TripleCoordonnees(
    text1: String,
    text2: String,
    text3: String,
    icon1: ImageVector,
    icon2: ImageVector,
    icon3: ImageVector,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .padding(start = 50.dp)
//            .fillMaxWidth()
    ) {
        Coordonnees(text = text1, icon = icon1)
        Coordonnees(text = text2, icon = icon2)
        Coordonnees(text = text3, icon = icon3)
    }
}

/*
*******************************
* PREVIEWS DE DEBUG :
*******************************
*/

// PREVIEW D'UNE VISIT CARD :
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VisitCardPreview() {
    VisitCardTheme {
        VisitCard()
    }
}

/*
// PREVIEW D'UNE EN-TÊTE :
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EntetePreview() {
    VisitCardTheme {
        Entete(
            image = painterResource(id = R.drawable.android_logo),
            name = "athan-code",
            title = "Développeur Android Kotlin"
        )
    }
}

// PREVIEW D'UNE LISTE DE 3 COORDONNEES :
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TripleCoordonneesPreview() {
    VisitCardTheme {
        TripleCoordonnees(
            "+33(0) 7 55 32 48 96",
            "25 rue Alexandre le Grand",
            "athan-code@gmail.com",
            Icons.Rounded.Phone,
            Icons.Rounded.Home,
            Icons.Rounded.Email
        )
    }
}

// PREVIEW D'UNE COORDONNEE :
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoordonneesPreview() {
    VisitCardTheme {
        Coordonnees("test",Icons.Rounded.Phone)
    }
}
*/
