# Pre-LLM System Snapshot

## Human System (H)

Repository:
Spring PetClinic

Language:
Java / Spring Boot

The original system was examined as the human-written baseline before
LLM reconstruction.

## Selected Components

- Owner
- Pet
- Vet
- OwnerController
- PetController
- OwnerRepository
- VetRepository
- PetClinicApplication

## Relevant Design Structure

The original system uses Spring dependency injection and Spring-managed
components. Controllers handle web requests, repositories provide
data-access abstractions, and entity classes represent domain objects.

## Design Patterns

### Singleton
Spring-managed components are singleton-scoped by default.

Evidence:
- Controller beans
- Repository beans

### Factory
The Spring PetClinic code uses the factory pattern.
