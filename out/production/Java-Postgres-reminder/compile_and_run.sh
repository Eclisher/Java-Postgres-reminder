#!/bin/bash

export DB_URL=jdbc:postgresql://localhost:5432/library_management
export DB_USER=postgres
export DB_PASSWORD=harizo123

javac src/prog3/*.java
java -classpath . src.prog3.Main
