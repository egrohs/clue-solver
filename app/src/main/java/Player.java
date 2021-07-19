import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
		possiveis.remove(c);
		tem.add(c);
	}

	void addNTem(Card c) {
		tem.remove(c);
		possiveis.remove(c);
		naotem.add(c);
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
}