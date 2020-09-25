package view;

import java.util.concurrent.Semaphore;

import controller.F1bolado;
			public class Principal {

				public static void main(String[] args) {
					int permissaoPista = 5;
					int permissaoTabela = 1;

					Semaphore Pista = new Semaphore(permissaoPista);
					Semaphore[] Escuderia = new Semaphore[8];
					Semaphore Tabela = new Semaphore(permissaoTabela);

					for (int idEscuderia = 1; idEscuderia <= 7; idEscuderia++) {
						Escuderia[idEscuderia] = new Semaphore(1);
						for (int idCarro = 1; idCarro < 3; idCarro++) {
							Thread treino = new F1bolado(idCarro, idEscuderia, Pista, Tabela, Escuderia[idEscuderia]);
							treino.start();
						}
					}

				}

			}
