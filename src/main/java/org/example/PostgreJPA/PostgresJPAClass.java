package org.example.PostgreJPA;

/*
Controller --> Service --> Repository (JPA) --> Hibernate (ORM) --> JDBC --> PostgreSQL

JDBC (Java Database Connectivity) - is the lowest level way Java talks to database
- It is a Java API
- Used to send SQL queries to a database
- Database agnostic (works with MySQL, postgreSQL, Oracle)
- It connects to the database (like PostgreSQL) , Execute sql, reads rows from table

Problems with JDBC
- Too much boilerplate
- Manual SQL writing
- Manual mapping (row → object)
- Error-prone
- Hard to maintain in big apps

Hibernate - is an ORM (Object relational mapping) framework , sits on top of JDBC and does the work instead of us
- You work with - Java objects, Classes, Methods
- Hibernate handles - SQL generation, Table creation, Object ↔ row mapping
- Hibernate key idea - Tables ↔ Java classes, Rows ↔ Objects
- Opens JDBC connection
- Generates SQL
- Executes SQL
- Closes connection

JDBC = kaam karne ka tool
Hibernate = kaam karne wala banda
 */

public class PostgresJPAClass {
}
