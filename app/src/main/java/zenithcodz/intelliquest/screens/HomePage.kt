package zenithcodz.intelliquest.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zenithcodz.intelliquest.R
import zenithcodz.intelliquest.dataclasses.CourseListClass

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val courseList = listOf(
        CourseListClass(
            tagLine = "learn more",
            subject = "Physics",
            icon = R.drawable.phyicons
        ),
        CourseListClass(
            tagLine = "learn more",
            subject = "Chemistry",
            icon = R.drawable.chemistryicon
        ),
        CourseListClass(
            tagLine = "learn more",
            subject = "Maths",
            icon = R.drawable.mathsicon
        ),
        CourseListClass(
            tagLine = "learn more",
            subject = "OOP",
            icon = R.drawable.oopicon
        )
    )

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { courseList.size })
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(20.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.placeholder_profilepic),
                    contentDescription = "placeholder profile pic",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Welcome Back",
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "Maximus5470",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
            }
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.LightGray.copy(alpha = 0.5f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "placeholder statistics icon",
                    modifier = Modifier.padding(8.dp),
                    tint = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Course List",
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            fontSize = MaterialTheme.typography.titleLarge.fontSize
        )
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalPager(
            state = pagerState,
            beyondBoundsPageCount = courseList.size,
            pageSpacing = (-180).dp
        ) { page ->
            CourseListCarouselLayout(courseList[page])
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Your Progress on quiz",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(14.dp))
        LinearProgressIndicator(
            progress = 0.7f,
            color = Color.Black,
            trackColor = Color.LightGray,
            modifier = Modifier
                .height(16.dp)
                .fillMaxWidth()
                .clip(CircleShape),
            strokeCap = StrokeCap.Round
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "You finished ___ quizzes out of ___",
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "Events",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(
            text = "No events currently available",
            color = Color.Black
        )
    }
}

@Composable
fun CourseListCarouselLayout(carousel: CourseListClass) {
    Column(
        modifier = Modifier
            .size(width = 150.dp, height = 200.dp)
            .background(color = Color.Black, shape = RoundedCornerShape(8.dp))
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(color = Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = carousel.icon),
                contentDescription = "icon",
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = carousel.subject,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.White),
            contentPadding = PaddingValues(8.dp)
        ) {
            Text(
                text = "View Modules",
                color = Color.Black,
            )
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeScreen()
}

