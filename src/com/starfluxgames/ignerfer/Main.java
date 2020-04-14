package com.starfluxgames.ignerfer;

import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{


	public ConfigManager cfgm;
	public HashMap<String, Integer> spawnrates = new HashMap<String, Integer>();
	
	@Override
	public void onEnable(){
		loadConfigManager();
		loadConfig();
		setDefaultConfig();
		getServer().getPluginManager().registerEvents(new EventManager(), this);
		new cmd_ignreload(this);
	}
	
	public void loadConfigManager()
	{
		cfgm = new ConfigManager();
		cfgm.setup();
		cfgm.saveConfig();
		cfgm.reloadConfig();
	}
    
	public void loadConfig()
	{
		cfgm.reloadConfig();
		spawnrates.put("ig-natural-spawn-rate", cfgm.maincfg.getInt("ig-natural-spawn-rate"));
		spawnrates.put("ig-forced-spawn-rate", cfgm.maincfg.getInt("ig-forced-spawn-rate"));
	}
	
	public void setDefaultConfig()
	{
		if (!cfgm.maincfg.contains("ig-natural-spawn-rate"))
		{
			cfgm.maincfg.set("ig-natural-spawn-rate", 50);
		}
		if (!cfgm.maincfg.contains("ig-forced-spawn-rate"))
		{
			cfgm.maincfg.set("ig-forced-spawn-rate", 100);
		}
		cfgm.saveConfig();
		cfgm.reloadConfig();
	}
	
}
