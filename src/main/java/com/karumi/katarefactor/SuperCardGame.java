package com.karumi.katarefactor;

import java.util.HashMap;
import java.util.Map;

public class SuperCardGame {

  private static Map<String, Integer> strength = new HashMap<>();
  private static Map<String, Integer> intelligence = new HashMap<>();
  private static Map<String, Integer> age = new HashMap<>();

  public static void main(String[] args) {
    SuperCardGame superCardGame = new SuperCardGame();
    superCardGame.initCards();
    String matchResult = superCardGame.playGame(args);
    System.out.println(matchResult);
  }

  public String playGame(String[] args) {
    if (args.length < 3) {
      return "Invalid command: SuperCardGame propertyCompare superhero1 superhero2";
    } else {
      String p = args[0];
      if (p.equals("strength")) {
        String card1 = args[1];
        String card2 = args[2];

        Integer value1 = strength.get(card1);
        Integer value2 = strength.get(card2);
        if (value1 == null) {
          return card1 + " not exist";
        }

        if (value2 == null) {
          return card2 + " not exist";
        }

        if (value1 > value2) {
          return card1 + "is more strength than " + card2;
        } else if (value1 == value2) {
          return card1 + "is equals than " + card2;
        } else if (value1 < value2) {
          return card1 + "is less strength than " + card2;
        }
      } else if (p.equals("intelligence")) {
        String card1 = args[1];
        String card2 = args[2];

        Integer value1 = intelligence.get(card1);
        Integer value2 = intelligence.get(card2);
        if (value1 == null) {
          return card1 + " not exist";
        }

        if (value2 == null) {
          return card2 + " not exist";
        }

        if (value1 > value2) {
          return card1 + "is more intelligence than " + card2;
        } else if (value1 == value2) {
          return card1 + "is equals than " + card2;
        } else if (value1 < value2) {
          return card1 + "is less intelligence than " + card2;
        }
      } else if (p.equals("age")) {
        String card1 = args[1];
        String card2 = args[2];

        Integer value1 = age.get(card1);
        Integer value2 = age.get(card2);
        if (value1 == null) {
          return card1 + " not exist";
        }

        if (value2 == null) {
          return card2 + " not exist";
        }

        if (value1 < value2) {
          return card1 + "is younger than " + card2;
        } else if (value1 == value2) {
          return card1 + "is equals than " + card2;
        } else if (value1 > value2) {
          return card1 + "is older than " + card2;
        }
      }
    }
    return "command not found";
  }

  public void initCards() {
    strength.put("Hulk", 10);
    strength.put("Magneto", 8);
    strength.put("Lobezno", 9);
    strength.put("Spiderman", 7);
    strength.put("Ironman", 6);

    intelligence.put("Hulk", 1);
    intelligence.put("Magneto", 8);
    intelligence.put("Lobezno", 6);
    intelligence.put("Spiderman", 5);
    intelligence.put("Ironman", 9);

    age.put("Hulk", 1);
    age.put("Magneto", 8);
    age.put("Lobezno", 6);
    age.put("Spiderman", 5);
    age.put("Ironman", 9);
  }
}