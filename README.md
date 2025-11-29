# FinalProject-HealthManagementSystem

## Steps to connect to PostgreSQL DB
1. Make a new file called .env in the root directory of the project.
2. Add .env to .gitignore file in the root directory of the project if it's not there.
3. Copy and paste contents of .env.example into .env file.
4. Input the values of the url, user and password using the credentials distributed through Discord.
5. Run the following commands in terminal:
`export DB_URL=url`
`export DB_USER=postgres`
`export DB_PASS=yourpassword`
6. Run the spring app using `mvn spring-boot:run` command in the terminal.
7. You should be connected to the db now and any operations on entities should reflect in the db.

## ER Model Diagram
<img width="1610" height="1049" alt="image" src="https://github.com/user-attachments/assets/0e945958-99f3-4afe-9c29-0573d412baa5" />
