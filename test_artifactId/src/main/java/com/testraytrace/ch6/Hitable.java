package com.testraytrace.ch6;

/**
 * Hitable
 */
public interface Hitable {

    boolean hit(final Ray r, float t_min, float t_max, HitRecord rec);
}