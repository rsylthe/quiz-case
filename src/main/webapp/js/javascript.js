/**
 * Created by Roy on 20.09.2017.
 */

$(document).ready(function() {
    // $.get('rest/quiz', function(data){
    //     $('#myid').html(data);
    // });

    $('#buttonSaveQuiz').click(function () {
        const fTitle = $("#inputQuizTitle").val();
        const fStartTime = new Date($("#inputQuizStart").val());
        const spaghettiQuestions = $(".questionArea");

        var questions = [];

        $.each(spaghettiQuestions, function (questionIndex, element) {
            var answers = [];
            $.each($(".inputAnswer" + (questionIndex + 1)), function (answerIndex, answer) {
                answers.push($(answer).val());
            });

            const question = {
                timeLimit: $($('.inputQuestionTime')[questionIndex]).val(),
                questionText: $($('.inputQuestionText')[questionIndex]).val(),
                answerChoices: answers,
                correctAnswer: parseInt($($('.inputCorrectAnswer')[questionIndex]).val())
            };
            questions.push(question);
        });

        $.ajax({
            url: 'rest/quiz',
            type: 'POST',
            data: JSON.stringify({
                name: fTitle,
                startTime: fStartTime,
                questions: questions
            }),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function () {
                $.getScript("js/quizTable.js",function () {
                    updateQuizzes();
                })
            }
        })
    });

    function initializeAccordion() {
        $('.ui.accordion')
            .accordion()
            .accordion({onChange: function(){$('.ui.modal').modal('refresh')}})
        ;
    }

    var questionNumber = 0;
    $('#addQuestionButton').click(function () {
        questionNumber++;
        if (questionNumber <= 1) {
            $('#addQuestionsBox').append(
                outerAppend(questionNumber)
            )
        } else {
            $("#questionAccordion").append(
                innerAppend(questionNumber)
            )
        }
        initializeAccordion()
    })
        .click(function(){$('.ui.modal').modal('refresh')});

    $('.ui.modal')
        .modal('setting', 'transition', 'fade up')
        .modal('attach events', '#buttonCreateQuiz', 'show')
    ;

    $('form').submit(function (e) {
        e.preventDefault();
    })


    function outerAppend(questionNumber) {
        return '<div id="questionAccordion" class="ui styled fluid accordion">' + innerAppend(questionNumber) + '</div>'
    }

    function innerAppend(questionNumber) {
        return '   <div class="title">' +
            '       <i class="dropdown icon"></i>' +
            '       Question ' + questionNumber +
            '   </div>' +
            '   <div class="content questionArea">' +
            '       <form class="ui form">' +
            '           <div class="field">' +
            '               <label>Question Text</label>' +
            '               <textarea class="inputQuestionText" rows="2"></textarea>' +
            '           </div>' +
            '           <div class="two fields">' +
            '               <div class="field">' +
            '                   <input class="inputAnswer' + questionNumber + '" type="text" placeholder="Answer 1">' +
            '               </div>' +
            '               <div class="field">' +
            '                   <input class="inputAnswer' + questionNumber + '" type="text" placeholder="Answer 2">' +
            '               </div>' +
            '           </div>' +
            '           <div class="two fields">' +
            '               <div class="field">' +
            '                   <input class="inputAnswer' + questionNumber + '" type="text" placeholder="Answer 3">' +
            '               </div>' +
            '               <div class="field">' +
            '                   <input class="inputAnswer' + questionNumber + '" type="text" placeholder="Answer 4">' +
            '               </div>' +
            '           </div>' +
            '           <div class="two fields">' +
            '               <div class="field">' +
            '                   <input class="inputCorrectAnswer" type="number" min="1" max="4" placeholder="Correct Answer">' +
            '               </div>' +
            '               <div class="field">' +
            '                   <input class="inputQuestionTime" type="number" min="5" max="60" placeholder="Time Limit">' +
            '               </div>' +
            '           </div>' +
            '       </form>' +
            '   </div>'
    }
});