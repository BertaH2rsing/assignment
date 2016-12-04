// So how was that REST request made in JavaScript?
// And a graph?
// "Oh my" said Alice
window.onload = function () {
    var defaultWords = ['Alice', 'Rabbit'];
    findWordOccurrence(defaultWords);
};

var myChart = null;

function findWordOccurrence(words) {
    var enteredWords = words.join();
    $.get("/rest/book?words=" + enteredWords, function (wordsWithOccurrence) {
        drawChart(wordsWithOccurrence);
    });
}
$('#visualize').click(function () {
    var userInput = $('#exampleTextarea').val().trim().replace(" ", ""), arrayOfUserInput = [];
    arrayOfUserInput = userInput.split(",");
    findWordOccurrence(arrayOfUserInput);
});


function drawChart(arrayOfUserInput) {
    var labels = [], data = [];
    arrayOfUserInput.forEach(function (elem) {
        labels.push(elem.input);
        data.push(elem.occurrences);
    });

    if (myChart) {
        myChart.destroy();
    }

    var ctx = document.getElementById('myChart').getContext('2d');
        myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    label: labels[0],
                    data: data,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                }]
            }
        });
}







