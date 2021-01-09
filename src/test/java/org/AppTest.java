package org;


import org.jobfinder.FinderFactory;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {
    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    void testReflectionMethodFindAllFinders() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FinderFactory finderFactory = new FinderFactory();
        System.out.println(finderFactory.getAllFinders().size());
    }
}
