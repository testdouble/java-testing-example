package example.values;

public class CannedWalrusFood {

	private WalrusFood food;

	public CannedWalrusFood() {
	}

	public CannedWalrusFood(WalrusFood food) {
		this.food = food;
	}

	public WalrusFood extractContents() {
		WalrusFood contents = food;
		food = null;
		return contents;
	}

}
