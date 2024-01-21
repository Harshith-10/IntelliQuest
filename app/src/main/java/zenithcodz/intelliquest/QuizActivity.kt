package zenithcodz.intelliquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import zenithcodz.intelliquest.ui.theme.AzurLane
import zenithcodz.intelliquest.ui.theme.IntelliQuestTheme
import zenithcodz.intelliquest.ui.theme.Inter
import zenithcodz.intelliquest.ui.viewmodels.QuizViewModel

class QuizActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            IntelliQuestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuizScreen()
                }
            }
        }
    }

    @Preview
    @Composable
    private fun QuizScreen(quizViewModel: QuizViewModel = viewModel()) {
        val quizState by quizViewModel.uiState.collectAsState()
        val currentQuestion = quizState.currentQuestion
        val density = LocalDensity.current

        LaunchedEffect(Unit) {
            quizViewModel.createQuiz(this@QuizActivity)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(AzurLane)
                .safeDrawingPadding()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 16.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.quiz_sticker
                    ),
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(28.dp)
                )

                Text(
                    text = "Quiz",
                    fontSize = 28.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontFamily = Inter
                )

                Spacer(Modifier.weight(1f))

                AnimatedVisibility(
                    visible = quizViewModel.isStreak(),
                    enter =
                    slideInHorizontally(initialOffsetX = { with(density){ 40.dp.roundToPx() } })
                            + expandIn(expandFrom = Alignment.Center)
                            + fadeIn(),

                    exit =
                    slideOutHorizontally(targetOffsetX = { with(density){ 40.dp.roundToPx() } })
                            + shrinkOut()
                            + fadeOut(),
                    modifier = Modifier.clip(CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.streak_color_transparent),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 6.dp)
                            .clip(CircleShape)
                            .background(Color.Black.copy(alpha = 0.7f))
                            .padding(8.dp)
                            .size(24.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.Black.copy(alpha = 0.7f)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${quizState.numberOfCorrectAnswers} | ${quizState.numberOfAttemptedQuestions} | ${quizState.numberOfQuestions}",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(16.dp, 24.dp)
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(MaterialTheme.shapes.large)
                    .shadow(10.dp)
                    .background(Color.White)
            ) {
                Text(
                    text = quizState.currentQuestion.question,
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = Inter,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                )
            }

            Column(
                Modifier.verticalScroll(rememberScrollState())
            ) {
                currentQuestion.options.forEachIndexed { index, answer ->
                    val containerColor by animateColorAsState(
                        targetValue =
                        if(quizState.selectedOption != -1) {
                            if(index == currentQuestion.answer)
                                Color.Green
                            else Color.Red
                        } else Color.White,
                        label = ""
                    )

                    val contentColor = if (quizState.selectedOption == -1) Color.Black else Color.White

                    AnswerCard(
                        answer = answer,
                        onClick = {
                            quizViewModel.processAnswer(index)
                        },
                        modifier = Modifier
                            .padding(16.dp, 4.dp)
                            .fillMaxWidth()
                            .height(60.dp)
                            .clip(MaterialTheme.shapes.large),
                        containerColor = containerColor,
                        contentColor = contentColor
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun AnswerCard(
        answer: String,
        onClick: () -> Unit,
        modifier: Modifier,
        containerColor: Color = Color.White,
        contentColor: Color = Color.Black,
    ) {
        Card(
            modifier = modifier,
            onClick = onClick,
            colors = CardDefaults.cardColors(
                containerColor = containerColor,
                contentColor = contentColor
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
                pressedElevation = 0.dp
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = answer,
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontFamily = Inter,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}