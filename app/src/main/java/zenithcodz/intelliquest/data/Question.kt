package zenithcodz.intelliquest.data

data class Question(
    val id: Int = -1,
    val question: String,
    val options: List<String>,
    val answer: Int
)
