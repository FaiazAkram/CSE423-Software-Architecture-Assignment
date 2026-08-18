# Final Project Report

## Spring PetClinic — Design Pattern Preservation Analysis

**Course:** CSE423 — Software Architecture
**Task:** Task 2 — Design Pattern Preservation
**System:** Spring PetClinic
**Language:** Java / Spring Boot
**LLM Reconstruction:** Claude
**Analysis Type:** Human-Written vs. LLM-Generated Architecture

---

## 1. Project Overview

This project evaluates whether a Large Language Model (LLM) can preserve the architectural structure and object-oriented design patterns of a real software system when reconstructing it from its requirements and source structure.

The selected system is **Spring PetClinic**, a Java/Spring Boot veterinary clinic application.

The study compares:

* The original human-written implementation
* Three LLM reconstruction iterations
* Architectural structure
* Design pattern preservation
* Abstraction changes
* The effect of prompt refinement

The main objective is to determine whether the LLM can reproduce not only the **functionality** of the original system, but also its **architectural intent and design patterns**.

---

# 2. Repository

### Original Spring PetClinic

[Spring PetClinic Official Repository](https://github.com/spring-projects/spring-petclinic)

### Student Analysis Repository

[CSE423 Software Architecture Assignment](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment)

### Spring PetClinic Project Folder

[Spring-PetClinic](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/tree/main/Spring-PetClinic)

---

# 3. Repository Selection & Justification

## Selected Repository

**Spring PetClinic**

Spring PetClinic was selected because it is a real Java/Spring Boot application with meaningful architectural structure and multiple interacting components.

The system provides a suitable environment for analyzing whether an LLM preserves object-oriented design patterns during reconstruction.

### Repository Requirement Check

| Requirement              | Evidence                                           | Status      |
| ------------------------ | -------------------------------------------------- | ----------- |
| Programming Language     | Java / Spring Boot                                 | ✅ Satisfied |
| Real Software System     | Spring PetClinic veterinary clinic application     | ✅ Satisfied |
| Architecture             | Controller, Repository, Service, Entity structures | ✅ Satisfied |
| Multi-file System        | Multiple Java classes and interfaces               | ✅ Satisfied |
| Development History      | Long-running open-source project                   | ✅ Satisfied |
| Design Pattern Relevance | Singleton and Factory-related object creation      | ✅ Satisfied |

---

# 4. Project Objective

The main objectives of this project are:

1. Analyze the original human-written Spring PetClinic architecture.
2. Identify the design patterns used in the selected system.
3. Reconstruct the system using an LLM.
4. Perform multiple prompt iterations.
5. Improve architectural fidelity through prompt refinement.
6. Compare the human-written and LLM-generated systems.
7. Calculate:

   * Pattern Preservation Rate (PPR)
   * Pattern Collapse Rate (PCR)
   * Abstraction Loss Score (ALS)
8. Determine whether explicit architectural instructions improve LLM reconstruction quality.

---

# 5. Human-Written System

The original human-written files selected for analysis are stored inside:

```text
Original-Codes/
```

## Selected Files

| # | File                        | Architectural Role      |
| - | --------------------------- | ----------------------- |
| 1 | `PetClinicApplication.java` | Spring Boot Application |
| 2 | `OwnerController.java`      | Controller              |
| 3 | `PetController.java`        | Controller              |
| 4 | `OwnerRepository.java`      | Repository              |
| 5 | `VetRepository.java`        | Repository              |
| 6 | `Owner.java`                | Domain Entity           |
| 7 | `Pet.java`                  | Domain Entity           |
| 8 | `Vet.java`                  | Domain Entity           |

---

# 6. Human Architecture

The selected human-written system follows a Spring-based architecture.

```text
              Spring Application
                     │
                     ▼
             ┌──────────────┐
             │  Controller  │
             └───────┬──────┘
                     │
                     ▼
             ┌──────────────┐
             │  Repository  │
             └───────┬──────┘
                     │
                     ▼
             ┌──────────────┐
             │    Entity    │
             └──────────────┘
```

Spring's IoC container manages the application components and their dependencies.

---

# 7. Identified Design Patterns

Two design patterns were selected for this analysis:

1. Singleton
2. Factory

---

## 7.1 Singleton Pattern

Spring-managed components use Spring's default Singleton scope.

Examples include:

* `OwnerController`
* `PetController`
* `OwnerRepository`
* `VetRepository`

Therefore:

```text
Singleton ∈ P(H)
```

The Singleton behavior is provided through Spring's IoC container rather than manually implementing a static Singleton object.

---

## 7.2 Factory Pattern

For this project, Spring's IoC container is treated as the Factory-related object-creation mechanism.

Instead of application code manually creating managed components using:

```java
new SomeComponent()
```

Spring creates and injects the required components.

Therefore:

```text
Factory ∈ P(H)
```

---

# 8. Human Pattern Set

The human-written system contains the following patterns for this analysis:

```text
P(H) = { Singleton, Factory }
```

Therefore:

```text
|P(H)| = 2
```

---

# 9. Human Abstraction Count

The selected human snapshot contains the following explicit abstractions:

| Abstraction       | Type      |
| ----------------- | --------- |
| `OwnerRepository` | Interface |
| `VetRepository`   | Interface |

Therefore:

```text
A(H) = 2
```

### Human Abstraction Summary

```text
Interfaces      = 2
Abstract classes = 0

A(H) = 2
```

---

# 10. LLM Reconstruction Process

The reconstruction was performed through three progressively refined prompts.

The prompt files are available inside:

```text
Prompts/
```

### Prompt Files

* `Prompt-1.md`
* `Prompt-2.md`
* `Prompt-3.md`

---

# 11. Iteration 1 — Initial Reconstruction

## Objective

The first prompt established a basic functional reconstruction of the Spring PetClinic backend.

The prompt mainly focused on:

* Spring Boot
* Owners
* Pets
* Visits
* Vets
* Basic application functionality

## Result

The LLM produced a functional baseline.

However, the architecture was not explicitly constrained.

### Main Limitation

The Factory abstraction was not explicitly preserved.

```text
Functional Requirements
        ↓
Basic Spring Boot System
        ↓
Partial Architectural Preservation
```

---

# 12. Iteration 2 — Layered Architecture + Factory

The second prompt was refined based on the limitations observed in Iteration 1.

## Main Requirements

The prompt introduced:

* Controller layer
* Service layer
* Repository layer
* Entity layer
* Separation of business logic
* Factory classes
* Better multi-file organization

## Result

The architecture became more structured:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Entity
```

Factory classes were also introduced.

However, the Factory implementation was still primarily concrete and did not provide the strongest possible abstraction boundary.

---

# 13. Iteration 3 — Factory Abstraction + Singleton

The third prompt was designed to explicitly preserve architectural abstractions.

## Main Requirements

The final prompt requested:

* Controller / Service / Repository / Entity layers
* Factory interface
* Concrete Factory implementations
* Singleton components
* Spring dependency injection
* SOLID principles
* Separation of responsibilities
* Multi-file architecture

## Result

The final reconstruction introduced explicit Factory abstractions and concrete implementations.

The final architecture is:

```text
                 ┌──────────────┐
                 │  Controller  │
                 └──────┬───────┘
                        │
                        ▼
                 ┌──────────────┐
                 │   Service    │
                 └──────┬───────┘
                        │
             ┌──────────┴──────────┐
             │                     │
             ▼                     ▼
      ┌──────────────┐      ┌──────────────┐
      │  Repository  │      │   Factory    │
      └──────┬───────┘      └──────┬───────┘
             │                     │
             └──────────┬──────────┘
                        ▼
                 ┌──────────────┐
                 │    Entity    │
                 └──────────────┘
```

---

# 14. Prompt Refinement Summary

| Iteration | Main Focus                              | Architectural Improvement                             |
| --------- | --------------------------------------- | ----------------------------------------------------- |
| Prompt 1  | Basic reconstruction                    | Established functional baseline                       |
| Prompt 2  | Layered Architecture + Factory          | Added Service layer and Factory classes               |
| Prompt 3  | Factory Abstraction + Singleton + SOLID | Added explicit Factory interfaces and implementations |

### Overall Progression

```text
Prompt 1
Basic Reconstruction
        ↓
Prompt 2
Layered Architecture + Factory
        ↓
Prompt 3
Factory Abstraction + Singleton + SOLID
        ↓
Final LLM Architecture
```

---

# 15. Final LLM-Generated System

The final reconstruction is stored in:

```text
Reconstracted-LLM-Codes/
└── Iteration-3/
```

[View Iteration-3 on GitHub](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/tree/main/Spring-PetClinic/Reconstracted-LLM-Codes/Iteration-3)

The final system contains explicit:

* Controllers
* Services
* Repositories
* Entities
* Factory interfaces
* Factory implementations
* Spring-managed components

---

# 16. Factory Abstraction

The final reconstruction introduces a generic Factory abstraction:

```java
public interface EntityFactory<E, RES>
```

Entity-specific Factory interfaces extend this abstraction.

Conceptually:

```text
EntityFactory
      │
      ├── OwnerFactory
      │       └── OwnerFactoryImpl
      │
      ├── PetFactory
      │       └── PetFactoryImpl
      │
      ├── VetFactory
      │       └── VetFactoryImpl
      │
      └── VisitFactory
              └── VisitFactoryImpl
```

This provides an explicit separation between:

* Object creation
* Entity/DTO mapping
* Business logic

---

# 17. Singleton Behavior in the LLM System

The final reconstruction uses Spring-managed components.

Example:

```java
@Service
public class OwnerServiceImpl implements OwnerService
```

Factory implementations are also Spring-managed components:

```java
@Component
public class OwnerFactoryImpl implements OwnerFactory
```

Spring uses Singleton scope by default for managed beans unless another scope is explicitly specified.

Therefore:

```text
OwnerServiceImpl → Singleton
OwnerFactoryImpl → Singleton
```

The LLM preserves Singleton behavior through Spring dependency injection instead of manually implementing:

```java
private static Instance instance;
```

or:

```java
getInstance();
```

---

# 18. Final LLM Abstraction Count

The final Iteration-3 system contains the following explicit interfaces:

| # | Interface         | Type                 |
| - | ----------------- | -------------------- |
| 1 | `EntityFactory`   | Factory Interface    |
| 2 | `OwnerFactory`    | Factory Interface    |
| 3 | `OwnerRepository` | Repository Interface |
| 4 | `OwnerService`    | Service Interface    |
| 5 | `PetFactory`      | Factory Interface    |
| 6 | `VetFactory`      | Factory Interface    |
| 7 | `VisitFactory`    | Factory Interface    |

Therefore:

```text
A(L) = 7
```

### Comparison

```text
Human abstractions = 2
LLM abstractions   = 7
```

---

# 19. Code Quality Assessment

The final LLM-generated implementation is structurally non-trivial.

It contains:

* Multiple classes
* Multiple interfaces
* Multiple packages
* Factory abstractions
* Factory implementations
* Service abstraction
* Service implementation
* Repository abstraction
* Controllers
* Entities
* Dependency Injection
* Spring-managed components

The final implementation therefore goes beyond a single-file functional reconstruction.

---

# 20. Metric Calculation

The three required metrics are:

1. Pattern Preservation Rate (PPR)
2. Pattern Collapse Rate (PCR)
3. Abstraction Loss Score (ALS)

---

# 21. Pattern Preservation Rate (PPR)

## Formula

```text
PPR = |P(H) ∩ P(L)| / |P(H)|
```

Where:

* `P(H)` = patterns in the human-written system
* `P(L)` = patterns in the LLM-generated system

---

## Human Pattern Set

```text
P(H) = { Singleton, Factory }
```

Therefore:

```text
|P(H)| = 2
```

---

## LLM Pattern Set

The final LLM reconstruction contains:

```text
P(L) = { Singleton, Factory }
```

Therefore:

```text
P(H) ∩ P(L)
= { Singleton, Factory }
```

And:

```text
|P(H) ∩ P(L)| = 2
```

---

## Calculation

```text
PPR = 2 / 2

PPR = 1.00
```

### Final Result

```text
PPR = 100%
```

### Interpretation

**100% of the identified human design patterns were preserved in the final LLM reconstruction.**

---

# 22. Pattern Collapse Rate (PCR)

## Formula

```text
PCR = |P_collapsed| / |P(H)|
```

Where:

```text
P_collapsed
```

represents patterns from the human system that disappeared or were replaced by simpler structures.

---

## Pattern Status

| Pattern   | Human | LLM | Status    |
| --------- | ----- | --- | --------- |
| Singleton | ✅     | ✅   | Preserved |
| Factory   | ✅     | ✅   | Preserved |

Therefore:

```text
P_collapsed = ∅
```

And:

```text
|P_collapsed| = 0
```

---

## Calculation

```text
PCR = 0 / 2

PCR = 0.00
```

### Final Result

```text
PCR = 0%
```

### Interpretation

**No identified human design pattern collapsed in the final Iteration-3 reconstruction.**

---

# 23. Abstraction Loss Score (ALS)

## Formula

```text
ALS = (A(H) - A(L)) / A(H)
```

Where:

* `A(H)` = interfaces + abstract classes in the human system
* `A(L)` = interfaces + abstract classes in the LLM system

---

## Human Abstraction Count

```text
A(H) = 2
```

Human abstractions:

```text
OwnerRepository
VetRepository
```

---

## LLM Abstraction Count

```text
A(L) = 7
```

LLM abstractions:

```text
EntityFactory
OwnerFactory
OwnerRepository
OwnerService
PetFactory
VetFactory
VisitFactory
```

---

## Calculation

```text
ALS = (A(H) - A(L)) / A(H)

ALS = (2 - 7) / 2

ALS = -5 / 2

ALS = -2.50
```

### Final Result

```text
ALS = -2.50
```

or:

```text
ALS = -250%
```

---

# 24. ALS Interpretation

The negative ALS is **not a calculation error**.

The formula measures abstraction loss:

```text
ALS = (Human Abstractions - LLM Abstractions)
      / Human Abstractions
```

In this project:

```text
Human abstractions = 2
LLM abstractions   = 7
```

Therefore, the LLM reconstruction contains:

```text
7 - 2 = 5
```

additional explicit abstractions.

So the result indicates:

> **Net abstraction increase rather than abstraction loss.**

The additional abstractions were mainly introduced through the explicit Factory and Service interfaces required in Iteration 3.

---

# 25. Final Metric Summary

| Metric  | Formula            |          Human |            LLM | Calculation | Final Result |            |             |         |          |
| ------- | ------------------ | -------------: | -------------: | ----------- | -----------: | ---------- | ----------- | ------- | -------- |
| **PPR** | `                  |    P(H) ∩ P(L) |              / | P(H)        |            ` | 2 patterns | 2 preserved | `2 / 2` | **100%** |
| **PCR** | `                  |    P_collapsed |              / | P(H)        |            ` | 2 patterns | 0 collapsed | `0 / 2` | **0%**   |
| **ALS** | `(A(H)-A(L))/A(H)` | 2 abstractions | 7 abstractions | `(2-7)/2`   |    **-2.50** |            |             |         |          |

---

# 26. Human vs. LLM Architecture Comparison

| Aspect               | Human-Written System            | LLM Iteration 3                               |
| -------------------- | ------------------------------- | --------------------------------------------- |
| Architecture         | Spring-based architecture       | Explicit layered reconstruction               |
| Controller Layer     | ✅                               | ✅                                          |
| Service Layer        | Limited in selected snapshot    | ✅ Explicit                                   |
| Repository Layer     | ✅                               | ✅                                          |
| Entity Layer         | ✅                               | ✅                                          |
| Singleton            | Spring-managed                  | Spring-managed                                |
| Factory              | Framework-based object creation | Explicit Factory interfaces + implementations |
| Factory Abstraction  | Implicit                        | Explicit                                      |
| Interfaces Counted   | 2                               | 7                                             |
| Pattern Preservation | Baseline                        | **100%**                                      |
| Pattern Collapse     | Baseline                        | **0%**                                        |
| Abstraction Change   | 2 abstractions                  | **7 abstractions**                            |

---

# 27. Comparative Analysis

## 27.1 Iteration 1

The first reconstruction primarily reproduced functionality.

```text
Functional Requirements
        ↓
Basic Spring Boot System
        ↓
Partial Architectural Preservation
```

The Factory abstraction was not explicitly represented.

---

## 27.2 Iteration 2

The second reconstruction introduced stronger architectural requirements.

```text
More Architectural Constraints
        ↓
Controller / Service / Repository / Entity
        ↓
Factory Classes
```

This improved the architecture, but the Factory abstraction was still not fully explicit.

---

## 27.3 Iteration 3

The third reconstruction explicitly requested abstraction and implementation separation.

```text
Factory Interface
        ↓
Concrete Factory Implementation
```

This resulted in:

* `EntityFactory`
* `OwnerFactory`
* `PetFactory`
* `VetFactory`
* `VisitFactory`

and their corresponding implementations.

---

# 28. Main Structural Finding

The strongest finding from this project is:

> **Prompt specificity directly influenced architectural fidelity.**

The three iterations demonstrate:

```text
Functional Description
        ↓
Layer Constraints
        ↓
Pattern + Abstraction Constraints
        ↓
Higher Architectural Fidelity
```

When the prompt focused mainly on functionality, the LLM reproduced behavior but provided weaker architectural structure.

When the prompt explicitly specified architectural layers and design patterns, the resulting implementation became structurally stronger.

---

# 29. Factory Preservation Finding

The Factory pattern improved progressively.

### Iteration 1

```text
No Explicit Factory Abstraction
```

### Iteration 2

```text
Concrete Factory Classes
```

### Iteration 3

```text
Factory Interface
        ↓
Concrete Factory Implementation
```

This demonstrates how explicit architectural requirements can influence the structure generated by an LLM.

---

# 30. Singleton Preservation Finding

Singleton behavior was comparatively easy to preserve because Spring provides Singleton scope by default for managed components.

The LLM did not need to manually implement:

```java
private static Instance instance;
```

Instead:

```text
Spring IoC Container
        ↓
Managed Bean
        ↓
Default Singleton Scope
```

Therefore, Singleton preservation was largely supported by the framework itself.

---

# 31. Final Comparison Summary

> **Our study compares human-written Spring PetClinic code with LLM-reconstructed code generated through three progressively refined prompts. The human system relies on Spring's dependency injection and repository abstractions, with Singleton behavior provided by Spring and Factory-style object creation handled through the framework. The first LLM reconstruction reproduced the basic functionality but did not introduce an explicit Factory abstraction. The second iteration improved the Controller–Service–Repository separation and introduced Factory classes, while the third iteration explicitly required Factory interfaces, concrete implementations, Singleton services, and stronger architectural separation. As a result, the final reconstruction preserved both identified design patterns, achieving a Pattern Preservation Rate of 100% and a Pattern Collapse Rate of 0%. The abstraction analysis additionally shows that the LLM increased the number of explicit interfaces from 2 in the selected human snapshot to 7 in Iteration 3, producing a raw Abstraction Loss Score of -2.50, which indicates a net abstraction increase rather than abstraction loss. Overall, the Spring PetClinic experiment shows that LLMs can preserve and even make architectural abstractions more explicit when prompts provide clear structural constraints; architectural fidelity therefore depends strongly on how specifically the desired architecture and design patterns are communicated to the model.**

---

# 32. Overall Findings

| Finding                            | Result                 |
| ---------------------------------- | ---------------------- |
| Human design patterns identified   | **2**                  |
| LLM design patterns preserved      | **2**                  |
| Pattern Preservation Rate          | **100%**               |
| Pattern Collapse Rate              | **0%**                 |
| Human abstractions                 | **2**                  |
| LLM abstractions                   | **7**                  |
| Abstraction Loss Score             | **-2.50**              |
| Net abstraction change             | **+5 abstractions**    |
| Main factor affecting preservation | **Prompt specificity** |

---

# 33. Limitations

The following limitations should be considered when interpreting the results:

1. The human baseline represents a selected snapshot rather than the complete Spring PetClinic codebase.
2. The Factory interpretation in the human system is framework-based and follows the project's stated analysis methodology.
3. ALS is sensitive to the selected comparison scope.
4. A negative ALS indicates an increase in explicit abstraction under the specified formula; it should not automatically be interpreted as a quality score.
5. The primary focus of this experiment is architectural and pattern preservation rather than complete functional equivalence.
6. The results apply to the selected Spring PetClinic scope and should not automatically be generalized to every LLM or software project.

---

# 34. Project Structure

```text
Spring-PetClinic/
│
├── Original-Codes/
│   ├── Owner.java
│   ├── OwnerController.java
│   ├── OwnerRepository.java
│   ├── Pet.java
│   ├── PetClinicApplication.java
│   ├── PetController.java
│   ├── Vet.java
│   └── VetRepository.java
│
├── Prompts/
│   ├── Prompt-1.md
│   ├── Prompt-2.md
│   ├── Prompt-3.md
│   └── README.md
│
├── Reconstracted-LLM-Codes/
│   ├── Iteration-1/
│   ├── Iteration-2/
│   └── Iteration-3/
│
├── File-Descriptions.md
├── LLM-File-Descriptions.md
├── Project-Description.md
└── README.md
```

---

# 35. Evidence and Supporting Files

## Human-Written Code

[Original-Codes](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/tree/main/Spring-PetClinic/Original-Codes)

## Prompt Iterations

[Prompts](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/tree/main/Spring-PetClinic/Prompts)

## LLM Reconstruction

[Reconstracted-LLM-Codes](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/tree/main/Spring-PetClinic/Reconstracted-LLM-Codes)

## Final Iteration

[Iteration-3](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/tree/main/Spring-PetClinic/Reconstracted-LLM-Codes/Iteration-3)

## Project Description

[Project-Description.md](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/blob/main/Spring-PetClinic/Project-Description.md)

## Human File Descriptions

[File-Descriptions.md](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/blob/main/Spring-PetClinic/File-Descriptions.md)

## LLM File Descriptions

[LLM-File-Descriptions.md](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/blob/main/Spring-PetClinic/LLM-File-Descriptions.md)

---

# 36. Conclusion

The Spring PetClinic experiment demonstrates that LLM-generated software can preserve architectural design patterns when the required structures are explicitly communicated.

The final reconstruction achieved:

```text
Pattern Preservation Rate = 100%

Pattern Collapse Rate = 0%

Abstraction Loss Score = -2.50
```

The most important observation is that the LLM's architectural output improved as the prompts became more specific.

The progression was:

```text
Prompt 1
Functional Requirements
        ↓
Partial Structural Preservation

Prompt 2
Functional + Layered Architecture
        ↓
Improved Separation + Factory Classes

Prompt 3
Functional + Layers + Explicit Abstractions
        ↓
Factory Interfaces + Implementations
+ Singleton Services
+ Stronger Separation
```

Therefore:

> **LLMs are capable of reproducing architectural patterns, but explicit architectural constraints and iterative prompt refinement substantially improve the probability of preserving those patterns.**

---

# 37. Final Metric Snapshot

```text
┌─────────────────────────────────────────┐
│       TASK 2 — FINAL RESULTS            │
├─────────────────────────────────────────┤
│ Human Patterns             : 2          │
│ LLM Patterns Preserved     : 2          │
│                                         │
│ PPR                         : 100%       │
│ PCR                         : 0%         │
│                                         │
│ Human Abstractions          : 2          │
│ LLM Abstractions            : 7          │
│ ALS                         : -2.50      │
│                                         │
│ Net Abstraction Change      : +5        │
│                                         │
│ Main Finding:                            │
│ Prompt specificity improves              │
│ architectural fidelity.                 │
└─────────────────────────────────────────┘
```

---

# 38. References

1. [Spring PetClinic — Official Repository](https://github.com/spring-projects/spring-petclinic)
2. [CSE423 Software Architecture Assignment Repository](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment)
3. [Spring-PetClinic Project](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/tree/main/Spring-PetClinic)
4. [Original-Codes](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/tree/main/Spring-PetClinic/Original-Codes)
5. [Prompt Iterations](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/tree/main/Spring-PetClinic/Prompts)
6. [LLM Iteration-3](https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/tree/main/Spring-PetClinic/Reconstracted-LLM-Codes/Iteration-3)
   ::: 

