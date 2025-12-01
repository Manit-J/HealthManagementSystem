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
<img width="734" height="438" alt="image" src="https://github.com/user-attachments/assets/084a1b61-3376-4ef9-b82a-7094a591a7ea" />

## ER Mapping to Schema
<img width="2222" height="1098" alt="image" src="https://github.com/user-attachments/assets/d4c00eb0-363b-4ca6-a50c-b8c6ff5911e2" />
