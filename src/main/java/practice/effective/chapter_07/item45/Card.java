package practice.effective.chapter_07.item45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Card {

  public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

  public enum Rank { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

  private final Suit suit;

  private final Rank rank;

  @Override
  public String toString() {
    return "Card{" +
      "suit=" + suit +
      ", rank=" + rank +
      '}';
  }

  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  private static final List<Card> NEW_DECK = newDeck();

  // 데카르트 곱 계산을 반복 방식으로 구현
  private static List<Card> newDeck() {
    List<Card> result = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        result.add(new Card(suit, rank));
      }
    }

    return result;
  }

  // 데카르트 곱 계산을 스트림 방식으로 구현. 스트림 사용하기엔 좀 애매..
  private static List<Card> newDeckStream() {
    return Stream.of(Suit.values())
      .flatMap(suit ->
        Stream.of(Rank.values())
          .map(rank -> new Card(suit, rank)))
      .toList();
  }
}
