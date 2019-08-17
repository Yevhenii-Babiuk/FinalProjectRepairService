You need to have installed:

1. JDK 1.8 or later.
2. IntellijIDEA Community Edition.
3. MySQL.

To run this project:

Create database with the name "repair_service".

In the file resources/data.properties change the fields database.username and database.password due to your username and password of database.
You need to import database by following command: "mysql -U db_user db_name < dump.sql", where db_user is the database user, db_name is the database name, and dump.sql is the name of backup file in resources package.
Open project with IntellijIDEA, clack "Edit configuratioin" -> + -> Maven -> in the field "Command Line" write down "tomcat7:run" -> Apply.
Now you can start project by pressing "Run" or by writing command "tomcat7:run" in the terminal.