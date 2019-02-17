package io.github.westonal.analysis.graph

import groovy.test.GroovyAssert
import org.junit.Assert
import org.junit.Test

class EdgeTest {

    @Test
    void create() {
        def edge = new Edge<String>("From", "To")
        Assert.assertSame(edge.from, "From")
        Assert.assertSame(edge.to, "To")
    }

    @Test
    void assertEqualityContract_Equal() {
        Assert.assertEquals(new Edge<String>("From", "To"), new Edge<String>("From", "To"))
    }

    @Test
    void assertEqualityContract_NotEqual() {
        Assert.assertNotEquals(new Edge<String>("From", "To"), new Edge<String>("To", "From"))
    }

    @Test
    void immutable() {
        def edge = new Edge<Integer>(1, 2)
        GroovyAssert.shouldFail {
            //noinspection GroovyAccessibility,GrFinalVariableAccess
            edge.from = 3
        }
        GroovyAssert.shouldFail {
            //noinspection GroovyAccessibility,GrFinalVariableAccess
            edge.to = 3
        }
        Assert.assertSame(edge.from, 1)
        Assert.assertSame(edge.to, 2)
    }

    @Test
    void toStringFormat() {
        def edge = new Edge<String>("A", "B")
        Assert.assertEquals("A -> B", edge.toString())
    }
}
