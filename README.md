# TaskFlow API 🗂️

Een REST API voor taakbeheer, gebouwd met Spring Boot en MySQL.

> Portfolio project – MBO 4 Software Developer

---

## 🚀 Wat doet dit project?

- Gebruikers aanmaken en inloggen (JWT authenticatie)
- Taken aanmaken, bewerken, verwijderen
- Taken filteren op status en categorie
- Deadlines instellen per taak

## 🛠️ Tech stack

| Component | Technologie |
|---|---|
| Backend framework | Spring Boot 3 |
| Database | MySQL 8 |
| Authenticatie | JWT (JSON Web Token) |
| Build tool | Maven |
| Testen | Postman |

---

## 📁 Project structuur

```
taskflow/
├── src/
│   └── main/
│       ├── java/com/taskflow/
│       │   ├── controller/     ← REST endpoints (wat de buitenwereld ziet)
│       │   ├── model/          ← Database tabellen als Java classes
│       │   ├── repository/     ← Database queries
│       │   ├── service/        ← Business logica
│       │   ├── security/       ← JWT authenticatie
│       │   └── dto/            ← Data Transfer Objects
│       └── resources/
│           └── application.properties  ← Configuratie
└── pom.xml                     ← Maven dependencies
```

---

## 🗺️ Roadmap

Zie [ROADMAP.md](ROADMAP.md) voor het volledige stappenplan.

### Fase overzicht

- [ ] **Fase 1** – Project setup & database ontwerp
- [ ] **Fase 2** – User model + registratie
- [ ] **Fase 3** – JWT authenticatie (login)
- [ ] **Fase 4** – Task CRUD (aanmaken, lezen, updaten, verwijderen)
- [ ] **Fase 5** – Categorieën & filters
- [ ] **Fase 6** – Deadlines & validatie
- [ ] **Fase 7** – Testen & opschonen
- [ ] **Fase 8** – README afmaken + deployen

---

## ⚙️ Installatie (lokaal draaien)

### Wat je nodig hebt
- Java 17+
- Maven
- MySQL 8
- IntelliJ IDEA (aanbevolen)

### Stappen

```bash
# 1. Repository klonen
git clone https://github.com/JOUWUSERNAME/taskflow.git
cd taskflow

# 2. Database aanmaken in MySQL
mysql -u root -p
CREATE DATABASE taskflow_db;
EXIT;

# 3. application.properties invullen (zie resources/application.properties)

# 4. Project starten
./mvnw spring-boot:run
```

De API draait nu op `http://localhost:8080`

---

## 📡 API Endpoints

### Authenticatie
| Method | URL | Beschrijving |
|--------|-----|-------------|
| POST | `/api/auth/register` | Nieuw account aanmaken |
| POST | `/api/auth/login` | Inloggen, krijg JWT token terug |

### Taken
| Method | URL | Beschrijving |
|--------|-----|-------------|
| GET | `/api/tasks` | Alle taken ophalen |
| POST | `/api/tasks` | Nieuwe taak aanmaken |
| PUT | `/api/tasks/{id}` | Taak bijwerken |
| DELETE | `/api/tasks/{id}` | Taak verwijderen |
| GET | `/api/tasks?status=open` | Filteren op status |
| GET | `/api/tasks?category=werk` | Filteren op categorie |

### Categorieën
| Method | URL | Beschrijving |
|--------|-----|-------------|
| GET | `/api/categories` | Alle categorieën |
| POST | `/api/categories` | Categorie aanmaken |

---

## 🧪 Testen met Postman

1. Download [Postman](https://www.postman.com/downloads/)
2. Importeer `taskflow.postman_collection.json` (staat in deze repo)
3. Registreer eerst een gebruiker via `/api/auth/register`
4. Log in via `/api/auth/login` – kopieer het JWT token
5. Zet het token in de Authorization header: `Bearer <jouw-token>`

---

## 📝 Wat ik geleerd heb

*(Vul dit aan terwijl je bouwt – werkgevers vinden dit leuk om te lezen)*

- Spring Boot project opzetten met Maven
- ...

---

## 👤 Auteur

Gemaakt door **[Jouw naam]** – MBO 4 Software Developer student

[LinkedIn](https://linkedin.com) · [GitHub](https://github.com)
