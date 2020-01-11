package horse.code.trashcan;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CauldronRightClickListener implements Listener {
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getAction() != Action.RIGHT_CLICK_BLOCK
		    || !event.getClickedBlock().getType().equals(Material.CAULDRON)
		    || (event.hasItem()
				&& (event.getItem().isSimilar(new ItemStack(Material.BUCKET))
					|| event.getItem().isSimilar(new ItemStack(Material.WATER_BUCKET)))))
			return;

		TrashcanGUI.openTrashcan(event.getPlayer());
		event.setCancelled(true);
	}
}
