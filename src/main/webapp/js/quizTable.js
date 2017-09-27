/**
 * Created by Roy on 27.09.2017.
 */

$(document).ready(function () {
    var quizzes = [];
    const tableBody = $("#tableBody");
    updateQuizzes();

    function updateQuizzes() {
        quizzes = [];

        $.ajax({
            url: 'rest/quiz',
            type: 'GET',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function (data) {
                $.each(data, function (index, element) {
                    quizzes.push(element)
                });
                updateQuizTable()
            }
        });
    }

    function updateQuizTable() {
        tableBody.html("");
        for (var i = 0; i < quizzes.length; i++) {
            tableBody.append(
                '<tr id="quiz' + quizzes[i].id + '">' +
                '   <td><h4>' + quizzes[i].name + '</h4></td>' +
                '   <td><h4>' + new Date(quizzes[i].startTime).toLocaleString() + '</h4></td>' +
                '   <td class="center aligned collapsing">' +
                '       <button class="ui blue button" value="' + quizzes[i].id + '"><i class="users icon"></i>Join</button>' +
                '       <button class="ui blue button" value="' + quizzes[i].id + '"><i class="bar chart icon"></i>Scoreboard</button>' +
                '   </td>' +
                '</tr>'
            )
        }
    }

    setInterval(function () {
        updateQuizzes();
    }, 10000)
});