package io.github.westonal.analysis

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotEquals

class PackageNameTest {

    @Test
    void assertEqualityContract_Equal() {
        assertEquals(new PackageName(name: 'A'), new PackageName(name: 'A'))

    }

    @Test
    void assertEqualityContract_NotEqual() {
        assertNotEquals(new PackageName(name: 'A'), new PackageName(name: 'B'))
    }

    @Test
    void immutable() {
        def name = new PackageName(name: 'A')
        shouldFail {
            //noinspection GrFinalVariableAccess, GroovyAccessibility
            name.name = 'B'
        }
    }

    @Test
    void toStringFormat() {
        assertEquals('a', new PackageName(name: 'a').toString())
    }
}