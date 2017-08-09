import java.util.ArrayList;

public class OptimalCompanies {
	
	/*
	 * Using knapsack problem for reference as the problem is similar
	 * */
	
	public static ArrayList<Object> materialRequests;
	public static int[][] table;
	public static final int TOTAL_MATERIAL = 30; // total material company can provide
	
	static class companyNode {
		String name;
		int amount;
		int price;
		
		public companyNode(String n, int a, int p) {
			name = n;
			amount = a;
			price = p;
		}
		
	}
	
	public static void main(String[] args) {
		materialRequests = new ArrayList();
		addCompanies();
		table = buildKnapsackTable();
		
		// print out companies to sell materials
		findCompanies(table);
	}
	

	private static void addCompanies() {
		materialRequests.add(new companyNode("A", 1, 1));
		materialRequests.add(new companyNode("B", 2, 5));
		materialRequests.add(new companyNode("C", 3, 8));
		materialRequests.add(new companyNode("D", 4, 9));
		materialRequests.add(new companyNode("E", 5, 10));
		materialRequests.add(new companyNode("F", 6, 17));
		materialRequests.add(new companyNode("G", 7, 17));
		materialRequests.add(new companyNode("H", 8, 20));
		materialRequests.add(new companyNode("I", 9, 24));
		materialRequests.add(new companyNode("J", 10, 30));
	}
	

	private static int[][] buildKnapsackTable() {
		int row = materialRequests.size();
		int col = TOTAL_MATERIAL;
		int[][] result = new int[row + 1][col + 1];

		for(int r = 1; r <= row; r++) {
			companyNode currComp = (companyNode) materialRequests.get(r - 1);
			for(int c = 1; c <= col; c++) {
				if(currComp.amount > c) {
					result[r][c] = result[r - 1][c];
				} else {
					result[r][c] = Integer.max(result[r - 1][c],
							(currComp.price + result[r - 1][c - currComp.amount]));
				}
			}
		}
		return result;
	}
	
	
	// tracing back through table to find companies that give the max profit
	public static void findCompanies(int[][] table) {
		int row = table.length - 1;
		int col = table[0].length - 1;
		int maxProfit = table[row][col];
		while(maxProfit != 0 && row > 0 && col > 0) {
			if(table[row - 1][col] != maxProfit) {
				companyNode c = ((companyNode)materialRequests.get(row - 1));
				System.out.print(c.name + " ");
				col = col - c.amount;
				row = row - 1;
				maxProfit = table[row][col];
			} else {
				row = row - 1;
			}
		}
	}
	
}
