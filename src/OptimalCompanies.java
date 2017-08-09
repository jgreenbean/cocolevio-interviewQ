import java.util.ArrayList;

public class OptimalCompanies {
	
	public static ArrayList<Object> materialRequests;
	
	static class companyNode {
		private String name;
		private int amount;
		private int price;
		
		public companyNode(String n, int a, int p) {
			name = n;
			amount = a;
			price = p;
		}
	}
	
	public static void main(String[] args) {
		materialRequests = new ArrayList();
		addCompanies();
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

}
