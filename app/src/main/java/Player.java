import java.util.List;

import lombok.Data;

@Data
public class Player {
	private String name;
	private List<Card> tem;
	private List<Card> naotem;
	private List<List<Card>> suggests;

	void addSuggest(List<Card> s) {
		suggests.add(s);
	}

	void addTem(Card c) {
		naotem.remove(c);
		for (List<Card> s : suggests) {
			s.remove(c);
		}
		tem.add(c);
	}
	
	void addNTem(Card c) {
		tem.remove(c);
		for (List<Card> s : suggests) {
			s.remove(c);
		}
		naotem.add(c);
	}
}