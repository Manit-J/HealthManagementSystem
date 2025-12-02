COMP 3005 – Fall 2025
Final Project: Health & Fitness Club Management System

Group Members:
- Shaymaa Abu-Dakka
- Krishna Adhikari
- manit jawa

Demo Video Link:
https://www.youtube.com/watch?v=QCPadnR3y6w

1. Project Overview
This project implements a full Health and Fitness Club Management System based on the requirements provided. The system supports Members, Trainers, and Administrative Staff. It is built using Java Spring Boot with ORM (Hibernate/JPA) and a PostgreSQL relational database.

2. ER Diagram and Relational Mapping
Our ERD (submitted as ERD.pdf) includes 10 entities and 10 relationships.
Key entities: Member, Trainer, Availability, FitnessGoal, HealthMetric, GroupClass, PTSession, Room, Equipment, Billing.

Relationships: Members–HealthMetrics (1-many), Members–Goals (1-many), Trainers–Availability (1-many), Rooms–Classes/Sessions (1-many), Members–GroupClasses (many-to-many), Billing–LineItems (1-many).

3. ORM Integration
We use Hibernate ORM. Tables are generated automatically. Entity classes define:
- Primary keys
- Foreign keys
- Relationship mappings (OneToMany, ManyToOne, ManyToMany)
- Automatic schema creation

4. How to Run the Application
Requirements:
- Java 17+
- Maven
- PostgreSQL

Steps:
1. Create a DB named: health_management_system
2. Update application.properties with your DB login.
3. Run: mvn spring-boot:run


5. Implemented Features

Member:
- Register new member
- Update profile/goals
- Add health metrics (timestamped)
- Dashboard view
- Register for group class
- Book PT session

Trainer:
- Set availability (overlap validation)
- Member lookup (case-insensitive)

Administrator:
- Room booking (conflict prevention)
- Equipment maintenance tracking
- Class management
- Billing + payments

6. Code Structure
/models – ORM entities  
/controllers – REST controllers  
/services – Business logic  
/repositories – JPA repositories  
/docs/ERD.pdf – ER model and mapping

