package com.knausrr.Knausrr.entities.dtos;

/**
 * @author breath
 * exposure levels restrict the amount of data transferred to the client over DTOs
 */
public enum ExposureLevel {
    /**
     *   MINIMAL - only essential members
     *   EXTENDED - all members including their components (e.g. the whole data of a collection)
     *   COMPLETE - all members but only PKs of references (e.g. a list of products in a store may be reduced to a list of the product's IDs)
     *   STANDARD - all members, excluding references
     *   FAST - individually defined, limits the response size (might exclude images/long descriptions or shorten texts/collections [nice for previews])
     */
    MINIMAL, EXTENDED, COMPLETE, STANDARD, FAST
}
