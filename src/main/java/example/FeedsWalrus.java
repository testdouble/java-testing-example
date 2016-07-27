package example;

import example.values.CannedWalrusFood;
import example.values.Walrus;

public class FeedsWalrus {

	OpensCan opensCan;
	
	public void feed(Walrus gary, CannedWalrusFood can) {
		gary.addToStomach(opensCan.open(can));
	}

}
