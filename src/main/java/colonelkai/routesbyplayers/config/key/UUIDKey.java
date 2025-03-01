package colonelkai.routesbyplayers.config.key;

import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.UUID;

public class UUIDKey extends AbstractSerializationKey<UUID> {

    UUIDKey(@NotNull String node) {
        super(node);
    }

    @Override
    public @NotNull Optional<UUID> get(@NotNull FileConfiguration configuration) {
        String uuidString = configuration.getString(this.getNode());
        if (uuidString == null) {
            return Optional.empty();
        }
        try {
            return Optional.of(UUID.fromString(uuidString));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
