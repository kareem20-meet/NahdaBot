package bots;

import elf_kingdom.*;
 

public class SummonLavaOperation extends ManaOperation {

	public int GetScore(Game game) {

		return 0;
	}

	public void ActivateOperation(Game game) {

		for (Portal portal : game.getMyPortals()) {

			if (portal.canSummonLavaGiant()) {

				portal.summonLavaGiant();
				return ;
			}
		}
	}

}
