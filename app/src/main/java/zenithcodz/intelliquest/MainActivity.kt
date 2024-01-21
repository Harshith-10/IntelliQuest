package zenithcodz.intelliquest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import kotlinx.coroutines.launch
import zenithcodz.intelliquest.data.Course
import zenithcodz.intelliquest.data.Screen
import zenithcodz.intelliquest.data.courses
import zenithcodz.intelliquest.ui.theme.AzurLane
import zenithcodz.intelliquest.ui.theme.IntelliQuestTheme
import zenithcodz.intelliquest.ui.theme.Inter
import java.time.LocalDateTime
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
class MainActivity : ComponentActivity() {
    private val screens = listOf(
        Screen.Courses,
        Screen.Home,
        Screen.Profile
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            IntelliQuestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainLayout()
                }
            }
        }
    }

    @Preview
    @Composable
    fun MainLayout() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AzurLane)
        ) {
            Column(
                Modifier.safeDrawingPadding()
            ) {
                val pagerState = rememberPagerState(initialPage = 1) {
                    screens.size
                }

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        when (screens[it]) {
                            Screen.Home -> HomeScreen()
                            Screen.Courses -> CoursesScreen()
                            Screen.Profile -> ProfileScreen()
                        }
                    }
                }
                BottomNavigationBar(pagerState = pagerState)
            }
        }
    }

    @Composable
    private fun ProfileScreen() {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp, 0.dp)) {

            Row {
                Text(
                    text = "Profile",
                    fontSize = 28.sp,
                    color = Color.White,
                    fontFamily = Inter,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 16.dp
                        )
                )
                Image(
                    painter = painterResource(id = R.drawable.books_sticker),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 16.dp
                        )
                        .size(42.dp)
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp, 8.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.Black.copy(alpha = 0.7f))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp, 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .padding(end = 16.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.Gray)
                                    .size(64.dp)
                            )
                            Column {
                                Text(
                                    text = "Rohith",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    fontFamily = Inter
                                )
                                Text(
                                    text = "Pro ✨",
                                    fontSize = 14.sp,
                                    color = Color.White.copy(alpha = 0.7f),
                                    fontFamily = Inter,
                                    maxLines = 4,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun CoursesScreen() {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp, 0.dp)) {

            Row {
                Text(
                    text = "Courses",
                    fontSize = 28.sp,
                    color = Color.White,
                    fontFamily = Inter,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 16.dp
                        )
                )
                Image(
                    painter = painterResource(id = R.drawable.books_sticker),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 16.dp
                        )
                        .size(42.dp)
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
            ) {
                items(courses.size) { index ->
                    val course = courses[index]
                    CourseItem(course = course)
                }
            }
        }
    }

    @Composable
    private fun HomeScreen() {
        val hour = LocalDateTime.now().hour
        val greeting = when {
            hour < 12 -> "Good Morning!"
            hour < 17 -> "Good Afternoon!"
            else -> "Good Evening!"
        }
        val sticker = when {
            hour < 12 -> R.drawable.morning_sticker
            hour < 17 -> R.drawable.afternoon_sticker
            else -> R.drawable.evening_sticker
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp, 0.dp)) {

            Row {
                Text(
                    text = greeting,
                    fontSize = 28.sp,
                    color = Color.White,
                    fontFamily = Inter,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 16.dp
                        )
                )
                Image(
                    painter = painterResource(id = sticker),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 16.dp
                        )
                        .size(42.dp)
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp, 8.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.Black.copy(alpha = 0.7f))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp, 8.dp)
                                .clickable {
                                    startActivity(
                                        Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse("https://mediafiles.botpress.cloud/76e23bf4-b2f7-41e5-b4ed-37f44d60a74d/webchat/bot.html")
                                        )
                                    )
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_ai),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .padding(end = 16.dp)
                                    .size(64.dp)
                            )
                            Column {
                                Text(
                                    text = "Chat with AI",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    fontFamily = Inter
                                )
                                Text(
                                    text = "Click here to talk to our AI and get answers to your questions",
                                    fontSize = 14.sp,
                                    color = Color.White.copy(alpha = 0.7f),
                                    fontFamily = Inter,
                                    maxLines = 4,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
                item {
                     Text(
                        text = "Recommended Courses",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = Inter,
                        modifier = Modifier
                            .padding(
                                start = 16.dp,
                                top = 16.dp
                            )
                    )                }
                items(3) { index ->
                    val course = courses[index]
                    CourseItem(course = course)
                }
            }
        }
    }

    @Composable
    private fun CourseItem(course: Course = courses[0]) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Black.copy(alpha = 0.7f))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = course.image),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(64.dp)
                )
                Column {
                    Text(
                        text = course.title,
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = Inter
                    )
                    Text(
                        text = course.description,
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.7f),
                        fontFamily = Inter,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }

    @Composable
    private fun BottomNavigationBar(
        modifier: Modifier = Modifier,
        pagerState: PagerState
    ) {
        val coroutineScope = rememberCoroutineScope()

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black.copy(alpha = 0.7f))
                .then(modifier),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            screens.forEachIndexed { index, screen ->
                val selected = pagerState.currentPage == index
                BottomNavigationItem(
                    icon = if (selected) screen.activeIcon else screen.inactiveIcon,
                    title = screen.title,
                    offset = pagerState.indicatorOffsetForPage(index),
                    isSelected = selected,
                    onClick = {
                        if(index == 0) {
                            startActivity(Intent(this@MainActivity, QuizActivity::class.java))
                        } else {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    }
                )
            }
        }
    }

    @Composable
    private fun BottomNavigationItem(
        icon: Int,
        title: String,
        offset: Float,
        isSelected: Boolean,
        onClick: () -> Unit
    ) {
        val backgroundColor = lerp(
            start = Color.Transparent,
            stop = Color.Black.copy(alpha = 0.5f),
            fraction = offset
        )
        val iconSize = lerp(
            start = 20.dp,
            stop = 24.dp,
            fraction = offset
        )
        val iconTextPadding = lerp(
            start = 0.dp,
            stop = 8.dp,
            fraction = offset
        )

        Row(
            modifier = Modifier
                .padding(6.dp)
                .clip(CircleShape)
                .background(backgroundColor)
                .padding(16.dp, 12.dp)
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .padding(end = iconTextPadding)
                    .size(iconSize)
            )
            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    color = Color.White,
                    fontFamily = Inter
                )
            }
        }
    }

    private fun PagerState.offsetForPage(page: Int) = (currentPage - page) + currentPageOffsetFraction
    private fun PagerState.indicatorOffsetForPage(page: Int) =  1f - offsetForPage(page).coerceIn(-1f, 1f).absoluteValue
}