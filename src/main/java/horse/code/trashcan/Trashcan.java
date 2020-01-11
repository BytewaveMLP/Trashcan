package horse.code.trashcan;

import org.bukkit.plugin.java.JavaPlugin;

public class Trashcan extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("It's garbage day!");
	}
}
