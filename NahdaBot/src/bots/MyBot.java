package bots;

import elf_kingdom.*;

/*
 *הנחות 
 *the elves Never do nothing 
 */
public class MyBot implements SkillzBot {
	/**
	 * Makes the bot run a single turn.
	 *
	 * @param game - the current game state.
	 */

	private static int MaxLavaGiantsNumber = 5;

	// Manaoperation Objects
	SummonLavaOperation Lopr = new SummonLavaOperation();
	BuildPortalOpreation Bopr = new BuildPortalOpreation();
	SummonIceOpreation Iopr = new SummonIceOpreation();
	//

	public void doTurn(Game game) {
		decide_Which_Opreation(game);
		// Give orders to my elves.
		//handleElves(game);
		// Give orders to my portals.
		//handlePortals(game);

	}

	public void decide_Which_Opreation(Game game) {
		// Gives every Operation a Score
		GiveScore(game);
		for (Portal p : game.getMyPortals()) {
			if (game.getMyMana() > p.cost + 30) {

			//	if (Bopr.Score > Iopr.Score && Bopr.Score > Lopr.Score)
					Bopr.ActivateOperation(game);

			}
			for (Creature Enemy : game.getEnemyCreatures()) {
				if (Enemy.inRange(p, 20)) {
			//		if (Bopr.Score < Iopr.Score && Iopr.Score > Lopr.Score)
						Iopr.ActivateOperation(game);
				}
			}

		}
		
		//we should add when we want to implement LavaGiant;
		//
		
	}
   /*
    * We should implememnt thos methods
    */
	public static void GiveScore(Game game) {  // Decide witch Opreation is more important

	}

	// We assume that decide() returned COLLECT
	public void MoveOrAttackByElf(Game game) {
		Elf[] myElf = game.getMyLivingElves();
		for (Elf elf : myElf) {
			if (elf.inAttackRange(game.getEnemyCastle())) {
				elf.attack(game.getEnemyCastle());
			}
		}
	}

	/**
	 * Gives orders to my elves.
	 *
	 * @param game - the current game state
	 */
	private void handleElves(Game game) {
		// Get enemy castle
		Castle enemyCastle = game.getEnemyCastle();
		// Go over all the living elves.
		for (Elf elf : game.getMyLivingElves()) {

			// Try to attack enemy castle, if not move to it.
			if (elf.inAttackRange(enemyCastle)) {
				// Attack!
				elf.attack(enemyCastle);
				// Print a message.
				System.out.println("elf " + elf + " attacks " + enemyCastle);
			} else {
				// Move to enemy castle!

				if (game.turn > 15 && game.turn < 20) {
					build(game);
				}

				else {
					if (game.turn > 30 && game.turn < 40) {
						build(game);
					}

					elf.moveTo(enemyCastle);
				}

				// Print a message.
				System.out.println("elf " + elf + " moves to " + enemyCastle);
			}

		}

	}

	public void build(Game game) {

		Elf[] elfarray = game.getMyLivingElves();
		if (elfarray[0].canBuildPortal()) {
			System.out.println("in");
			elfarray[0].buildPortal();

		}
	}

	/**
	 * Gives orders to my portals.
	 *
	 * @param game - the current game state
	 */

	private void handlePortals(Game game) {
		// Go over all of my portals.
		for (Portal portal : game.getMyPortals()) {
			// If the portal can summon a lava giant - do that.
			if (portal.canSummonIceTroll()) {
				// Summon the lava giant.
				portal.summonIceTroll();
				// Print a message.
				System.out.println("portal " + portal + " summons a lava giant");
			}
		}
	}
}
