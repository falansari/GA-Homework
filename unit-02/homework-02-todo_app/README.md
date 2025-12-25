# Java Spring Boot ToDo Application
<p>Unit 2 homework assignment: create a spring boot application for a todo list app</p>

## Project Github
https://github.com/falansari/GA-Homework/tree/eeddfd5c48bd4945d7c21bfcbfbb3b1553cc991e/unit-02/homework-02-todo_app

## Design Decisions
<p>All design decisions I make and the reason why.</p>

### Models
- Getters are set for all columns, however setters are not added for id, createdAt and updatedAt columns, as these should be auto-set by the app only and should not be manually changeable.

### Controllers
- Using PATCH requests instead of PUT requests for update functions; this is to allow partially updating a record instead of having to pass in all fields every time.

## What Went Right

## What Went Wrong: Challenges Faced

## Most Enjoyable Task(s)