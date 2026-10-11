# Bachelor Point Management System

A Java Swing desktop application for managing a member-based management system. This project appears to be a student management / admin dashboard application with features for login, member records, finance, reports, and a MySQL-backed database.

## Project Overview

This repository contains a Java desktop application built using Swing and connected to a MySQL database named `bachelorPoint`. The UI includes several forms and screens such as:

- Login / Sign In
- Sign Up / Create Account
- Dashboard
- Admin Dashboard
- Member view / print options
- Finance management
- Reports
- About screens

## Tech Stack

- Java
- Swing / Java GUI
- MySQL
- NetBeans project structure
- Apache Ant (`build.xml`)

## Repository Structure

```text
Becholor_Point/
├── Management/
│   ├── build.xml
│   ├── manifest.mf
│   ├── nbproject/
│   └── src/
│       └── management/
│           ├── About.java
│           ├── Dashboard.java
│           ├── M_Finance.java
│           ├── Management.java
│           ├── Report.java
│           ├── createAc.java
│           ├── databaseConnection.java
│           ├── frame.java
│           ├── homemate.java
│           ├── signIN.java
│           └── ...
├── bachelorpoint.sql
├── Work.txt
└── README.md
```

## Features

- User authentication (sign in / sign up)
- Dashboard interface for management tasks
- Member-related management screens
- Finance entries and member finance design
- Reporting and printable outputs
- Database connectivity using JDBC

## Database Setup

This project uses a MySQL database with the following connection settings in `databaseConnection.java`:

```java
jdbc:mysql://localhost/bachelorPoint
root
""
```

Before running the project:

1. Start MySQL on your local machine.
2. Create/import the database using the provided SQL dump file:
   - `bachelorpoint.sql`
3. Make sure the database name and credentials match your local setup.

If your MySQL username/password differs, update the connection in:

`Management/src/management/databaseConnection.java`

## How to Run

### Option 1: NetBeans

1. Open the project in NetBeans.
2. Ensure the Java project is recognized.
3. Build and run the project.
4. The application entry point is `Management.java`.

### Option 2: Command Line

From the project directory:

```bash
ant
```

Then run the compiled Java application through the project build output.

## Notes

- This is a desktop application created for a student project.
- The project currently contains hardcoded database settings.
- Some class and file names are informal or legacy and may require cleanup.
- The UI includes a number of `.form` and image assets used by Swing.

## License

This project does not appear to include a license file. Please check with the repository owner before reusing it for commercial or public distribution.

## Author

This repository is maintained by Arittra101.

## Contribution

If you want to improve the project:

- clean up the legacy class names,
- add proper documentation,
- refactor database configuration into environment variables,
- add a proper project license,
- and improve the UI and code structure.

---

If you want, I can also help you:

- improve this README further,
- add a proper project screenshot section,
- or clean up the Java project structure and setup instructions for better usability.
