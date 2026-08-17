# LLM Prompt Iterations

This document contains the three prompts used to reconstruct the Spring PetClinic backend with Claude. Each iteration was refined based on the architectural limitations observed in the previous reconstruction.

---

## Prompt 1 – Initial Reconstruction

### Purpose

The first prompt provides only the basic system requirements without explicitly specifying architectural layers or design patterns. This establishes the baseline LLM reconstruction.

### Result

The reconstruction provided the basic veterinary clinic functionality and Spring Boot components, but it did not explicitly preserve a Factory abstraction or specify detailed architectural separation.

---

## Prompt 2 – Layered Architecture and Factory

### Reason for Refinement

The first reconstruction did not explicitly preserve the Factory abstraction, and the architectural separation needed to be strengthened.

### Result

The second reconstruction introduced clearer Controller, Service, Repository, and Entity separation and added dedicated Factory classes for entity and DTO creation/mapping.

---

## Prompt 3 – Factory Abstraction and Singleton

### Reason for Refinement

The second reconstruction introduced Factory classes, but they were concrete utility-like classes without a clear Factory abstraction. Singleton behavior was also implicit through Spring's default singleton scope.

### Result

The third reconstruction introduced explicit Factory interfaces and concrete Factory implementations while preserving the layered architecture and Spring-managed Singleton services.

---

## Iterative Refinement Summary

| Iteration | Main Focus | Main Improvement |
|-----------|------------|------------------|
| Prompt 1 | Basic reconstruction | Established baseline system |
| Prompt 2 | Architecture + Factory | Added layered separation and Factory classes |
| Prompt 3 | Pattern abstraction | Added Factory interfaces and concrete implementations |

## Overall Progress

```text
Prompt 1
Basic Reconstruction
       ↓
Prompt 2
Layered Architecture + Factory
       ↓
Prompt 3
Factory Abstraction + Singleton + SOLID
