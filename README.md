# 📚 Book Management System (Bookshelf Project)

A simple and elegant **Book Management Web Application** built with **Spring Boot**, **Thymeleaf**, and **MySQL**.  
This project allows users to **add, view, search, and delete books**, making it a perfect beginner-friendly full-stack Spring Boot project.

---

## 🚀 Features

- 📖 **View All Books** – Displays a complete list of books stored in the library.  
- 🔍 **Search Books** – Search by **Author** or **Title** (or both).  
- ➕ **Add Book** – Add new books to the collection.  
- ❌ **Delete Book** – Remove unwanted books easily.  
- 🎨 **Responsive UI** – Beautiful web interface styled with a bookshelf background.  

---

## 🏗️ Project Structure

```plaintext
src/
├── main/
│   ├── java/com/example/book/
│   │   ├── BookApplication.java
│   │   ├── controllers/
│   │   │   └── BookController.java
│   │   ├── models/
│   │   │   └── Book.java
│   │   └── services/
│   │       └── BookService.java
│   └── resources/
│       ├── templates/
│       │   ├── index.html
│       │   └── add-book.html
│       ├── static/
│       │   └── images/background.jpg
│       └── application.properties
└── test/
