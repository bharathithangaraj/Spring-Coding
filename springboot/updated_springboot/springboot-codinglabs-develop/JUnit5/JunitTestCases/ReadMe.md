Junit 5
Introduction :
Junit is widely used testing framework along with Java Programming Language. You can use this automation framework for both unit testing and UI testing.It helps us define the flow of execution of our code with different Annotations.It also gives test runners for running tests effectively
Writing Tests :
Annotations :
1.@Test :
If you want to test any method from the class you can use @Test annotation it Denotes that a method is a test method,whatever you want to test you can insert in this method.

Example source code to test:
package annotationsDemo;

public class MyMath {
	
	    int sum(int[] numbers) {

	        int sum = 0;

	        for (int i: numbers) {

	            sum += i;

	        }

	        return sum;

	    }

	}

Unit test for the sum method:
package annotationsDemo;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

import org.junit.BeforeClass;
import org.junit.Test;
public class MyMathTest {
    MyMath myMath = new MyMath();
    // MyMath.sum
    // 1,2,3 => 6
    @Test
    public void sum_with3numbers() {
        System.out.println("Test1");
        assertEquals(6, myMath.sum(new int[] {
            1,
            2,
            3
        }));
    }
    @Test
    public void sum_with1number() {
        System.out.println("Test2");
        assertEquals(3, myMath.sum(new int[] {
            3
        }));
    }
}
2.@Before :
@Before annotation is used on a method containing Java code to run before each test case. i.e it runs before each test execution. 
All the methods annotated with @Before will run before each test case, but they may run in any order.

3.@After :
@After annotation is used on a method containing java code to run after each test case.These methods will run even if any exceptions are thrown in the test case or in the case of assertion failure.
Find the Below Sample code :
package annotationsDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class DemoTest {

	
	@Before
	public  void beforeClass() {
		System.out.println("Before");
	
	}
	@After
	public  void afterClass() {
		System.out.println("After");
	
}
	@Test
	public void test1() {
		System.out.println("First");
	}
	@Test
	public void test2() {
		System.out.println("Second");
	}

}

Test Result :
Before
First
After
Second

Note:

* First @Before method will be executed then test1 and then test2 then @After will be executed.
* If you use @Before and @After annotations,which will be executed for each and every Test method

4.@BeforeClass @AfterClass annotations   :
Static methods which are executed only once before and after a test class.These annotations are used to initialize the objects.

Find the Below Sample code :
package annotationsDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class DemoTest {

	static Demo demo=null;
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	demo=new Demo();
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	demo=null;
}
	@Test
	public void test1() {
		System.out.println("First");
	}
	@Test
	public void test2() {
		System.out.println("Second");
	}

}

Test Result :
Before Class
First
Second
After Class

Note :
-> first @BeforeClass will be executed then Test methods and then @AfterClass will be executed.
-> @BeforeClass ,@AfterClass annotations will executed only once.

Display Names :
public @interface DisplayName
Test classes and test methods can declare custom display names — with spaces, special characters, and even emojis — that will be displayed by test runners and test reporting.
Find the below Example :
@DisplayName("This method is going to test the Product class")
class DeviceRepositoryTest {




private DeviceRepository deviceRepo;

@DisplayName("This method is going to test the our Test method")
	@Test
	public void testGetDevice() {
		deviceRepo = new DeviceRepository();
		
		Device d2 = new Device("5","Mac","");
		deviceRepo.addDevice(d2);
		Device d2copy = deviceRepo.getDevice("5");
		assertNotSame(d2copy,d2);
	}
@DisplayName("This method is going to test the our Test method")
	@Test
	public void testAddDevice() {
		DeviceRepository deviceRepo = new DeviceRepository();
		
		Device d1 = deviceRepo.addDevice(new Device("5","Mac",""));
		
		assertEquals(d1.getDeviceName(), "Mac");
	}


Assertions:
Assertions are utility methods to support asserting conditions in tests; these methods are accessible through the Assert class, in JUnit 4, and the Assertions one,in JUnit 5.
In order to increase the readability of the test and of the assertions itself, it’s always recommended to import statically the respective class. In this way, we can refer directly to the assertion method itself without the representing class as a prefix.
1.assertEquals :
The assertEquals assertion verifies that the expected and the actual values are equal.
@Test
public void whenAssertingEquality_thenEqual() {
String expected = "Baeldung";
String actual = "Baeldung";
assertEquals(expected, actual);
}

Test result :
success with no errors

It’s also possible to specify a message to display when the assertion fails:

assertEquals("failure - strings are not equal", expected, actual);

2.assertArrayEquals:
The assertArrayEquals assertion verifies that the expected and the actual arrays are equals.
@Test
public void whenAssertingArraysEquality_thenEqual() {
char[] expected = { 'J', 'u', 'p', 'i', 't', 'e', 'r' };
char[] actual = "Jupiter".toCharArray();


assertArrayEquals(expected, actual, "Arrays should be equal");
}

Test Result:
success with no errors.

3.assertTrue and assertFalse :
With the assertTrue assertion, it’s possible to verify the supplied conditions are true.
@Test
public void whenAssertingConditions_thenVerified() {
assertTrue(5 > 4, "5 is greater the 4");
assertTrue(null == null, "null is equal to null");
}

Test Result :
success with no errors.
it’s possible to supply a BooleanSupplier to the assertion instead of a boolean condition.
Let’s see how we can assert the correctness of a BooleanSupplier using the assertFalse assertion:
@Test
public void givenBooleanSupplier_whenAssertingCondition_thenVerified() {
BooleanSupplier condition = () -> 5 > 6;
assertFalse(condition, "5 is not greater then 6");
}

Test Result :
success with no errors.
4.assertAll:
One of the new assertion introduced in JUnit 5 is assertAll.
This assertion allows the creation of grouped assertions, where all the assertions are executed and their failures are reported together. In details, this assertion accepts a heading, that will be included in the message string for the MultipleFailureError, and a Stream of Executable.
Let’s define a grouped assertion:



@Test
public void givenMultipleAssertion_whenAssertingAll_thenOK() {
assertAll(
"heading",
() -> assertEquals(4, 2 * 2, "4 is 2 times 2"),
() -> assertEquals("java", "JAVA".toLowerCase()),
() -> assertEquals(null, null, "null is equal to null"));}

Note :
The execution of a grouped assertion is interrupted only when one of the executables throws a blacklisted exception (OutOfMemoryError for example).
Assumptions :
JUnit 5 Assumptions class provides static methods to support conditional test execution based on assumptions. A failed assumption results in a test being aborted. Assumptions are typically used whenever it does not make sense to continue execution of a given test method. In test report, these test will be marked as passed.
Assumtions class has two methods :
assumeTrue()
assumeFalse()
assumeTrue() validates the given assumption to true and if assumption is true – test proceed, otherwise test execution is aborted.
assumeFalse() validates the given assumption to false and if assumption is false – test proceed, otherwise test execution is aborted. It works just opposite to assumeTrue().
Find the below sample test code :	
    @Test
	public void getStudentInfo() {
    	info = new StudentInfo();
		info.setPassportNumber("P345J34");
		info.setName("John");
		
        assumeTrue("John".equals(info.getName()));
        
        assumeTrue("P345J34".equals(info.getPassportNumber()));
	}
Disabling Tests :
Entire test classes or individual test methods may be disabled via the @Disabled annotation,
Here’s a @Disabled test class.

And here’s a test class that contains a @Disabled test method.




@DisplayName("This method will not be tested..it's disabled!!")
    @Disabled
	@Test
	void whenAssertingSameInfo_thenSuccessful()
    	{
    	std=new StudentInfo(1,"Alex");
    	
    		assertSame("ALex",std.getStudentName());
    		System.out.println("This method will not be tested..it's disabled!!");
	}
Conditional Test Execution :
The ExecutionCondition extension API in JUnit Jupiter allows developers to either enable or disable a container or test based on certain conditions programmatically. The simplest example of such a condition is the built-in DisabledCondition which supports the @Disabled annotation.In addition to @Disabled, JUnit Jupiter also supports several other annotation-based conditions in the org.junit.jupiter.api.condition package that allow developers to enable or disable containers and tests declaratively. See the following sections for details.
Example :
Java Runtime Environment Conditions :
A container or test may be enabled or disabled on a particular version of the Java Runtime Environment (JRE) via the @EnabledOnJre and @DisabledOnJre annotations.
@Test
@EnabledOnJre(JAVA_8)
void onlyOnJava8() {
    // ...
}

@Test
@EnabledOnJre({ JAVA_9, JAVA_10 })
void onJava9Or10() {
    // ...
}

@Test
@DisabledOnJre(JAVA_9)
void notOnJava9() {
    // ...
}

Tagging and Filtering : 
@Tag is used to Used to declare tags for filtering tests, either at the class or method level; Such annotations are inherited at the class level but not at the method level.
Syntax Rules for Tags
    • A tag must not be null or blank.
    • A trimmed tag must not contain whitespace.
    • A trimmed tag must not contain ISO control characters.
    • A trimmed tag must not contain any of the following reserved characters.
        ◦ ,: comma
        ◦ (: left parenthesis
        ◦ ): right parenthesis
        ◦ &: ampersand
        ◦ |: vertical bar
        ◦ !: exclamation point
Note :In the above context, "trimmed" means that leading and trailing whitespace characters have been removed. 
Example :
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fast")
@Tag("model")
class TaggingDemo {

    @Test
    @Tag("taxes")
    void testingTaxCalculation() {
    }

}
Test Instance Lifecycle :
In order to allow individual test methods to be executed in isolation and to avoid unexpected side effects due to mutable test instance state, JUnit creates a new instance of each test class before executing each test method. This "per-method" test instance lifecycle is the default behavior in JUnit Jupiter and is analogous to all previous versions of Junit.
Note :
Please note that the test class will still be instantiated if a given test method is disabled via a condition (e.g., @Disabled, @DisabledOnOs, etc.) even when the "per-method" test instance lifecycle mode is active. 
If you would prefer that JUnit Jupiter execute all test methods on the same test instance, simply annotate your test class with @TestInstance(Lifecycle.PER_CLASS). When using this mode, a new test instance will be created once per test class. Thus, if your test methods rely on state stored in instance variables, you may need to reset that state in @BeforeEach or @AfterEach methods.
The "per-class" mode has some additional benefits over the default "per-method" mode. Specifically, with the "per-class" mode it becomes possible to declare @BeforeAll and @AfterAll on non-static methods as well as on interface default methods. The "per-class" mode therefore also makes it possible to use @BeforeAll and @AfterAll methods in @Nested test classes.
If you are authoring tests using the Kotlin programming language, you may also find it easier to implement @BeforeAll and @AfterAll methods by switching to the "per-class" test instance lifecycle mode.
Nested Tests :
Nested tests give the test writer more capabilities to express the relationship among several groups of tests.
JUnit Jupiter @Nested annotation can be used to mark a nested class to be included in the test cases. When JUnit tests are executed, Nested classes are not scanned for test methods. We can explicitly mark them to be scanned for test cases using @Nested annotation.
Example :

@DisplayName("This will test the Nested testcases")
	@Test
	void whenAssertingSameInfo_thenSuccessful()
	{
	std=new StudentInfo(1,"smith");
	
		assertSame("smith",std.getStudentName());
	}  
 @Nested
 class Student {
	 
	 @Test
	 void InnerClass_Test() {
		 System.out.println("inner class test");
		 
	 }
JUnit Nested Tests Callback Methods
Nested test classes can have their own @BeforeEach and @AfterEach methods. However, if outer class @BeforeEach and @AfterEach methods will also get executed for nested class tests. Let’s extend our example to confirm this behavior.               
Repeated Tests :
It provides us with a powerful way to write any test that we want to repeat several times.
Example source code to test:
@DisplayName("This will test the Repeated Testcases")
class RepeatedTestCase {
	@RepeatedTest(2)
	void repeatedTest() {
	System.out.println("Executing repeated test");
	}
	
	@BeforeEach
	void beforeEachTest() {
	    System.out.println("Before Each Test");
	}

	@AfterEach
	void afterEachTest() {
	    System.out.println("After Each Test");
	   
	}

Parameterized Tests :
Parameterized tests make it possible to run a test multiple times with different arguments. They are declared just like regular @Test methods but use the @ParameterizedTest annotation instead. In addition, you must declare at least one source that will provide the arguments for each invocation and then consume the arguments in the test method.
The following example demonstrates a parameterized test that uses the @ValueSource annotation to specify a String array as the source of arguments.
Steps to write Parameterized Tests :
If our test method takes only one method parameter that is either a String or a primitive type supported by the @ValueSource annotation (int, long, or double), we can write a parameterized test with JUnit 5 by following these steps:
    1. Add a new test method to our test class and ensure that this method takes a String object as a method parameter.
    2. Configure the display name of the test method.
    3. Annotate the test method with the @ParameterizedTest annotation. This annotation identifies parameterized test methods.
    4. Provide the method parameters that are passed to our test method. Because our test method takes one String object as a method parameter, we can provide its method parameters by annotating our test method with the @ValueSource annotation.

Find the below Sample code :
example :1
@DisplayName("Pass the method parameters provided by the @ValueSource annotation")
class ValueSourceExampleTest {
@DisplayName("Should pass a non-null message to our test method")
@ParameterizedTest
@ValueSource(strings = {"Hello", "World"})
	void shouldPassNonNullMessageAsMethodParameter(String message) {
	assertNotNull(message);
}

example :2
@DisplayName("This will test the Parameterized testcase")
	@ParameterizedTest
	@ValueSource(ints = { 3, 6, 15})
	void divisibleByThree(int number) {
	    assertEquals(0, number % 3);
	}
When and why?
While testing, it is common to run a series of tests which differ only by input values and expected results. We could write separate tests for separate cases but that would result in a lot of code duplication.
We can execute the same test several times using different input using a parameterized test. To do that, we add some parameters to a test method and run it with different variations of parameter values.
Usually we first make sure that the code handles the happy happy path. We can use parameterized tests to ensure the edge cases also work. Parameterization helps making sure that empty, null, zero, and other kinds of boundary conditions work as well.
It is worth mentioning that we shouldn’t necessarily start with parameterized tests in mind when writing tests. Instead, we can think of parameterization as a way to refactor test code to remove duplication.
Dynamic Tests :
which is generated at runtime by a factory method that is annotated with @TestFactory.In contrast to @Test methods, a @TestFactory method is not itself a test case but rather a factory for test cases. Thus, a dynamic test is the product of a factory. @TestFactory method must return a Stream, Collection, Iterable, Iterator, or array of DynamicNode instances.
Parallel Execution :
This is an experimental feature of JUnit 5 and it will come from after JUnit 5.3. To enable parallel execution, simply set the junit.jupiter.execution.parallel.enabled configuration parameter to true in junit-platform.properties file.
Once parallel test execution property is enabled, the JUnit Jupiter engine will execute tests in parallel according to the provided configuration with declared  synchronization  mechanisms.
Configuration :
Properties like the desired parallelism and the maximum pool size can be configured using a ParallelExecutionConfigurationStrategy. The JUnit Platform provides two implementations out of the box: dynamic and fixed. Alternatively, you may implement a custom strategy.

To select a strategy, simply set the junit.jupiter.execution.parallel.config.strategy configuration parameter to one of the following options:
dynamic 
Computes the desired parallelism based on the number of available processors/cores multiplied by the junit.jupiter.execution.parallel.config.dynamic.factor configuration parameter
fixed 
Uses the mandatory junit.jupiter.execution.parallel.config.fixed.parallelism configuration parameter as desired parallelism.
custom 
Allows to specify a custom ParallelExecutionConfigurationStrategy implementation via the mandatory junit.jupiter.execution.parallel.config.custom.class configuration parameter to determine the desired configuration.

@Test
    void sabra() throws InterruptedException {
        Thread.sleep(10000);
        String name = Thread.currentThread().getName();
        threadNames.add(name);
        System.out.println("SABRA! " + name);
    }
    @Test
	void name() throws InterruptedException {
			System.out.println("one more! "+Thread.currentThread().getName());
			Thread.sleep(10000);
	}

TestSuites :
	Using JUnit 5 test suites, you can run tests spread into multiple test classes and different packages. JUnit 5 provides two annotations: @SelectPackages and @SelectClasses to create test suites. Additionally, you can use other annotations for filtering test packages, classes or even test methods.

Find the below code to create the test suite  :
package com.junit.testSuite;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
@RunWith(JUnitPlatform.class)
@SelectPackages({"com.junit.assertions",
	"com.junit.assumptions",
	"com.junit.nestedTestCase",
	"com.junit.parallelExecution",
	"com.junit.displayName",
	"com.junit.testAssertions",
	"com.junit.testAssumptions",
	"com.junit.testDisabledTestCase",
	"com.junit.testDisplayName",
	"com.junit.testNestedTestCase",
	"com.junit.testParallelExecutionTestCases",
	"com.junit.testParameterizedTestCase",
	"com.junit.testRepeatedTestCase",
	"com.junit.testAssertions",
	"com.junit.testParallelExecution"})
public class TestSuite {
}
Running Tests :
1.IDE Support :
	IntelliJ IDEA
	Eclipse
2.Build Support :
	Gradle: Starting with version 4.6 Gradle provides native support for executing tests on the JUnit Platform. To enable it, you just need to specify useJUnitPlatform() within a test task declaration in build.gradle:
test {
    useJUnitPlatform()
}
Configuring Test Engines :
In order to run any tests at all, a TestEngine implementation must be on the classpath.
To configure support for JUnit Jupiter based tests, configure a testCompile dependency on the JUnit Jupiter API and a testRuntime dependency on the JUnit Jupiter TestEngine implementation similar to the following.
dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:5.3.2")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.3.2")
}
	Maven: Starting with version 2.22.0, Maven Surefire provides native support for executing tests on the JUnit Platform. The pom.xml file in the junit5-jupiter-starter-maven project demonstrates how to use it and can serve as a starting point for configuring your Maven build.
Configuring Test Engines :
In order to have Maven Surefire run any tests at all, at least one TestEngine implementation must be added to the test classpath.
To configure support for JUnit Jupiter based tests, configure test scoped dependencies on the JUnit Jupiter API and the JUnit Jupiter TestEngine implementation similar to the following.

<build>
    <plugins>
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.0</version>
        </plugin>
    </plugins>

</build>
...
<dependencies>
    ...
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.3.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.3.2</version>
        <scope>test</scope>
    </dependency>
    ...
</dependencies>
...
Filtering by Tags :
You can filter tests by tags or tag expressions using the following configuration properties.
    • to include tags or tag expressions, use groups.
    • to exclude tags or tag expressions, use excludedGroups.
...
<build>
    <plugins>
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.0</version>
            <configuration>
                <groups>acceptance | !feature-a</groups>
                <excludedGroups>integration, regression</excludedGroups>
            </configuration>
        </plugin>
    </plugins>
</build>
...
	ANT : Starting with version 1.10.3 of Ant a new junitlauncher task has been introduced to provide native support for launching tests on the JUnit Platform. The junitlauncher task is solely responsible for launching the JUnit Platform and passing it the selected collection of tests. The JUnit Platform then delegates to registered test engines to discover and execute the tests.
The junitlauncher task attempts to align as close as possible with native Ant constructs such as resource collections for allowing users to select the tests that they want executed by test engines. This gives the task a consistent and natural feel when compared to many other core Ant tasks.
The build.xml file in the junit5-jupiter-starter-ant project demonstrates how to use it and can serve as a starting point.
Console Launcher :
The Console Launcher is a command-line Java application that lets you launch the JUnit Platform from the console. For example, it can be used to run JUnit Vintage and JUnit Jupiter tests and print test execution results to the console.
An executable junit-platform-console-standalone-1.3.2.jar with all dependencies included is published in the central Maven repository.


