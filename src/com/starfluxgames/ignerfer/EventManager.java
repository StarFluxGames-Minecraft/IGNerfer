package com.starfluxgames.ignerfer;

import java.security.SecureRandom;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class EventManager implements Listener {

	private Main plugin = Main.getPlugin(Main.class);

	@EventHandler
	public void entitySpawn(CreatureSpawnEvent e)
	{
		int spawnChance = 0;
		SecureRandom r = new SecureRandom();
		if (e.getEntity().getType().equals(EntityType.IRON_GOLEM))
		{
			spawnChance = r.nextInt(101);
			if (e.getSpawnReason().equals(SpawnReason.BUILD_IRONGOLEM))
			{
				//Forced
				if (plugin.spawnrates.get("ig-forced-spawn-rate") < spawnChance)
				{
					e.setCancelled(true);
				}
			}else
			{
				//Natural
				if (plugin.spawnrates.get("ig-natural-spawn-rate") < spawnChance)
				{
					e.setCancelled(true);
				}
			}
		}
	}

}
