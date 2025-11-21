
## 1. Entities 

### Member
Member(memberID, name, dateOfBirth, gender, email,
       height, weight, heartRate, bodyFatPercentage)

### FitnessGoal
FitnessGoal(goalID, targetValue, status, description, deadline)

### Trainer
Trainer(trainerID, name, email, gender, availability)

### AdminStaff
AdminStaff(adminID, name, email, permissions)

### GroupClasses
GroupClasses(classID, size, time)

### PT (Personal Training Session)
PT(sessionID, classes)

### Dashboard
Dashboard(metrics, attendance, schedule)

## 2. Relationships

- Member — has → FitnessGoal (1-to-many)  
- Trainer — views (limited access) → Member 
- Trainer — leads → GroupClasses (many-to-many)  
- Member — attends → GroupClasses (many-to-many)  
- AdminStaff — creates → GroupClasses (1-to-many)  
- Trainer — assigned to → PT sessions (many-to-many)  
- Member — schedules → PT sessions (many-to-many)  
- Trainer — has → Dashboard (1-to-1)  


## 3. Relational Schema 

### Member
Member(memberID, name, dateOfBirth, gender, email,
       height, weight, heartRate, bodyFatPercentage)  
PK: memberID

### FitnessGoal
FitnessGoal(goalID, memberID, targetValue, status, description, deadline)  
PK: goalID  
FK: memberID → Member(memberID)

### Trainer
Trainer(trainerID, name, email, gender, availability)  
PK: trainerID

### PT (Personal Training Session)
PT(sessionID, trainerID, memberID, classes)  
PK: sessionID  
FK: trainerID → Trainer(trainerID)  
FK: memberID → Member(memberID)

### Dashboard
Dashboard(trainerID, metrics, attendance, schedule)  
PK: trainerID  
FK: trainerID → Trainer(trainerID)

### AdminStaff
AdminStaff(adminID, name, email, permissions)  
PK: adminID

### GroupClasses
GroupClasses(classID, size, time)  
PK: classID


## 4. Relationship Tables 

### GroupClassMembers
GroupClassMembers(classID, memberID)  
PK: (classID, memberID)  
FK: classID → GroupClasses(classID)  
FK: memberID → Member(memberID)

### GroupClassTrainers
GroupClassTrainers(classID, trainerID)  
PK: (classID, trainerID)  
FK: classID → GroupClasses(classID)  
FK: trainerID → Trainer(trainerID)

### AdminCreatesClasses
AdminCreatesClasses(adminID, classID)  
PK: (adminID, classID)  
FK: adminID → AdminStaff(adminID)  
FK: classID → GroupClasses(classID)

### TrainerLeadsClasses
TrainerLeadsClasses(trainerID, classID)  
PK: (trainerID, classID)  
FK: trainerID → Trainer(trainerID)  
FK: classID → GroupClasses(classID)


