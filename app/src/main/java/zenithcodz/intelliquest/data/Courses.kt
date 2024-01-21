package zenithcodz.intelliquest.data

import zenithcodz.intelliquest.R

data class Course(
    val title: String,
    val description: String,
    val image: Int,
)

val courses = listOf(
    Course(
        "Introduction to Programming",
        "Programming is the process of creating a set of instructions that tell a computer how to perform a task. Programming can be done using a variety of computer programming languages, such as JavaScript, Python, and C++. Take-Away Skills: In this course, you’ll learn the fundamentals of the Python programming language, along with programming best practices. You’ll learn to represent and store data using Python data types and variables, and use conditionals and loops to control the flow of your programs. You’ll harness the power of complex data structures like lists, sets, dictionaries, and tuples to store collections of related data. You’ll define and document your own custom functions, write scripts, and handle errors. Lastly, you’ll learn to find and use modules in the Python Standard Library and other third-party libraries.",
        R.drawable.introduction_to_programming
    ),
    Course(
        "Data Structures and Algorithms",
        "Data structures are amongst the most fundamental ingredients in the recipe for creating efficient algorithms and good software design. Knowledge of how to create and design good data structures is an essential skill required in becoming an exemplary programmer. This course will teach you how to master the fundamental ideas surrounding data structures. Take-Away Skills: In this course, you’ll learn about data structures, like graphs, that are fundamental for working with structured real-world data. By the end of this course, you’ll have learned a wide variety of data structures and algorithms!",
        R.drawable.data_structures_and_algorithms
    ),
    Course(
        "Object Oriented Programming",
        "Object-oriented programming (OOP) is a popular programming paradigm or style of programming. It’s been around since ‘70s, but unlike tools and frameworks that come and go, OOP is still very relevant today. That’s because it’s not a programming language or a tool. It’s a style of programming. Take-Away Skills: In this course, you’ll learn the Object-Oriented Programming (OOP) in Java. You’ll build 7 Java projects—like a basic calculator—to help you practice along the way.",
        R.drawable.oopsicon
    ),
    Course(
        "Web Development",
        "Web development is the practice of converting data into a graphical interface, through the use of HTML, CSS, and JavaScript, so that users can view and interact with that data. Take-Away Skills: In this course, you’ll learn how to build responsive, websites with HTML, CSS, and JavaScript. By the end of this course, you’ll have all the skills required to build your own websites or even start a career with one of the thousands of companies that have a website.",
        R.drawable.web_development
    ),
    Course(
        "Database Management",
        "Databases are incredibly prevalent -- they underlie technology used by most people every day if not every hour. Databases reside behind a huge fraction of websites; they’re a crucial component of telecommunications systems, banking systems, video games, and just about any other software system or electronic device that maintains some amount of persistent information. In addition to persistence, database systems provide a number of other properties that make them exceptionally useful and convenient: reliability, efficiency, scalability, concurrency control, data abstractions, and high-level query languages. Databases are so ubiquitous and important that computer science graduates frequently cite their database class as the one most useful to them in their industry or graduate-school careers. Take-Away Skills: In this course, you’ll learn how to communicate with relational databases through SQL. You’ll learn—and practice with 4 projects—how to manipulate data and build queries that communicate with more than one table.",
        R.drawable.database_management
    ),
    Course(
        "Version Control and Collaboration",
        "Version control is a system that records changes to a file or set of files over time so that you can recall specific versions later. For the examples in this book, you will use software source code as the files being version controlled, though in reality you can do this with nearly any type of file on a computer. Take-Away Skills: In this course, you’ll learn how to use the version control system Git. You’ll learn basic Git commands, how to navigate changes with commits and commit messages, how to create branches and merge them, and how to work with remote repositories and collaborate with other developers.",
        R.drawable.version_control
    )
)
