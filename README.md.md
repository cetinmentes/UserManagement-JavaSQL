# Benutzerverwaltungssystem (Java & MySQL)

Dieses Projekt ist eine einfache Benutzerverwaltungsanwendung, die mit **Java (Swing, JDBC)** und **MySQL** entwickelt wurde.  
Es bietet grundlegende Funktionen wie **Registrierung, Login und ein Dashboard** zur Anzeige der Benutzerliste.

---

## 📌 Funktionen
- Startseite (HomePage) mit Bild und Buttons (Login / Register / Exit)
- Registrierung neuer Benutzer (Name, Benutzername, E-Mail, Telefon, Passwort)
- Login mit Benutzername + Passwort
- Dashboard mit Benutzerliste aus der Datenbank
- SQL-Datenbankschema mit Rollen, Benutzern, Logs und Prüfungen
- Benutzerfreundliche Oberfläche mit Swing + Icons/Bildern

---

## ⚙️ Installation

### Voraussetzungen
- **Java JDK 17+** (getestet mit JDK 21)
- **NetBeans** oder eine andere IDE (z. B. IntelliJ, VS Code mit Java)
- **MySQL Server 8.0+**
- **MySQL Connector/J** (JDBC-Treiber)

### Datenbank einrichten
1. Öffne MySQL Workbench.
2. Führe das SQL-Skript aus:  
   ```sql
   database/user_management.sql
   ```
3. Dadurch werden die Tabellen **users, roles, logs, user_checks** erstellt und Beispieldaten eingefügt.

---

## 🚀 Projekt starten
1. Klone dieses Repository:
   ```bash
   git clone https://github.com/dein-benutzername/UserManagement.git
   ```
2. Öffne das Projekt in **NetBeans**.
3. Stelle sicher, dass sich der **MySQL Connector (JAR)** in den Projektbibliotheken befindet.
4. Starte die Anwendung über `HomePage.java`.

---

## 📂 Projektstruktur
```
UserManagement/
│── src/
│   ├── app/              # Java-Klassen (HomePage, Login2, Register2, Board, DatabaseConnection, etc.)
│   └── resources/        # Bilder (homepage.jpg, login.png, register.png, board.png)
│── database/
│   └── user_management.sql   # SQL-Skript für Datenbank & Tabellen
│── README.md
```

---

## 🖼️ Screenshots
- **HomePage**
  ![HomePage](src/resources/homepage.jpg)
- **Login**
  ![Login](src/resources/login.png)
- **Register**
  ![Register](src/resources/register.png)
- **Dashboard**
  ![Dashboard](src/resources/board.png)

---

## 👨‍💻 Autor
Projekt erstellt von **Cetin Mentes** als Lernprojekt für **Java + SQL**  

