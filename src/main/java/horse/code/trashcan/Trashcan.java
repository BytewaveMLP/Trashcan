package horse.code.trashcan;

import org.bukkit.plugin.java.JavaPlugin;

public class Trashcan extends JavaPlugin {
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new CauldronRightClickListener(), this);
		this.getCommand("trash").setExecutor(new TrashCommand());
		getLogger().info("It's garbage day!");
	}
}
