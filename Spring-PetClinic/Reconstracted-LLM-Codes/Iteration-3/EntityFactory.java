package com.vetclinic.factory;

/**
 * Base abstraction for the Factory design pattern used throughout this
 * codebase: an object solely responsible for turning a persisted entity
 * into the DTO that is exposed on the API. Object-creation concerns
 * (building/updating entities from request DTOs) are declared on the
 * entity-specific sub-interfaces below rather than here, since the
 * required inputs differ per aggregate (some entities need related
 * entities resolved first, e.g. a Pet needs its Owner and PetType).
 * <p>
 * Splitting the contract this way keeps each factory interface focused
 * on exactly the conversions its clients need (Interface Segregation),
 * while still letting every factory be referred to polymorphically via
 * this base type wherever only the read-side conversion is required.
 *
 * @param <E>   the JPA entity type
 * @param <RES> the response DTO type returned to API clients
 */
public interface EntityFactory<E, RES> {

    /**
     * Converts a persisted entity into its outward-facing response DTO.
     */
    RES toResponseDTO(E entity);
}
