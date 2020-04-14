package com.starfluxgames.ignerfer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class cmd_ignreload implements CommandExecutor{

	private Main plugin;
	
	public cmd_ignreload(Main plugin)
	{
		this.plugin = plugin;
		plugin.getCommand("ignreload").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender.hasPermission("ignerfer.reload") || sender.isOp())
		{
			plugin.cfgm.reloadConfig();
			plugin.loadConfig();
			sender.sendMessage(ChatColor.GREEN + "Config Reloaded");	
		}
		
		return false;
	}
	
}