*** SET UP ***

You can run the application from an IDE or from the command line
## On OS X and Linux environments: './gradlew bootRun'
## On Windows: 'gradlew.bat bootRun'

Open http://localhost:8080/

*** ASSIGNMENT ***
For this assignment modification of Java code is not required
Java side provides a REST endpoint to obtain data about word occurrences in the book Alice's Adventures in Wonderland.

1. Improve index.html to draw a bar chart with chart.js for the data obtained from the REST endpoint documented below.
   (Use words 'Alice' and 'Rabbit')

Methods:
GET /rest/book

Parameters:

Parameter   Type        Description
word        string      List of words for what occurrence data is provided. Mandatory.

2. Create form where user can enter custom words to visualize. Input of at least two words should be possible.

*** BACKGROUND ***

On one afternoon while drinking tea, Alice and the Rabbit started wondering who got more fame from their notorious book
Alice's Adventures in Wonderland. "No Alice, it must have been me who got more mentions", insisted the Rabbit. Although
Alice tried, she failed to convince the Rabbit that she, as the main character, is probably mentioned a lot more.

Since the Rabbit didn't know how to count and Alice was too lazy for that, she decided to visualize the occurrences of
the mentions. Unfortunately Alice is a Java gal and knows too little about front-end development to make it happen.

So she showed you the way down the Rabbit-Hole with the request to finish the work she started. Be quick, the Rabbit tends
to be a bit hasty.
