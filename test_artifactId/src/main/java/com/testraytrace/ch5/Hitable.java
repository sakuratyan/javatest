package com.testraytrace.ch5;
import com.testraytrace.ch3.*;

/**
 * Hitable
 */
public interface Hitable {

    boolean hit(final Ray r, float t_min, float t_max, HitRecord rec);
}