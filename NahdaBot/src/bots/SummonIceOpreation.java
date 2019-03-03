package bots;

import elf_kingdom.*;
import elf_kingdom.Portal;

public class SummonIceOpreation extends ManaOperation{

	@Override
	public int GetScore(Game game) {
		 
		return 0;
	}

	@Override
	public void ActivateOperation(Game game) {
	    for (Portal portal : game.getMyPortals()) {
				// If the portal can summon a lava giant - do that.
	            if (portal.canSummonIceTroll()) {
	                // Summon the lava giant.
	                portal.summonIceTroll();
	               return;
	            }
	        }
		
	}

}
