package example;

import example.values.CannedWalrusFood;
import example.values.WalrusFood;

public class OpensCan {

	public WalrusFood open(CannedWalrusFood can) {
		return can.extractContents();
	}

}
