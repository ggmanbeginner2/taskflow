# TaskFlow – Roadmap & Stappenplan

Werk elke fase af voordat je doorgaat. Commit na elke stap!

---

## Fase 1 – Project setup & database ontwerp
*Doel: werkend Spring Boot project + database schema op papier*

### Stap 1.1 – Spring Boot project aanmaken
- [ ] Ga naar [start.spring.io](https://start.spring.io)
- [ ] Kies: Maven · Java · Spring Boot 3.x
- [ ] Voeg toe: Spring Web, Spring Data JPA, MySQL Driver, Spring Security, Lombok
- [ ] Download en open in IntelliJ
- [ ] Controleer: project start zonder fouten (`./mvnw spring-boot:run`)

**Git commit:** `git commit -m "feat: initial Spring Boot project setup"`

### Stap 1.2 – Database verbinding
- [ ] Maak database aan in MySQL: `CREATE DATABASE taskflow_db;`
- [ ] Vul `application.properties` in (zie voorbeeld hieronder)
- [ ] Controleer: Spring Boot verbindt met de database

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskflow_db
spring.datasource.username=root
spring.datasource.password=JOUWWACHTWOORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**Git commit:** `git commit -m "feat: database connection configured"`

### Stap 1.3 – Database schema tekenen
- [ ] Teken op papier (of Lucidchart) de tabellen:
  - `users` (id, username, email, password, created_at)
  - `tasks` (id, title, description, status, deadline, user_id, category_id)
  - `categories` (id, name, user_id)
- [ ] Denk na: welke relaties zijn er? (user heeft veel tasks, task heeft één category)

**Git commit:** `git commit -m "docs: add database schema diagram"`

---

## Fase 2 – User model + registratie
*Doel: gebruiker opslaan in de database*

### Stap 2.1 – User model maken
- [ ] Maak `model/User.java` met annotaties: `@Entity`, `@Table`, `@Id`
- [ ] Velden: id, username, email, password, createdAt
- [ ] Controleer: Spring maakt automatisch de tabel aan in MySQL

**Git commit:** `git commit -m "feat: add User entity"`

### Stap 2.2 – UserRepository
- [ ] Maak `repository/UserRepository.java`
- [ ] Extends `JpaRepository<User, Long>`
- [ ] Voeg toe: `findByEmail(String email)`

**Git commit:** `git commit -m "feat: add UserRepository"`

### Stap 2.3 – UserService + registratie
- [ ] Maak `service/UserService.java`
- [ ] Methode: `registerUser(RegisterRequest request)`
- [ ] Wachtwoord versleutelen met `BCryptPasswordEncoder`

**Git commit:** `git commit -m "feat: add user registration logic"`

### Stap 2.4 – AuthController
- [ ] Maak `controller/AuthController.java`
- [ ] Endpoint: `POST /api/auth/register`
- [ ] Test in Postman: stuur JSON, gebruiker verschijnt in database ✅

**Git commit:** `git commit -m "feat: add register endpoint"`

---

## Fase 3 – JWT authenticatie (login)
*Doel: gebruiker logt in en krijgt een token terug*

### Stap 3.1 – JWT dependency toevoegen
- [ ] Voeg toe aan `pom.xml`:
```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>
```

**Git commit:** `git commit -m "feat: add JWT dependency"`

### Stap 3.2 – JwtUtil class
- [ ] Maak `security/JwtUtil.java`
- [ ] Methodes: `generateToken(String email)`, `validateToken(String token)`, `extractEmail(String token)`

**Git commit:** `git commit -m "feat: add JWT utility class"`

### Stap 3.3 – Security configuratie
- [ ] Maak `security/SecurityConfig.java`
- [ ] Zet `/api/auth/**` open (geen token nodig)
- [ ] Alle andere endpoints: token verplicht

**Git commit:** `git commit -m "feat: configure Spring Security"`

### Stap 3.4 – Login endpoint
- [ ] Voeg `POST /api/auth/login` toe aan `AuthController`
- [ ] Geeft JWT token terug als email + wachtwoord kloppen
- [ ] Test in Postman: login → kopieer token → gebruik in volgende requests ✅

**Git commit:** `git commit -m "feat: add login endpoint with JWT"`

---

## Fase 4 – Task CRUD
*Doel: taken aanmaken, ophalen, bijwerken en verwijderen*

### Stap 4.1 – Task model
- [ ] Maak `model/Task.java`
- [ ] Velden: id, title, description, status (OPEN/DONE), deadline, user, category
- [ ] Relatie: `@ManyToOne` naar User

**Git commit:** `git commit -m "feat: add Task entity"`

### Stap 4.2 – TaskRepository
- [ ] Maak `repository/TaskRepository.java`
- [ ] Voeg toe: `findByUser(User user)`

**Git commit:** `git commit -m "feat: add TaskRepository"`

### Stap 4.3 – TaskService
- [ ] Maak `service/TaskService.java`
- [ ] Methodes: `createTask`, `getAllTasks`, `updateTask`, `deleteTask`
- [ ] Altijd controleren: taak hoort bij ingelogde gebruiker!

**Git commit:** `git commit -m "feat: add TaskService"`

### Stap 4.4 – TaskController
- [ ] Maak `controller/TaskController.java`
- [ ] Alle 5 endpoints implementeren (zie README)
- [ ] Test alles in Postman met JWT token ✅

**Git commit:** `git commit -m "feat: add Task CRUD endpoints"`

---

## Fase 5 – Categorieën & filters
*Doel: taken organiseren en filteren*

### Stap 5.1 – Category model + repository
- [ ] Maak `model/Category.java`
- [ ] Maak `repository/CategoryRepository.java`

**Git commit:** `git commit -m "feat: add Category entity and repository"`

### Stap 5.2 – Category endpoints
- [ ] `GET /api/categories` en `POST /api/categories`

**Git commit:** `git commit -m "feat: add category endpoints"`

### Stap 5.3 – Filters toevoegen
- [ ] `GET /api/tasks?status=OPEN` werkt
- [ ] `GET /api/tasks?category=werk` werkt

**Git commit:** `git commit -m "feat: add task filtering by status and category"`

---

## Fase 6 – Validatie & error handling
*Doel: nette foutmeldingen als iets fout gaat*

- [ ] Voeg `@Valid` toe aan request bodies
- [ ] Maak `GlobalExceptionHandler.java` voor nette JSON foutmeldingen
- [ ] Valideer: titel mag niet leeg zijn, deadline moet in de toekomst liggen

**Git commit:** `git commit -m "feat: add input validation and error handling"`

---

## Fase 7 – Testen & opschonen
*Doel: alles werkt, code is netjes*

- [ ] Test alle endpoints opnieuw in Postman
- [ ] Verwijder `System.out.println` statements
- [ ] Controleer: geen wachtwoorden of API keys in de code!
- [ ] Exporteer Postman collectie → sla op als `taskflow.postman_collection.json`

**Git commit:** `git commit -m "test: final endpoint testing complete"`

---

## Fase 8 – Afmaken & publiceren
*Doel: klaar voor werkgevers*

- [ ] README afmaken (vul "wat ik geleerd heb" in)
- [ ] Controleer GitHub: alles staat er op, `.gitignore` klopt
- [ ] Optioneel: deployen op [Railway.app](https://railway.app) (gratis hosting)
- [ ] Zet link in je LinkedIn bio

**Git commit:** `git commit -m "docs: finalize README and project documentation"`

---

## 🎉 Klaar!

Je hebt nu een portfolio project dat laat zien:
- Je kunt een Spring Boot API bouwen
- Je begrijpt authenticatie (JWT)
- Je werkt met een database (MySQL + JPA)
- Je gebruikt Git professioneel
- Je documenteert je werk

**Geschatte tijd per fase:** 3–5 uur
**Totale tijd:** ~30–40 uur verspreid over 6–8 weken
