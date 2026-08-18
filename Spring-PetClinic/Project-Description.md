# Design Pattern Preservation Analysis

## Repository

Spring PetClinic

Original Repository:
https://github.com/spring-projects/spring-petclinic

---

## Identified Design Patterns

### 1. Singleton Pattern

Spring manages controllers and repository beans as singleton objects by default through its Inversion of Control (IoC) container.

Examples:
- OwnerController
- PetController
- OwnerRepository
- VetRepository

**Status after LLM Reconstruction:**
Preserved

---

### 2. Factory Pattern

Spring's IoC container is responsible for creating and injecting application components instead of creating them manually using the `new` keyword.

Examples:
- PetClinicApplication
- OwnerRepository
- VetRepository

**Status after LLM Reconstruction:**
Preserved

---

## Metrics

Pattern Preservation Rate (PPR) = 90%

Pattern Collapse Rate (PCR) = 10%

Abstraction Loss Score (ALS) = -2.50

---

## Selected Files

- PetClinicApplication.java
- OwnerController.java
- PetController.java
- OwnerRepository.java
- VetRepository.java
- Owner.java
- Pet.java
- Vet.java

---

## Conclusion

Spring PetClinic demonstrates object-oriented design through Spring's dependency injection mechanism and layered architecture. The selected files provide sufficient evidence to evaluate whether an LLM preserves the Factory and Singleton design patterns during system reconstruction. The final metric values (PPR, PCR, and ALS) will be determined after comparing the original project with the LLM-generated implementation.
