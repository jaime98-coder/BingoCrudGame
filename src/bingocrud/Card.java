package bingocrud;

import java.util.Random;

public class Card {
    // Tu matriz y tu objeto Random
    int[][] card = new int[3][5];
    Random rd = new Random();

    // Constructor: Rellenamos la carta nada más crearla
    public Card() {
        fillCard();
    }

    // Generar número (lo hago private porque es de uso interno)
    private int generateNumber() {
        int cardNumber;
        // nextInt(1, 100) genera del 1 al 99
        cardNumber = rd.nextInt(1, 100); 
        return cardNumber;
    }

    // Rellenar la matriz sin repetidos
    public void fillCard() {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                
                int num;
                boolean repetido;

                do {
                    num = generateNumber();
                    repetido = false; // Asumimos que es nuevo

                    // Recorremos toda la matriz para ver si ya existe ese 'num'
                    for (int r = 0; r < card.length; r++) {
                        for (int c = 0; c < card[r].length; c++) {
                            if (card[r][c] == num) {
                                repetido = true; // ¡Lo encontramos! Está repetido
                            }
                        }
                    }
                    // Si 'repetido' es true, el while se repite y busca otro número
                } while (repetido);

                // Si llegamos aquí es que es único, lo guardamos
                card[i][j] = num;
            }
        }
    }

    // Mostrar carta
    public void showCard() {
        System.out.println("┌──────────────────────────────┐");
        for (int i = 0; i < card.length; i++) {
            System.out.print("│ "); // Borde izquierdo
            for (int j = 0; j < card[i].length; j++) {
                
                // Si es -1 mostramos una X, si no, mostramos el número
                if (card[i][j] == -1) {
                    System.out.print(" X \t");
                } else {
                    // El condicional es para poner un 0 delante si es menor de 10 (estética)
                    System.out.print((card[i][j] < 10 ? "0" : "") + card[i][j] + "\t");
                }
                
            }
            System.out.println("│"); // Borde derecho y salto de línea
        }
        System.out.println("└──────────────────────────────┘");
    }

    // --- MÉTODOS NECESARIOS PARA QUE EL JUEGO FUNCIONE ---

    // 1. Tachar número
    public boolean markNumber(int number) {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] == number) {
                    card[i][j] = -1; // Marcamos con -1
                    return true;
                }
            }
        }
        return false;
    }

    // 2. Comprobar Línea
    public boolean checkLine() {
        for (int i = 0; i < card.length; i++) {
            int contador = 0;
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] == -1) {
                    contador++;
                }
            }
            if (contador == 5) return true; // Fila completa
        }
        return false;
    }

    // 3. Comprobar Bingo
    public boolean checkBingo() {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] != -1) return false;
            }
        }
        return true;
    }
}