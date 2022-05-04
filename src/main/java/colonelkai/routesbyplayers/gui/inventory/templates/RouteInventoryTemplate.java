package colonelkai.routesbyplayers.gui.inventory.templates;

import colonelkai.routesbyplayers.gui.inventory.PagedInventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.NextPageSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.PreviousPageSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.RouteSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.util.Route;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RouteInventoryTemplate implements PagedInventoryTemplate {
    @Override
    public int getInventorySize() {
        return 64;
    }

    @Override
    public @NotNull String getTemplateName() {
        return "Routes";
    }

    @Override
    public TreeSet<Slot> getSlots(int page) {
        List<Route> orderedRoutes = Managers.getInstance().getRouteManager().getElements().stream().sorted().collect(Collectors.toList());
        int itemsPerPage = this.getInventorySize() - 9;
        int minIndex = itemsPerPage * page;
        int maxIndex = minIndex + (itemsPerPage - 1);
        List<Route> pageRoutes = orderedRoutes.subList(minIndex, maxIndex);
        TreeSet<Slot> slots = new TreeSet<>();
        for (int i = 0; i < pageRoutes.size(); i++) {
            slots.add(new RouteSlot(this, i + 9));
        }
        slots.add(new NextPageSlot(this));
        slots.add(new PreviousPageSlot(this));
        return slots;
    }

    @Override
    public int getMaxPages() {
        int itemsPerPage = this.getInventorySize() - 9;
        int routes = Managers.getInstance().getRouteManager().getElements().size();

        return routes / itemsPerPage;
    }
}
