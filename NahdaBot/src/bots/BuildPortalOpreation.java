package bots;

import elf_kingdom.*;
 

public class BuildPortalOpreation extends ManaOperation {

	@Override
	public int GetScore(Game game) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ActivateOperation(Game game) {
		Elf[] elfarray = game.getMyLivingElves();

		for (Elf elf : elfarray) {
			if (elf.canBuildPortal()) {
				elf.buildPortal();
			}
		}
	}
}
