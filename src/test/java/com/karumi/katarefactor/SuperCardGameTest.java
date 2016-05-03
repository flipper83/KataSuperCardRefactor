package com.karumi.katarefactor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SuperCardGameTest {
  private static final String INVALID_COMMAND = "invalid command";
  private static final String ANY_CARD = "any card";
  private static final String RESULT_INVALID_PARAMS =
      "Invalid command: SuperCardGame propertyCompare superhero1 superhero2";
  private static final String RESULT_INVALID_COMMAND = "command not found";
  private static final String COMMAND_STRENGTH = "strength";
  private static final String HULK_CARD = "Hulk";
  private static final String INVALID_CARD = "Invalid";
  private static final String RESULT_INVALID_CARD = " not exist";
  private static final String LOBEZNO_CARD = "Lobezno";
  public static final String IS_MORE_STRENGTH_THAN = "is more strength than ";
  public static final String IS_EQUALS_THAN = "is equals than ";
  public static final String IS_LESS_STRENGTH_THAN = "is less strength than ";

  @Test
  public void shouldReturnInvalidNumberOfParamsWhenParamsIsLessThanThree() {
    SuperCardGame superCardGame = new SuperCardGame();
    superCardGame.initCards();
    String[] invalidArgs = givenOnlyTwoArgs();

    String gameResult = superCardGame.playGame(invalidArgs);

    assertEquals(RESULT_INVALID_PARAMS, gameResult);
  }

  @Test
  public void shouldReturnInvalidCommandWhenCommandNotExist() {
    SuperCardGame superCardGame = new SuperCardGame();
    superCardGame.initCards();
    String[] invalidArgs = givenEntryArgs(INVALID_COMMAND, ANY_CARD, ANY_CARD);

    String gameResult = superCardGame.playGame(invalidArgs);

    assertEquals(RESULT_INVALID_COMMAND, gameResult);
  }

  @Test
  public void shouldReturnInvalidCardOneWhenCardOneNotExist() {
    SuperCardGame superCardGame = new SuperCardGame();
    superCardGame.initCards();
    String[] invalidArgs = givenEntryArgs(COMMAND_STRENGTH, HULK_CARD, INVALID_CARD);

    String gameResult = superCardGame.playGame(invalidArgs);

    assertEquals(INVALID_CARD + RESULT_INVALID_CARD, gameResult);
  }

  @Test
  public void shouldReturnInvalidCardTwoWhenCardTwoNotExist() {
    SuperCardGame superCardGame = new SuperCardGame();
    superCardGame.initCards();
    String[] invalidArgs = givenEntryArgs(COMMAND_STRENGTH, INVALID_CARD, HULK_CARD);

    String gameResult = superCardGame.playGame(invalidArgs);

    assertEquals(INVALID_CARD + RESULT_INVALID_CARD, gameResult);
  }

  @Test
  public void shouldReturnCardOneIsStrongerThatTwoWhenCardOneValueIsStrongerThanTwo() {
    SuperCardGame superCardGame = new SuperCardGame();
    superCardGame.initCards();
    String[] invalidArgs = givenEntryArgs(COMMAND_STRENGTH, HULK_CARD, LOBEZNO_CARD);

    String gameResult = superCardGame.playGame(invalidArgs);

    assertEquals(HULK_CARD  + IS_MORE_STRENGTH_THAN + LOBEZNO_CARD, gameResult);
  }

  @Test
  public void shouldReturnCardOneIsEqualsThatTwoWhenCardOneValueIsEqualsThanTwo() {
    SuperCardGame superCardGame = new SuperCardGame();
    superCardGame.initCards();
    String[] invalidArgs = givenEntryArgs(COMMAND_STRENGTH, HULK_CARD, HULK_CARD);

    String gameResult = superCardGame.playGame(invalidArgs);

    assertEquals(HULK_CARD  + IS_EQUALS_THAN + HULK_CARD, gameResult);
  }

  @Test
  public void shouldReturnCardOneIsLessThatTwoWhenCardOneValueIsLessThanTwo() {
    SuperCardGame superCardGame = new SuperCardGame();
    superCardGame.initCards();
    String[] invalidArgs = givenEntryArgs(COMMAND_STRENGTH, LOBEZNO_CARD, HULK_CARD);

    String gameResult = superCardGame.playGame(invalidArgs);

    assertEquals(LOBEZNO_CARD + IS_LESS_STRENGTH_THAN + HULK_CARD, gameResult);
  }

  private String[] givenEntryArgs(String... args) {
    return args;
  }

  private String[] givenOnlyTwoArgs() {
    return new String[] {"invalid", "invalid2"};
  }
}