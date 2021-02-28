name := "Sorting"
version := "1.0.0"
scalaVersion := "2.12.12"
sbtPlugin := true

// Create a variable for calculator module
lazy val assignment = (project in file("assignment"))

// Aggregate calculator module with root project
lazy val root = (project in file(".")).aggregate(assignment)

