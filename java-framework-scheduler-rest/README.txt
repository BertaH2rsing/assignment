*** SET UP ***
This assignment consists of two modules: "maze-provider" and "maze-mapper".

## 1. Before you can test, maze-provider should be started and left running in the background.

In maze-provider 'gradlew.bat bootRun' starts maze provider service.

This command does not finish on its own and the service is left running in the background.
For best experience don't even look into maze-provider module ;)

Open http://localhost:8080/maze in a browser and read about background from below.

## 2. in maze-mapper 'gradlew.bat bootRun' starts maze mapping application.

*** ASSIGNMENT ***

maze-provider module is just a helper and no code changes should be done in that project.
All assignments are in maze-mapper module.

1. Configure com.nortal.assignment.ScheduledTasks.getCoordinatesCombination to be executed periodically
2. Complete com.nortal.assignment.ScheduledTasks.mapCoordinatesToExcel

*** BACKGROUND ***

You wake up in a white room with a computer and a note:
"
You have arrived to the maze.

To survive you have two options:
1. Exit the door behind you and trust your blind navigation skills
2. Show exceptional mental skills and be worthy of the path out
"

On the computer two windows are opened. Browser at http://localhost:8080/maze and IDE with some maze-mapper code
You see some text on the screen. Refreshing the page changes the text.
After two consecutive fast refreshes something happens...
Before reading the error you notice some scrapings on the floor: "not too fast", "maze dark", "hungry", "1000 ms"






