# ✅ TaskFlow

**TaskFlow** is a simple and clean Android to-do app built using classic Android development components such as **XML layouts**, **Fragments**, **ViewBinding**, **Room**, and **MVVM architecture**. It also uses **Hilt** for dependency injection and sets up **Retrofit** for future API integration.

This project is ideal for demonstrating a solid grasp of legacy Android development practices while maintaining modern coding standards.

---

## ✨ Features

- View all tasks in a list
- Add new tasks using a dialog
- Store tasks locally using Room
- Observe tasks with LiveData
- Dependency injection with Hilt

---

## 🔧 Tech Stack

| Layer         | Technology Used                                 |
|---------------|--------------------------------------------------|
| UI            | XML Layouts, Fragments, ViewBinding             |
| Architecture  | MVVM (ViewModel + LiveData)                     |
| Database      | Room                                            |
| Networking    | Retrofit (setup ready)                          |
| DI Framework  | Hilt                                            |
| Language      | Kotlin                                          |

---

## 🏗️ Architecture

The app follows the **MVVM (Model-View-ViewModel)** pattern:

Fragment (View)
↓ observes
ViewModel (UI Logic)
↓ calls
Repository (Data Source)
↓
Room / Retrofit

This separation ensures testability, maintainability, and clarity.

---

## 📁 Project Structure

com.example.taskflow/
├── data/ # Room DB, DAO, Entity
├── di/ # Hilt modules
├── network/ # Retrofit setup (optional)
├── ui/ # Fragments, Dialogs, RecyclerView Adapter
├── viewmodel/ # TaskViewModel (LiveData)
└── MainActivity.kt

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Giraffe or higher
- Kotlin 1.9+
- Gradle 8.0+
- Java 17+

### Steps

1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/TaskFlow.git
