
And the challenge begins.

Each subdirectory here represents one piece of the test assignment. Each of these pieces is independent,
contains its own README.txt and can be solved separately. Don't worry, they are rather simple and shouldn't take
too much of your time.

Solve as much as you can - partial solution is better than no solution. In addition to making your code work, make it pretty
as well. You can even improve existing code. Just make sure you document what you have done to make scoring easier.

*** SET UP ***

All you need is Java installed and some IDE available to simplify coding. Gradle is used as the build system and Gradle Wrapper
is provided. This means that you don't even have to install Gradle and can run all commands with either 'gradlew.bat'
or 'gradlew' bash script. Try running 'gradlew.bat tasks' or './gradlew tasks' in current directory from your command line.

** IDE integration **
To simplify import of assignments to your IDE run 'gradlew.bat eclipse' or 'gradlew.bat idea' depending on the IDE in use.
This will generate IDE specific project files that allow it to be imported as existing project to the IDE.

** JRebel **
If you plan to run everything from your IDE, make sure to add jrebel agent parameters to Launch configuration.
When running with gradle from command line, you can add required parameters by using information from
here:       http://manuals.zeroturnaround.com/jrebel/standalone/launch-quick-start.html#java-1-5-and-newer
and here:   http://stackoverflow.com/a/25079415

*** WRAP UP ***

Once you have completed your development, run 'gradlew.bat createSubmissionZip' in root directory, where current README.txt
resides. Your results will be packed to assignment_submit.zip under build directory. This is the file you need to upload as well.