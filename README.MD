You need to have installed:

1. JDK 1.8 or later.
2. IntellijIDEA Community Edition.
3. MySQL.

To run this project:

Create database with the name "repair_service".

In the file resources/data.properties change the fields user and password due to your username and password of database.
You need to import database by following command: "mysqldump -U user -p password db_name < SQLscript.sql", where user is the database user, password is the database password, db_name is the database name, and SQLscript.sql is the name of backup file in resources package.
Open project with IntellijIDEA, clack "Edit configuratioin" -> + -> Maven -> in the field "Command Line" write down "tomcat7:run" -> Apply.
Now you can start project by pressing "Run" or by writing command "tomcat7:run" in the terminal.