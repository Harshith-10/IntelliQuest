package zenithcodz.intelliquest.screens

import android.graphics.RenderEffect
import android.graphics.Shader
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
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zenithcodz.intelliquest.R
import zenithcodz.intelliquest.dataclasses.CourseListClass
import kotlin.math.absoluteValue

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
        ),
        CourseListClass(
            tagLine = "learn more",
            subject = "Maths",
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
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = carousel.tagLine,
            color = Color.White,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .size(width = 120.dp, height = 40.dp)
                .background(color = Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center
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