package com.unimoni.jpa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
// Shared test instance state between test methods in a given test class
// as well as between non-static {@link BeforeAll @BeforeAll} and
// @AfterAll  methods in the test class.
public class ArtistRepoTest {

  @Test
  public void emptyTest() {
  }

  static int localVaribale = 0;

  @BeforeAll
  public static void beforeTest() {
    localVaribale = 100;
  }

  @BeforeEach
  public void beforeEach(){

  }

  @Test
  public void testBeforeAll() {
    assertEquals(localVaribale, 100);
  }

  @Test
  @Disabled("This should be passed though the assert fails.As this test is Disabled.")
  public void testDisabled(){
    assertEquals(1, 100);
  }
}
