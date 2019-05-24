package com.unimoni.jpa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Constructor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTestDemo {
  @ParameterizedTest
  @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
  void palindromes(String candidate) {
    assertTrue(isPalindrome(candidate));
  }


  @ParameterizedTest
  @EnumSource(TimeUnit.class)
  void testWithEnumSource(TimeUnit timeUnit) {
    assertNotNull(timeUnit);
  }

  @ParameterizedTest
  @MethodSource("stringProvider")
  void testWithExplicitLocalMethodSource(String argument) {
    assertNotNull(argument);
  }

  @ParameterizedTest
  @CsvSource({
      "apple,         1",
      "banana,        2",
      "'lemon, lime', 3"
  })
  void testWithCsvSource(String fruit, int rank) {
    assertNotNull(fruit);
    assertNotEquals(0, rank);
  }



  @ParameterizedTest
  @CsvFileSource(resources = "/two-column.csv", numLinesToSkip = 1)
  void testWithCsvFileSource(String country, int reference) {
    assertNotNull(country);
    assertNotEquals(0, reference);
  }



  @ParameterizedTest
  @ValueSource(strings = { "42 Cats" })
  void testWithImplicitFallbackArgumentConversion(Book book) {
    assertEquals("42 Cats", book.getTitle());

    try {
      Constructor<Book> c =  Book.class.getDeclaredConstructor(String.class);
      c.setAccessible(true);

      Book b = c.newInstance("abc");
      assertEquals(Book.class.getMethod("getTitle").invoke(b), "abc");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  static public class Book {

    private final String title;

    private Book(String title) {
      this.title = title;
    }

    public static Book fromTitle(String title) {
      return new Book(title);
    }

    public String getTitle() {
      return this.title;
    }
  }

  static Stream<String> stringProvider() {
    return Stream.of("apple", "banana");
  }

  public static boolean isPalindrome(String str) {

    String reverse = new StringBuffer(str).reverse().toString();

    if (reverse.equals(str))
      return true;

    return false;
  }
}
