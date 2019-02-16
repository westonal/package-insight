package io.github.westonal.analysis

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotEquals

class ModuleNameTest {

    @Test
    void assertEqualityContract_Equal() {
        assertEquals(new ModuleName(name: 'A'), new ModuleName(name: 'A'))
    }

    @Test
    void assertEqualityContract_NotEqual() {
        assertNotEquals(new ModuleName(name: 'A'), new ModuleName(name: 'B'))
    }

    @Test
    void immutable() {
        def name = new ModuleName(name: 'A')
        shouldFail {
            //noinspection GrFinalVariableAccess, GroovyAccessibility
            name.name = 'B'
        }
    }
}