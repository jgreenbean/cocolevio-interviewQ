import java.util.ArrayList;

public class OptimalCompanies {
	
	public static ArrayList<Object> materialRequests;
	public static int[][] table;
	
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
		int totalMaterial = 20; // total material company can provide
		materialRequests = new ArrayList();
		addCompanies();
		table = buildKnapsackTable(totalMaterial);
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
	
	// problem is similar to knapsack problem
	private static int[][] buildKnapsackTable(int totalMaterial) {
		int row = materialRequests.size();
		int col = totalMaterial;
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
}
