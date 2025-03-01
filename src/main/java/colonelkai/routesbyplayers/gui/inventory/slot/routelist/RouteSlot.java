package colonelkai.routesbyplayers.gui.inventory.slot.routelist;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.util.Route;
import org.bukkit.Color;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class RouteSlot extends Slot {
    public RouteSlot(@NotNull InventoryTemplate template, int slotIndex, Route route) {
        super(template, slotIndex, new ItemStackBuilder()
                .setName(Color.WHITE + route.getNode(1).getIdentifier() + " to " + route.getNode(2).getIdentifier())
                .addLore(Color.GRAY + "Upkeep: " + route.getUpkeep())
                .addLore(Color.GRAY + "Cost: " + route.getTotalPrice())
                .setMaterial(Material.COMPASS)
                .setAmount(1)
                .build());
    }
}
