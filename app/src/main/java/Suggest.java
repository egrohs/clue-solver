import lombok.Data;

@Data
public class Suggest {
	private Player ask, answer;
	private Card character;
	private Card weapon;
	private Card room;
	private Card show;

	public Suggest(String ask, String answer, Card character, Card weapon, Card room, Card shows) {
		super();
		this.ask = Game.playerByName(ask);
		this.answer = Game.playerByName(answer);
		this.character = character;
		this.weapon = weapon;
		this.room = room;
		this.show = shows;
	}
}