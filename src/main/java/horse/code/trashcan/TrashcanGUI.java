package horse.code.trashcan;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TrashcanGUI {
	public static void openTrashcan(Player player) {
		player.openInventory(Bukkit.createInventory(null, 27, "Trashcan"));
	}
}
