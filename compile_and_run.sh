#!/bin/bash

export DB_URL=jdbc:postgresql://localhost:5432/library_management
export DB_USER=postgres
export DB_PASSWORD=harizo123
export CLASSPATH=".:postgresql-42.6.0.jar"

javac src/prog3/*.java
java -classpath "$CLASSPATH" -DDB_URL="$DB_URL" -DDB_USER="$DB_USER" -DDB_PASSWORD="$DB_PASSWORD" src.prog3.Main
