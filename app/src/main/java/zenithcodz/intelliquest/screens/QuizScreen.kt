package zenithcodz.intelliquest.screens

import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zenithcodz.intelliquest.R

@Composable
fun quizzez() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Row (
            modifier = Modifier
                .background(Color.Transparent)
                .padding(15.dp)
                .fillMaxWidth()

        ){

        }
        Row (
            modifier = Modifier
                .background(Color.Transparent)
                .padding(10.dp)
                .fillMaxWidth()

        ){
            Row (
                modifier = Modifier
                    .background(Color.White)
                    .width(118.dp)
                    .height(54.dp)
                    .weight(2F)
            ){
                Text(text = "Quiz",
                    fontSize =30.sp )
            }
            Row (
                modifier = Modifier
                    .background(Color.White)
            ){
                Text(text = "10/20")
            }
        }
            Box(
                modifier = Modifier
                    .padding(horizontal = 50.dp, vertical = 40.dp)
                    .background(Color.Cyan, RoundedCornerShape(20.dp))
                    .height(209.dp)
                    .width(316.dp),
                contentAlignment = Alignment.TopCenter,
            ) {}
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .background(Color.Transparent)
                .padding(horizontal = 50.dp, vertical = 5.dp)
                .size(width = 300.dp, height = 67.dp),

            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        ) {}
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .background(Color.Transparent)
                .padding(horizontal = 50.dp, vertical = 10.dp)
                .size(width = 300.dp, height = 67.dp),

            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        ) {}
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .background(Color.Transparent)
                .padding(horizontal = 50.dp, vertical = 10.dp)
                .size(width = 300.dp, height = 67.dp),

            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        ) {}
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .background(Color.Transparent)
                .padding(horizontal = 50.dp, vertical = 10.dp)
                .size(width = 300.dp, height = 67.dp),

            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        ) {}
        Button(
            onClick = { },
            modifier = Modifier
                .background(Color.Transparent)
                .padding(horizontal = 50.dp, vertical = 10.dp)
                .size(width = 30.dp, height = 30.dp),

            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        ) {}
            Box(modifier = Modifier
                .size(width = 756.dp, height = 500.dp)
                .background(
                    Color.Black,
                    RoundedCornerShape(
                        topStart = 18.dp,
                        topEnd = 18.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .padding(vertical = 10.dp, horizontal = 50.dp)

            ){
                Row (
                    modifier = Modifier

                ){
                    FloatingActionButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(500.dp)
                            .width(50.dp)
                            .clip(CircleShape)
                            .clickable {}
                    ) {
                        Icon(painterResource(id =R.drawable.powerupmodified ),
                            contentDescription = "Players can get 1.5x the score for 20 seconds when they play at a faster speed ")
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    FloatingActionButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(500.dp)
                            .width(50.dp)
                            .clip(CircleShape)
                            .clickable {}
                    ){
                        Icon(painterResource(id =R.drawable.doublejeopardy_modified ),
                            contentDescription = "Players get double the score if they choose the correct answer but lose it all if they choose the wrong answer")
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    FloatingActionButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(500.dp)
                            .width(50.dp)
                            .clip(CircleShape)
                            .clickable {}
                    ){
                        Icon(painterResource(id =R.drawable.fifty_fiftypowerupmodified ),
                            contentDescription = "Eliminates half of the incorrect answer options ")
                    }

                }

        }

    }
//    Scaffold(modifier = Modifier
//        .background(Color.White),
//        bottomBar = {
//            BottomAppBar(
//                actions = {},
//                floatingActionButton = {
//                    FloatingActionButton(
//                        onClick = { /* do something */ },
//                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
//                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
//                    ) {
//                        Icon(Icons.Filled.Add, "Localized description")
//                    }
//
//                }
//            )
//        },
//    ) { innerPadding ->
//        Text(
//            modifier = Modifier.padding(innerPadding),
//            text = "Example of a scaffold with a bottom app bar."
//        )
//    }

}

@Preview(showBackground = true)
@Composable
fun Lollt() {
    quizzez()
    
}