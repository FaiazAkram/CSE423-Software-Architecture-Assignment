# Spring PetClinic – LLM Reconstruction Iteration 2

## Overview

This is the second LLM reconstruction of the Spring PetClinic veterinary clinic backend. This iteration improves the architectural separation of the first reconstruction.

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
