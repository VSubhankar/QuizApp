document.addEventListener('DOMContentLoaded', () => {
    let currentQuestionIndex = 0;
    let score = 0;
    let questions = [];

    const questionTitleElement = document.getElementById('question-title');
    const optionsElements = document.querySelectorAll('.option');
    const nextQuestionButton = document.getElementById('next-question');
    const resultElement = document.getElementById('result');

    // Fetch questions from the server
    fetch('http://localhost:8080/question/allQuestions')
        .then(response => response.json())
        .then(data => {
            questions = data;
            displayQuestion();
        });

    optionsElements.forEach(option => {
        option.addEventListener('click', () => {
            const selectedOption = option.innerText;
            const correctAnswer = questions[currentQuestionIndex].answer;
            if (selectedOption === correctAnswer) {
                score++;
            }
            nextQuestionButton.style.display = 'block';
        });
    });

    nextQuestionButton.addEventListener('click', () => {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            displayQuestion();
        } else {
            displayResult();
        }
        nextQuestionButton.style.display = 'none';
    });

    function displayQuestion() {
        const currentQuestion = questions[currentQuestionIndex];
        questionTitleElement.innerText = currentQuestion.title;
        document.getElementById('optionA').innerText = currentQuestion.optionA;
        document.getElementById('optionB').innerText = currentQuestion.optionB;
        document.getElementById('optionC').innerText = currentQuestion.optionC;
        document.getElementById('optionD').innerText = currentQuestion.optionD;
    }

    function displayResult() {
        resultElement.innerText = `You scored ${score} out of ${questions.length}`;
    }
});
