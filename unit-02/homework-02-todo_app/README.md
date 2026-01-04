# Java Spring Boot ToDo Application
<p>Unit 2 homework assignment: create a spring boot application for a todo list app</p>

## Project Github
https://github.com/falansari/GA-Homework/tree/eeddfd5c48bd4945d7c21bfcbfbb3b1553cc991e/unit-02/homework-02-todo_app

## Design Decisions
<p>All design decisions I make and the reason why.</p>

### Models
- Getters are set for all columns, however setters are not added for id, createdAt and updatedAt columns, as these should be auto-set by the app only and should not be manually changeable.
- A category has a One to Many relationship with items.

### Controllers
- Using PATCH requests instead of PUT requests for update functions; this is to allow partially updating a record instead of having to pass in all fields every time.
- Added an extra getItemsByCategory (all items list in a category) along with getItems (all items in database).
- Added get all users feature for testing (route: {{BaseUrl}}/auth/users).

### Services
- Items: Creating duplicate items is allowed as a person can have the same note for different purposes like putting a placeholder note in each category or such.
- All services
- Added ability for users to find and update their own profile info, but not delete or create new.

## What Went Right
Smooth sailing. Nothing much of note.

## What Went Wrong: Challenges Faced
Nothing. It's fairly similar to what we did in class just a slightly different context.

## Most Enjoyable Task(s)
It's okay.