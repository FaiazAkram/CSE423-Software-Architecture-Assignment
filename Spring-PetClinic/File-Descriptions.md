# Spring PetClinic File Descriptions

## PetClinicApplication.java
The main Spring Boot application class. It starts the application and initializes the Spring IoC container, which manages the creation and lifecycle of application beans.

---

## OwnerController.java
Handles HTTP requests related to pet owners and forwards requests to the appropriate repository or service components.

---

## PetController.java
Handles HTTP requests related to pet management, including creating, updating, and retrieving pet information.

---

## OwnerRepository.java
Provides database access for Owner entities using Spring Data JPA. It is managed by Spring and demonstrates dependency injection.

---

## VetRepository.java
Provides database access for Veterinarian entities using Spring Data JPA.

---

## Owner.java
Represents the Owner entity and stores owner-related information.

---

## Pet.java
Represents the Pet entity and stores pet-related information.

---

## Vet.java
Represents the Veterinarian entity and stores veterinarian-related information.
