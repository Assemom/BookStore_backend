Book Store REST API
A Spring Boot REST API for managing books in a bookstore. This project implements basic CRUD operations (Create, Read, Update, Delete) for books.

Features
Create new books
Retrieve a list of all books
Retrieve a specific book by ID
Update existing books
Delete books
Input validation
Exception handling
RESTful endpoints

API Endpoints
Method	Url	Description	Sample Valid Request Body
POST	/api/books	Create a new book	JSON
GET	/api/books	Get all books	
GET	/api/books/{id}	Get book by id	
PUT	/api/books/{id}	Update book	JSON
DELETE	/api/books/{id}	Delete book


Sample Valid JSON Request Bodies
Create/Update Book -> /api/books
JSON

{
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "publishedDate": "1925-04-10"
}


