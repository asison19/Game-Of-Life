import java.util.Random;

public class GameOfLife {
	public static void main(String[] args) {
		int M = 20;
		int N = 25;
		int sleepAmount = 1000;
		
		int[][] cells = new int[M][N];
		CellThread[][] cellThreads = new CellThread[M][N];
		
		createLiveCells(cells);
		
		//create cell threads
		for(int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				cellThreads[i][j] = new CellThread(M, N, i, j, cells, sleepAmount);
				cellThreads[i][j].start();
			}
		}
		
		boolean alive = true;
		do {
			try {
				print2dArray(cells);
				Thread.sleep(sleepAmount);
				System.out.println();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				alive = false;
			}
		} while (alive);
	}
	
	private static void createLiveCells(int[][] arr) {
		Random rand = new Random();
		
		for(int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if( rand.nextInt() % 2 == 0) {
					arr[i][j] = 1;
				}
			}
		}
		
	}

	private static void print2dArray(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
