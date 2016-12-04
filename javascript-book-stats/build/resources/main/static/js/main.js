// So how was that REST request made in JavaScript?
// And a graph?
// "Oh my" said Alice
window.onload = function () {
    var defaultWords = ['Alice', 'Rabbit'];
  getWordOccurances(defaultWords);
};
function getWordOccurances(words) {
    console.log(words);
    var dataToSend = words.join();
    $.get("/rest/book?words=" + dataToSend, function(data){
        var list = data;
        drawChart(list);
    });
}
$('#visualize').click(function() {
    var list = $('#exampleTextarea').val().trim().replace(" ", "");
    var ad = [];
    ad = list.split(",");
    getWordOccurances(ad);
});

function drawChart(list) {
    console.log(list);
    var labels = [];
    var data = [];
    var asd = list.forEach(function (elem) {
        labels.push(elem.input);
        data.push(elem.occurrences);
    });
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
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







