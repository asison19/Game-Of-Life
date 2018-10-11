
public class CellThread extends Thread{
	int sleepAmount;
	
	int M;
	int N;
	
	int i;
	int j;
	int[][] cells;
	
	public CellThread(int M, int N, int i, int j, int[][] cells, int sleepAmount) {
		this.M = M;
		this.N = N;
		
		this.i = i;
		this.j = j;
		this.cells = cells;
		this.sleepAmount = sleepAmount;
	}
	
	public void run() {
		boolean keepGoing = true;
		do {
			try {
				checkLife();
				Thread.sleep(sleepAmount);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				keepGoing = false;
			}
		} while (keepGoing);
	}
	
	private void checkLife() {
		int liveNeighbors = 0;
		if( i > 0)
			if(cells[i - 1][j] == 1)
				liveNeighbors++;
		
		if(j < N - 1)
			if(cells[i][j + 1] == 1)
				liveNeighbors++;
		
		if(i < M - 1)
			if(cells[i+ 1][j] == 1)
				liveNeighbors++;
		
		if(j > 0)
			if(cells[i][j-1] == 1)
				liveNeighbors++;
		
		//check if this cell is dead or alive
		if (cells[i][j] == 1) {
			if (liveNeighbors < 2)
				cells[i][j] = 0; //dies
			if (liveNeighbors > 3)
				cells[i][j] = 0; // dies
		} else if (liveNeighbors == 3){
			cells[i][j] = 1; //lives
			
		}
	}

}
