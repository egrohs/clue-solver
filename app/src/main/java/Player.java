import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Player {
	private String name;
	private Set<Card> tem = new HashSet<>();
	private Set<Card> naotem = new HashSet<>();
	private Set<Card> possiveis = new HashSet<>();
	private Player next;

//	void addSuggest(List<Card> s) {
//		possiveis.add(s);
//	}

	void addTem(Card c) {
		naotem.remove(c);
		removePode(c);
		tem.add(c);
	}

	void removePode(Card c) {
		possiveis.remove(c);
		if (possiveis.size() == 1) {
			Game.tem(this, possiveis.iterator().next());
		}
	}

	void addNTem(Card c) {
		tem.remove(c);
		removePode(c);
		naotem.add(c);
	}

	public void addPode(Card c) {
		possiveis.add(c);
		if (possiveis.size() == 1) {
			Game.tem(this, possiveis.iterator().next());
		}
	}

	public Player(int i) {
		this.name = "" + i;
	}

	public boolean nTem(Card c) {
		return naotem.contains(c);
	}

	public void addNTem(Set<Card> cs) {
		for (Card c : cs) {
			addNTem(c);
		}
	}

	@Override
	public String toString() {
		return getName() + " T= " + getTem() + " N= " + getNaotem() + " P= " + getPossiveis();
	}
}