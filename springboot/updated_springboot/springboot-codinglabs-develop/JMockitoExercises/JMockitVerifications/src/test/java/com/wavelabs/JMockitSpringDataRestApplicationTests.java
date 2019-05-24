package com.wavelabs;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Tested;
import mockit.Verifications;

public class JMockitSpringDataRestApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Tested private ServiceClass implClass;
    @Mocked private DaoClass mockBaseClass;

    @Test public void testWithoutExplicitMinTimesDeclaration() throws Exception {
        new NonStrictExpectations() {{ mockBaseClass.isRendered(); result = false; }};
        assertThat( implClass.isRendered(), is( false ));
        new Verifications() {{ implClass.generateHiddenFlag(); }};
        // succeeds
    }

    @Test public void testWithExplicitMinTimesDeclaration() throws Exception {
        new NonStrictExpectations() {{ mockBaseClass.isRendered(); result = false; }};
        assertThat( implClass.isRendered(), is( false ));
        new Verifications() {{ implClass.generateHiddenFlag(); minTimes = 1; }};
        // fails: java.lang.IllegalStateException: Missing invocation to mocked type at this point
    }

}

