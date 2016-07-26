package com.acme.app;

import com.acme.app.values.CannedWalrusFood;
import com.acme.app.values.Walrus;

public class FeedsWalrus {

	OpensCan opensCan;
	
	public void feed(Walrus gary, CannedWalrusFood can) {
		gary.addToStomach(opensCan.open(can));
	}

}
