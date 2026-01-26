/*getName() → Devuelve el nombre del jugador.

getCard() → Devuelve su cartón.

markNumber(number) → Marca un número en el cartón.

checkRow() → Comprueba si tiene una fila completa y actualiza hasRow.

checkBingo() → Comprueba si tiene BINGO completo y actualiza hasBingo.

showCard() → Muestra el cartón por consola o interfaz.*/

package bingocrud;

public class Player {
	private String name; // Nombre del jugador
	private BingoCard card; // Su cartón de Bingo
	private boolean hasRow; // Para saber si ya cantó ROW
	private boolean hasBingo; // Para saber si ya cantó BINGO

	// Constructor de la clase
	public Player(String name, BingoCard card) {
		this.name = name;
		this.card = card;
		this.hasRow = false;
		this.hasBingo = false;
	}

	// Creo que el getName del usuario para controlarlo

	public String getName() {
		return this.name;
	}

	// Creo el getCard que devuelve el Card
	public BingoCard getCard(){
		return card;
	}

	// Creo el set name para darle valor al name
	public void setName(String name) {
		// el name no puede estar vacio
		if (name.isEmpty()) {
			System.out.println("El nombre no puede estar vacio");
		} else {
			this.name = name.trim();
		}
	}

	public void markNumber(int number) {
	    card.markNumber(number);
	}

	// Método que comprueba si hay una fila completa
	public boolean checkRow() {
		if (!hasRow && card.hasRow()) { // Si hay una fila completa devolvemos true
			hasRow = true;
			return true;
		}
		return false; // Si la fila no está completa devolvemos false
	}

	// Método que comprueba si hay un bingo
	public boolean checkBingo() {
		if (!hasBingo && card.hasBingo()) { // Si la matriz está completa devolvemos true
			hasBingo = true;
			return true;
		}
		return false; // Si la matriz no está completa devolvemos false
	}

	@Override
	public String toString() {
		return "Player: " + name + "Card: " + card;
	}
}
