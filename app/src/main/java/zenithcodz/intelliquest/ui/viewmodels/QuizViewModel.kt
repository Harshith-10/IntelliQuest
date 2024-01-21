package zenithcodz.intelliquest.ui.viewmodels

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import zenithcodz.intelliquest.R
import zenithcodz.intelliquest.data.Question
import java.lang.reflect.Type

data class QuizState(
    val questionList: List<Question> = emptyList(),
    val numberOfQuestions: Int = 0,
    val numberOfAttemptedQuestions: Int = 0,
    val numberOfCorrectAnswers: Int = 0,
    val currentQuestion: Question = Question(
        question = "Implement a linked list in Python.",
        options = listOf(
            "class Node: def __init__(self, data): self.data = data self.next = None",
            "class Element: def __init__(self, data): self.data = data self.next = None",
            "class ListItem: def __init__(self, data): self.data = data self.next = None",
            "class DataNode: def __init__(self, data): self.data = data self.next = None"
        ),
        answer = -1
    ),
    val selectedOption: Int = -1,
    val isCorrect: Boolean = false,
    val streak: Int = 0,
    val isStreak: Boolean = false,

    )

class QuizViewModel : ViewModel() {
    private var streak = 0
    private var numberOfQuestions = 0
    private var numberOfAttemptedQuestions = 0
    private var numberOfCorrectAnswers = 0
    private var requestedChange = false

    private val _uiState = MutableStateFlow(QuizState())
    val uiState: StateFlow<QuizState> = _uiState.asStateFlow()

    fun createQuiz(context: Context) {
        val rawText = readQuestionsJson(context, R.raw.question_set)
        val questionList = readQuestions(rawText)
        val shuffle = questionList.shuffled().take(
            minOf(10, questionList.size)
        )
        numberOfQuestions = shuffle.size
        _uiState.update {
            it.copy(
                questionList = questionList,
                currentQuestion = shuffle.first(),
                streak = 0,
                isStreak = false
            )
        }
    }

    private fun moveToNext() {
        _uiState.update {
            val questionList = it.questionList
            val currentQuestion = it.currentQuestion
            val nextQuestion = questionList.first { question ->
                question != currentQuestion
            }
            it.copy(
                currentQuestion = nextQuestion,
                isStreak = isStreak(),
                selectedOption = -1,
                isCorrect = false
            )
        }
    }

    fun processAnswer(answer: Int) {
        if(!requestedChange){
            requestedChange = true
            numberOfAttemptedQuestions++
            if (checkAnswer(answer)) {
                numberOfCorrectAnswers++
                incrementStreak()
            } else {
                resetStreak()
            }
            _uiState.update {
                it.copy(
                    numberOfQuestions = numberOfQuestions,
                    numberOfAttemptedQuestions = numberOfAttemptedQuestions,
                    numberOfCorrectAnswers = numberOfCorrectAnswers
                )
            }
            showResult(answer)
            Handler(Looper.getMainLooper()).postDelayed({
                moveToNext()
                requestedChange = false
            }, 3000)
        }
    }

    private fun showResult(answer: Int) {
        val currentQuestion = getCurrentQuestion()
        val isCorrect = currentQuestion.answer == answer
        _uiState.update {
            it.copy(
                currentQuestion = currentQuestion.copy(),
                selectedOption = answer,
                isCorrect = isCorrect,
                isStreak = isStreak(),
                streak = streak
            )
        }
    }

    private fun getCurrentQuestion(): Question {
        return uiState.value.currentQuestion
    }

    private fun checkAnswer(answer: Int): Boolean {
        val currentQuestion = getCurrentQuestion()
        return currentQuestion.answer == answer
    }

    fun isStreak(): Boolean = streak >= 3

    private fun resetStreak() {
        streak = 0
    }

    private fun incrementStreak() {
        streak++
    }

    private fun readQuestions(jsonString: String): List<Question> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Question>>() {}.type
        return gson.fromJson(jsonString, type)
    }

    private fun readQuestionsJson(context: Context, resourceId: Int): String {
        val inputStream = context.resources.openRawResource(resourceId)
        val byteArray = inputStream.readBytes()
        return String(byteArray, Charsets.UTF_8)
    }
}