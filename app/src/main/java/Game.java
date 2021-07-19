import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Game {
	public Game(int qntPlayers) {
		// confidential
		Player last = null;
		players.add(new Player(0));
		// vez=new Player(1);
		for (int n = 0; n < qntPlayers; n++) {
			Player novo = new Player(n + 1);
			if (players.size() > 1) {
				last.setNext(novo);
			}
			players.add(novo);
			last = novo;
		}
		last.setNext(players.get(1));
	}

	public void tem(Player p, Card c) {
		players.forEach(p1 -> p1.addNTem(c));
		p.addTem(c);
	}

	public void tem(String name, Card c) {
		players.forEach(p -> p.addNTem(c));
		playerByName(name).addTem(c);
	}

	private void podeTer(Player p, Suggest s) {
		if (!p.getTem().contains(s.getCharacter()) && !p.getNaotem().contains(s.getCharacter())) {
			p.getPossiveis().add(s.getCharacter());
		}
		if (!p.getTem().contains(s.getWeapon()) && !p.getNaotem().contains(s.getWeapon())) {
			p.getPossiveis().add(s.getWeapon());
		}
		if (!p.getTem().contains(s.getRoom()) && !p.getNaotem().contains(s.getRoom())) {
			p.getPossiveis().add(s.getRoom());
		}
	}

	public static Player playerByName(String name) {
		return players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
	}

	public static List<Player> players = new ArrayList<>();
	private Player vez;
	private List<Suggest> sugests = new ArrayList<>();

	public void addSuggest(Suggest suggest) {
		sugests.add(suggest);
		// os que passaram nao tem as cartas
		Player p = suggest.getAsk().getNext();
		while (p != suggest.getAnswer()) {
			p.addNTem(suggest.getCharacter());
			p.addNTem(suggest.getWeapon());
			p.addNTem(suggest.getRoom());
			p = p.getNext();
		}
		// players.stream().filter(p -> p != suggest.getAsk() && p !=
		if (suggest.getShow() != null) {
			tem(suggest.getAnswer(), suggest.getShow());
		} else {
			podeTer(suggest.getAnswer(), suggest);
		}
		//TODO qndo provaveis fica com 1 elemento é pq ele tem ele.
	}

	public void marca(String name, Set<Card> cs) {
		Player p = playerByName(name);
		players.forEach(p1 -> p1.addNTem(cs));
		Arrays.asList(Card.values()).forEach(p::addNTem);
		cs.forEach(p::addTem);
	}
}