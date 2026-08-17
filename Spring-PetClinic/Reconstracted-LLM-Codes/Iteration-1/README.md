# Spring PetClinic – LLM Reconstruction Iteration 1

## Overview

This is the first LLM reconstruction of the Spring PetClinic veterinary clinic backend. The system manages Owners, Pets, Visits, and Vets with basic Spring Boot components.

## Architecture

The reconstruction contains the main backend components:

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
├── repository    → Database access
└── model         → JPA entities
```

## Design Patterns

### Singleton

Service classes are managed by Spring dependency injection and use Spring's default singleton scope.

### Factory Pattern

No explicit Factory abstraction was introduced in this iteration.

### Purpose

This iteration provides the baseline LLM reconstruction for analyzing how architectural structure and design patterns change through subsequent prompt refinements.
