package org.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for auto initialized fields
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInjectable {
}
