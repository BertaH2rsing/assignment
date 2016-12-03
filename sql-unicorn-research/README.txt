*** SET UP ***

This assignment includes a database.
## 'gradlew.bat startDb' starts the database. This command does not exit, leave it running
## 'gradlew.bat drop-schema create-schema-and-test-data' drops the schema and recreates base state.
## 'gradlew.bat run' Executes the main class in ResearchRunner.java

And if something seems to be messed up, try 'gradlew.bat clean'

*** ASSIGNMENT ***

1. Complete com.nortal.assignment.database.DbRefactorEngine.createIntermediateTable
2. Complete com.nortal.assignment.database.DbRefactorEngine.migrateOldData
3. Complete com.nortal.assignment.database.DbReportEngine.getUnicornGrasslands

*** BACKGROUND ***
This is the database of International Unicorn Research Agency Automated Research Module version 0.1b.

Initially it was thought that unicorns are territorial creatures and they live lonely on the meadow of their choosing.
Now researchers have found that two or more unicorns may peacefully occupy the same grassland. Furthermore, it is found
that reaching high age gives them ability to be in multiple places at once, thus allowing the subjects to occupy multiple
grasslands at the same time.

Complete the code to refactor the database so it could reflect this new finding.

