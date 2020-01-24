package horse.code.trashcan;

import org.bukkit.Material;
import org.bukkit.block.data.Levelled;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class CauldronRightClickListener implements Listener {
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		if (!event.getClickedBlock().getType().equals(Material.CAULDRON)) return;
		if (((Levelled) event.getClickedBlock().getBlockData()).getLevel() != 0) return;
		if (event.hasItem()) {
			ItemStack item = event.getItem();

			if (event.getPlayer().isSneaking() && item.getType().isBlock()) return;

			if (item.getType().equals(Material.BUCKET)
			    || item.getType().equals(Material.WATER_BUCKET)
				|| item.getType().equals(Material.GLASS_BOTTLE)
				|| item.getType().equals(Material.POTION)
				|| item.getType().equals(Material.LEATHER_HELMET)
				|| item.getType().equals(Material.LEATHER_CHESTPLATE)
				|| item.getType().equals(Material.LEATHER_LEGGINGS)
				|| item.getType().equals(Material.LEATHER_BOOTS))
				return;
		}

		event.setUseInteractedBlock(Event.Result.DENY);
		event.setUseItemInHand(Event.Result.DENY);
		event.setCancelled(true);

		// only run the event once
		if (event.getHand() == EquipmentSlot.HAND) TrashcanGUI.openTrashcan(event.getPlayer());
	}
}
