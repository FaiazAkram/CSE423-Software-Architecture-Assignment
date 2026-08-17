# LLM-Generated vs. Human-Written Architecture:
# Comparative Analysis

## 1. Human-Written System

The original Spring PetClinic system uses Spring-based components
including controllers, repositories, entities, and dependency
injection.

The human-written system provides established architectural
separation between application responsibilities.

## 2. LLM Iteration 1

The first reconstruction successfully recreated the basic veterinary
clinic functionality.

However, the design-pattern structure was not explicitly specified.
There was no explicit Factory abstraction.

The architecture therefore represents a functional baseline rather
than a deliberate preservation of design-pattern abstractions.

## 3. LLM Iteration 2

The second reconstruction improved architectural separation by
introducing Controller, Service, Repository, and Entity layers.

It also introduced dedicated Factory classes.

This represents an improvement in separation of responsibilities
compared with Iteration 1.

## 4. LLM Iteration 3

The third reconstruction further strengthened abstraction.

Factory interfaces and concrete implementations were introduced,
while Spring dependency injection continued to provide
singleton-scoped services.

The architecture therefore became more explicitly object-oriented
and abstraction-oriented.

## Structural Comparison

| Aspect | Human | Iteration 1 | Iteration 2 | Iteration 3 |
|---|---|---|---|---|
| Controller separation | Present | Present | Present | Present |
| Service layer | Present/verify | Present | Explicit | Explicit |
| Repository layer | Present | Present | Present | Present |
| Singleton behavior | Present | Preserved | Preserved | Preserved |
| Factory abstraction | Not confirmed | No | No explicit abstraction | Yes |
| Abstraction level | Baseline | Lower | Increased | Highest |

## Key Observation

The LLM reconstructions became progressively more structured as the
prompts became more specific.

The most significant change occurred between Iterations 2 and 3,
where Factory abstraction was made explicit instead of using only
concrete Factory classes.






























# LLM-Generated vs. Human-Written Architecture: Comparative Analysis

**System under study:** Spring PetClinic — selected Controller, Repository, Entity, and application components
**Human (H) source:** Selected files from the original Spring PetClinic repository
**LLM (L) source:** Iteration-3 reconstruction generated through iterative prompting
**Task:** Task 2 — Design Pattern Preservation

---

## 1. Repository Selection & Justification

### Repository

**Spring PetClinic**

Original repository:

https://github.com/spring-projects/spring-petclinic

Project copy and analysis:

https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment/tree/main/Spring-PetClinic

Spring PetClinic is a real Spring Boot veterinary clinic application. The official repository currently contains more than 1,000 commits and follows a multi-layer Java/Spring architecture with source packages for controllers, repositories, services, and domain models.

### Repository Requirement Check

| Rule        | Evidence                                                                                                                                                      | Verdict     |
| ----------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------- |
| Language    | Java / Spring Boot                                                                                                                                            | ✅ Satisfied |
| Size        | **1,040 commits** currently shown in the upstream repository                                                                                                  | ✅ Satisfied |
| History     | Project has long-running historical development dating back to the early Spring PetClinic codebase; source files contain historical references dating to 2013 | ✅ Satisfied |
| Structure   | `src` contains controller, service, repository, and model/domain structures                                                                                   | ✅ Satisfied |
| System Type | Real Spring Boot web/backend application                                                                                                                      | ✅ Satisfied |

### Why Spring PetClinic was selected

Spring PetClinic is appropriate for Task 2 because it is a real, multi-class Java/Spring application rather than a toy or tutorial-only system. The architecture uses Spring's dependency injection and repository abstractions, providing a suitable environment for studying whether an LLM preserves object-oriented design patterns during reconstruction.

The faculty assignment requires a real software system written in Java, Python, or TypeScript, with sufficient size/history and meaningful architectural structure. Spring PetClinic satisfies the relevant requirements.

---

## 2. Pre-LLM System Snapshot & Task Analysis

### Human-written system

The human-written baseline was extracted from the original Spring PetClinic implementation and reduced to the selected files relevant to the design-pattern analysis.

The selected human snapshot contains:

| # | Human File                  | Architectural Role                 |
| - | --------------------------- | ---------------------------------- |
| 1 | `PetClinicApplication.java` | Application / Spring IoC bootstrap |
| 2 | `OwnerController.java`      | Controller                         |
| 3 | `PetController.java`        | Controller                         |
| 4 | `OwnerRepository.java`      | Repository abstraction             |
| 5 | `VetRepository.java`        | Repository abstraction             |
| 6 | `Owner.java`                | Domain Entity                      |
| 7 | `Pet.java`                  | Domain Entity                      |
| 8 | `Vet.java`                  | Domain Entity                      |

These files are preserved in:

`Original-Codes/`

The project repository documents the same selected-file set.

### Human architectural characteristics

The original system relies heavily on the Spring IoC container.

For this analysis, two design patterns were identified:

### Pattern 1 — Singleton

Spring-managed application components such as controllers and repository beans are managed by the Spring IoC container and use Spring's default singleton scope.

Examples include:

* `OwnerController`
* `PetController`
* `OwnerRepository`
* `VetRepository`

The project's design-pattern description explicitly identifies Spring-managed components as Singleton objects.

### Pattern 2 — Factory

Spring's IoC container is responsible for creating and injecting application components rather than application code manually constructing those components using `new`.

The project therefore treats Spring's object/component creation mechanism as the Factory-related abstraction used for this comparison.

### Human pattern set

Therefore:

```text
P(H) = { Singleton, Factory }

|P(H)| = 2
```

### Human abstraction count

For the selected human snapshot, the directly counted abstraction types are:

* `OwnerRepository` → interface
* `VetRepository` → interface

Therefore:

```text
A(H) = 2

2 interfaces + 0 abstract classes = 2 abstractions
```

---

## 3. LLM Prompt Design & Iterative Refinement

Three reconstruction iterations were used. This follows the faculty requirement that deliberate prompt refinement should be demonstrated through multiple iterations. The faculty rubric awards the full prompt-design score when at least three iterations are submitted and each change has a clear architectural reason.

### Iteration 1 — Initial Reconstruction

**Prompt focus:**

> Create a Spring Boot veterinary clinic backend that manages Owners, Pets, Visits, and Vets.

The first prompt intentionally established a functional baseline without explicitly forcing the desired design-pattern abstractions.

**Observed result:**

* Basic Spring Boot components were generated.
* Controller/Repository/Entity structure existed.
* Singleton behavior was implicit through Spring.
* No explicit Factory abstraction was introduced.

This provided the baseline for further refinement.

---

### Iteration 2 — Layered Architecture + Factory

The second prompt responded to the architectural weakness observed in Iteration 1.

The prompt explicitly requested:

* Controller layer
* Service layer
* Repository layer
* Entity layer
* Separation of business logic
* Multi-file organization

It also attempted to introduce Factory classes.

**Observed improvement:**

* Clearer Controller → Service → Repository → Entity separation
* Factory classes were introduced
* Singleton services continued to be managed through Spring

However, the Factory implementation was still concrete and utility-like rather than a clearly defined Factory abstraction.

---

### Iteration 3 — Explicit Factory Abstraction + Singleton

The final prompt addressed the remaining structural problem.

It explicitly requested:

* Controller / Service / Repository / Entity separation
* A Factory interface
* Concrete Factory implementations
* Separation of object creation from business logic
* Spring-managed Singleton services
* SOLID-oriented structure
* Complete multi-file organization

The prompt was designed specifically to preserve the abstraction rather than merely reproduce functionality.

### Iterative Refinement Summary

| Iteration | Main Focus                              | Main Architectural Improvement                                 |
| --------- | --------------------------------------- | -------------------------------------------------------------- |
| Prompt 1  | Basic reconstruction                    | Established functional baseline                                |
| Prompt 2  | Layered architecture + Factory          | Added Service layer and Factory classes                        |
| Prompt 3  | Factory abstraction + Singleton + SOLID | Added explicit Factory interfaces and concrete implementations |

### Overall Prompt Progress

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
Final LLM System
Explicit Factory Interfaces + Implementations
```

This progression demonstrates that prompt refinement directly affected architectural fidelity.

---

## 4. LLM-Generated Code Quality

The final Iteration-3 reconstruction is structurally non-trivial.

The uploaded Iteration-3 commit contains **18 files**. These include:

* `EntityFactory.java`
* `OwnerFactory.java`
* `OwnerFactoryImpl.java`
* `PetFactory.java`
* `PetFactoryImpl.java`
* `VetFactory.java`
* `VetFactoryImpl.java`
* `VisitFactory.java`
* `VisitFactoryImpl.java`
* `OwnerService.java`
* `OwnerServiceImpl.java`
* `OwnerRepository.java`
* `OwnerController.java`
* `Owner.java`
* `Pet.java`
* `Vet.java`
* `VetClinicApplication.java`
* `README.md`

The actual GitHub commit records these 18 files and 802 lines of added code.

### Structural quality

The final reconstruction explicitly separates:

```text
Controller
     ↓
 Service
     ↓
Repository
     ↓
 Entity

 Service
     ↓
 Factory
     ↓
 Entity
```

The Iteration-3 README describes this layered organization, including separate `controller`, `service`, `factory`, `repository`, and `model` packages.

### Factory abstraction

The final reconstruction contains:

```java
public interface EntityFactory<E, RES>
```

and entity-specific Factory interfaces such as:

```java
public interface OwnerFactory
        extends EntityFactory<Owner, OwnerResponseDTO>
```

The implementation then provides:

```java
public class OwnerFactoryImpl implements OwnerFactory
```

This demonstrates a genuine interface → implementation relationship rather than merely placing object-creation methods inside a utility class.

### Singleton behavior

The Factory implementations and Service implementations are Spring-managed components.

For example:

```java
@Service
public class OwnerServiceImpl implements OwnerService
```

and:

```java
@Component
public class OwnerFactoryImpl implements OwnerFactory
```

Because these components are managed by Spring and no prototype scope is specified, they use Spring's default singleton scope.

The Iteration-3 documentation explicitly identifies Service and Factory implementations as Spring-managed Singleton components.

### Code-quality assessment

**Result: Structurally meaningful and substantially improved over Iterations 1 and 2.**

The final version demonstrates:

* Multiple classes
* Multiple interfaces
* Layer separation
* Explicit Factory abstractions
* Concrete Factory implementations
* Dependency injection
* Spring-managed Singleton components

The faculty rubric defines full code-quality credit as complete, runnable, and structurally non-trivial multi-file code rather than a single-file dump.

---

# 5. Metric Calculation & Accuracy

The faculty defines the three required Task-2 metrics as:

1. Pattern Preservation Rate (PPR)
2. Pattern Collapse Rate (PCR)
3. Abstraction Loss Score (ALS)

The formulas below follow the official assignment definitions.

---

## 5.1 Pattern Preservation Rate (PPR)

### Formula

```text
PPR = |P(H) ∩ P(L)| / |P(H)|
```

Where:

* `P(H)` = design patterns in the human system
* `P(L)` = design patterns in the LLM system

The faculty defines PPR as the fraction of original design patterns preserved after reconstruction.

### Human pattern set

```text
P(H) = { Singleton, Factory }
```

Therefore:

```text
|P(H)| = 2
```

### LLM pattern set

The final Iteration-3 system contains:

```text
P(L) = { Singleton, Factory }
```

Evidence:

* Factory interfaces and implementations are explicitly present.
* Services and Factory implementations are Spring-managed Singleton components.

Therefore:

```text
P(H) ∩ P(L)
= { Singleton, Factory }

|P(H) ∩ P(L)| = 2
```

### Calculation

```text
PPR = 2 / 2

PPR = 1.00
```

### Percentage

```text
PPR = 100%
```

### Interpretation

**100% of the identified human design patterns were preserved in the final LLM reconstruction.**

Unlike a reconstruction that replaces patterns with procedural logic, Iteration 3 explicitly introduced the required Factory abstraction and retained Spring's Singleton behavior.

---

## 5.2 Pattern Collapse Rate (PCR)

### Formula

```text
PCR = |P_collapsed| / |P(H)|
```

Where `P_collapsed` represents patterns from the human system that disappeared or were replaced by simpler constructs.

### Original pattern count

```text
|P(H)| = 2
```

Patterns:

```text
Singleton
Factory
```

### Collapsed patterns

In the final Iteration-3 reconstruction:

* Singleton → preserved
* Factory → preserved

Therefore:

```text
P_collapsed = ∅
```

and:

```text
|P_collapsed| = 0
```

### Calculation

```text
PCR = 0 / 2

PCR = 0.00
```

### Percentage

```text
PCR = 0%
```

### Interpretation

**None of the identified human design patterns collapsed during the final reconstruction.**

This is a significant improvement over the earlier iterations, particularly because Iteration 1 contained no explicit Factory abstraction and Iteration 2 contained Factory classes without a clear abstraction.

---

# 5.3 Abstraction Loss Score (ALS)

### Formula

```text
ALS = (A(H) - A(L)) / A(H)
```

Where:

* `A(H)` = interfaces + abstract classes in the human system
* `A(L)` = interfaces + abstract classes in the LLM system

The faculty definition explicitly uses the number of interfaces and abstract classes for this metric.

---

### Human abstraction count

Selected human files contain:

| Human abstraction | Type      |
| ----------------- | --------- |
| `OwnerRepository` | Interface |
| `VetRepository`   | Interface |

Therefore:

```text
A(H) = 2
```

There are no abstract classes in the selected human snapshot.

---

### LLM abstraction count

The final Iteration-3 contains the following interfaces:

| LLM abstraction   | Type      |
| ----------------- | --------- |
| `EntityFactory`   | Interface |
| `OwnerFactory`    | Interface |
| `OwnerRepository` | Interface |
| `OwnerService`    | Interface |
| `PetFactory`      | Interface |
| `VetFactory`      | Interface |
| `VisitFactory`    | Interface |

Therefore:

```text
A(L) = 7
```

The Iteration-3 commit directly contains these Factory and Service/Repository abstractions.

There are no abstract classes in the selected Iteration-3 files.

---

### Calculation

```text
ALS = (A(H) - A(L)) / A(H)

ALS = (2 - 7) / 2

ALS = -5 / 2

ALS = -2.50
```

### Result

```text
ALS = -2.50
```

or:

```text
-250%
```

### Important interpretation

The negative ALS is **not a calculation error**.

The faculty's formula measures **loss**:

```text
ALS = (Human abstractions - LLM abstractions) / Human abstractions
```

Here:

```text
Human abstractions = 2
LLM abstractions   = 7
```

The LLM system therefore contains **five more abstractions** than the selected human snapshot.

Consequently, the raw formula produces:

```text
ALS = -2.50
```

This should be interpreted as **net abstraction gain rather than abstraction loss**.

In other words:

> The final LLM reconstruction did not merely avoid abstraction loss; within the selected comparison scope, it introduced additional explicit abstraction through Factory and Service interfaces.

This result is particularly important because Iteration 3 was deliberately prompted to introduce explicit Factory abstractions.

---

## 5.4 Final Metric Table

| Metric                              | Formula            |      Human (H) |        LLM (L) | Calculation | Final Result |            |             |         |                 |
| ----------------------------------- | ------------------ | -------------: | -------------: | ----------- | -----------: | ---------- | ----------- | ------- | --------------- |
| **PPR — Pattern Preservation Rate** | `                  |    P(H) ∩ P(L) |              / | P(H)        |            ` | 2 patterns | 2 preserved | `2 / 2` | **1.00 / 100%** |
| **PCR — Pattern Collapse Rate**     | `                  |    P_collapsed |              / | P(H)        |            ` | 2 patterns | 0 collapsed | `0 / 2` | **0.00 / 0%**   |
| **ALS — Abstraction Loss Score**    | `(A(H)-A(L))/A(H)` | 2 abstractions | 7 abstractions | `(2-7)/2`   |    **-2.50** |            |             |         |                 |

---

# 6. Comparative Analysis & Reflection

## 6.1 Human vs. LLM Architecture

| Aspect                      | Human-Written System                       | LLM Iteration 3                                     |
| --------------------------- | ------------------------------------------ | --------------------------------------------------- |
| Main architecture           | Spring-based layered application           | Explicit layered reconstruction                     |
| Singleton                   | Spring-managed Singleton behavior          | Spring-managed Singleton behavior                   |
| Factory                     | Spring IoC/component creation mechanism    | Explicit Factory interfaces + implementations       |
| Factory abstraction         | Implicit/framework-driven                  | Explicit                                            |
| Service abstraction         | Not represented in selected human snapshot | `OwnerService` interface + implementation           |
| Repository abstraction      | `OwnerRepository`, `VetRepository`         | `OwnerRepository` plus service/factory abstractions |
| Explicit interfaces counted | 2                                          | 7                                                   |
| Pattern preservation        | Baseline                                   | **100%**                                            |
| Pattern collapse            | Baseline                                   | **0%**                                              |
| Abstraction change          | 2 abstractions                             | 7 abstractions                                      |

---

## 6.2 What changed across the iterations?

The most important observation is that the LLM did not preserve the final architecture perfectly from the beginning.

### Iteration 1

The model reproduced the functional idea of a Spring veterinary backend but did not explicitly introduce a Factory abstraction.

```text
Functionality preserved
        ↓
Architecture partially preserved
        ↓
Factory abstraction missing
```

### Iteration 2

A more explicit architectural prompt caused the LLM to introduce Factory classes and clearer Controller/Service/Repository separation.

```text
More architectural constraints
        ↓
Better layer separation
        ↓
Factory introduced
        ↓
Factory abstraction still weak
```

### Iteration 3

The prompt explicitly required an interface and concrete Factory implementations.

The resulting system contained:

```text
EntityFactory
      ↓
OwnerFactory / PetFactory / VetFactory / VisitFactory
      ↓
OwnerFactoryImpl / PetFactoryImpl /
VetFactoryImpl / VisitFactoryImpl
```

This made the Factory pattern structurally visible rather than merely implied.

---

## 6.3 Main Structural Insight

The strongest finding from this project is that **prompt specificity directly influenced architectural fidelity**.

The first prompt described mainly what the system should do.

The second prompt described how the system should be layered.

The third prompt described the actual abstractions that needed to exist.

The resulting progression was:

```text
Functional description
        ↓
Layer constraints
        ↓
Pattern + abstraction constraints
        ↓
Higher architectural fidelity
```

This suggests that an LLM is more likely to reproduce architectural structures when those structures are explicitly named and constrained in the prompt.

---

## 6.4 Why Factory preservation improved

The Factory pattern was not explicitly represented in Iteration 1.

Iteration 2 introduced Factory classes, but they were essentially concrete utility-like components.

Iteration 3 explicitly requested:

> a clear Factory interface with concrete implementations

The resulting code actually contains `EntityFactory`, `OwnerFactory`, `PetFactory`, `VetFactory`, and `VisitFactory` interfaces, together with concrete implementations.

Therefore, the final reconstruction moved from:

```text
No explicit Factory
```

to:

```text
Concrete Factory
```

and finally to:

```text
Factory Interface
        ↓
Concrete Factory Implementation
```

This is a clear example of prompt refinement improving structural preservation.

---

## 6.5 Why Singleton was preserved

Singleton preservation was comparatively easier because the behavior is naturally provided by the Spring framework.

Both the human system and the LLM reconstruction use Spring-managed components.

The LLM did not need to manually implement:

```java
private static instance;
```

or:

```java
getInstance();
```

Instead, Singleton behavior was obtained through Spring dependency injection and its default bean scope.

Therefore, Singleton preservation was largely framework-driven rather than manually reconstructed.

---

## 6.6 Important ALS Observation

The ALS result deserves special attention.

```text
A(H) = 2
A(L) = 7

ALS = -2.50
```

At first glance, a negative "loss" score may appear unusual. However, it occurs because the LLM system contains **more explicit abstractions than the selected human snapshot**.

The additional abstractions mainly come from the explicitly requested Factory and Service interfaces.

Therefore:

```text
Negative ALS
      ↓
Not abstraction degradation
      ↓
Net abstraction increase
```

This is an important limitation of interpreting ALS as a pure 0–1 "quality score." The faculty formula measures the **relative change in abstraction count**, so a system with more abstractions can legitimately produce a negative value.

---

# 7. Final Comparison Summary

> **Our study compares human-written Spring PetClinic code with an LLM-reconstructed version produced through three progressively refined prompts. The human system relies on Spring's dependency injection and repository abstractions, with Singleton behavior provided by Spring and Factory-style object creation handled implicitly by the framework. The first LLM reconstruction reproduced the basic functionality but did not introduce an explicit Factory abstraction. The second iteration improved the Controller–Service–Repository separation and introduced Factory classes, while the third iteration explicitly required Factory interfaces, concrete implementations, Singleton services, and stronger architectural separation. As a result, the final reconstruction preserved both identified design patterns, achieving a Pattern Preservation Rate of 100% and a Pattern Collapse Rate of 0%. The abstraction analysis additionally shows that the LLM increased the number of explicit interfaces from 2 in the selected human snapshot to 7 in Iteration 3, producing a raw Abstraction Loss Score of -2.50, which indicates a net abstraction increase rather than abstraction loss. Overall, the Spring PetClinic experiment shows that LLMs can preserve and even make architectural abstractions more explicit when prompts provide clear structural constraints; architectural fidelity therefore depends strongly on how specifically the desired architecture and design patterns are communicated to the model.**

---

# 8. Overall Findings

| Finding                            | Result                            |
| ---------------------------------- | --------------------------------- |
| Human design patterns identified   | **2**                             |
| LLM design patterns preserved      | **2**                             |
| Pattern Preservation Rate          | **100%**                          |
| Pattern Collapse Rate              | **0%**                            |
| Human abstractions                 | **2**                             |
| LLM abstractions                   | **7**                             |
| Abstraction Loss Score             | **-2.50**                         |
| Final architectural direction      | **Improved explicit abstraction** |
| Main factor affecting preservation | **Prompt specificity**            |

### Final conclusion

The experiment demonstrates that LLM-generated software can preserve design patterns when the required architectural structures are explicitly specified.

The progression from Prompt 1 to Prompt 3 is particularly important:

```text
Prompt 1
Functional requirements
        ↓
Partial structural preservation

Prompt 2
Functional + layered architecture
        ↓
Improved separation + Factory classes

Prompt 3
Functional + layers + explicit abstractions
        ↓
Factory interfaces + implementations
+ Singleton services
+ stronger separation
```

Therefore, the final result supports the conclusion that:

> **LLMs are capable of reproducing architectural patterns, but explicit architectural constraints and iterative prompt refinement substantially improve the probability of preserving those patterns.**

---

# 9. Files and Evidence

### Human-written system

* `Original-Codes/PetClinicApplication.java`
* `Original-Codes/OwnerController.java`
* `Original-Codes/PetController.java`
* `Original-Codes/OwnerRepository.java`
* `Original-Codes/VetRepository.java`
* `Original-Codes/Owner.java`
* `Original-Codes/Pet.java`
* `Original-Codes/Vet.java`

### Prompt iterations

* `Prompts/Prompt-1.md`
* `Prompts/Prompt-2.md`
* `Prompts/Prompt-3.md`

### LLM reconstruction

* `Reconstracted-LLM-Codes/Iteration-1/`
* `Reconstracted-LLM-Codes/Iteration-2/`
* `Reconstracted-LLM-Codes/Iteration-3/`

### Supporting documentation

* `Project-Description.md`
* `File-Descriptions.md`
* `LLM-File-Descriptions.md`

---

# 10. References

* Spring PetClinic official repository:
  https://github.com/spring-projects/spring-petclinic

* Student analysis repository:
  https://github.com/FaiazAkram/CSE423-Software-Architecture-Assignment

* Faculty assignment requirements and metric definitions:
  https://github.com/PromaChow/423-Software-Architechture/tree/main/Project

* Final Iteration-3 reconstruction commit:
  `3c7fb28`

---

