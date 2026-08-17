# Spring PetClinic – LLM Reconstruction Iteration 2

## Overview

This is the second LLM reconstruction of the Spring PetClinic veterinary clinic backend. This iteration improves the architectural separation of the first reconstruction. The Spring Boot veterinary clinic backend manages Owners, Pets, Visits, and Vets using a layered architecture.

## Architecture

The system follows a layered structure:

```text
Controller
    ↓
 Service
    ↓
Repository
    ↓
  Entity

com.vetclinic
├── controller    → REST API endpoints
├── service       → Business logic
│   └── impl      → Service implementations
├── factory       → Entity and DTO creation/mapping
├── repository    → Database access
└── model         → JPA entities
