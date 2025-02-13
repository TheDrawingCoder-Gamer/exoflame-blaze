package gay.menkissing.exoflame_blaze;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlockEntity;
import net.fabricmc.api.ModInitializer;
import vazkii.botania.api.BotaniaFabricCapabilities;

public class ExoflameBlaze implements ModInitializer {

    @Override
    public void onInitialize() {
        BotaniaFabricCapabilities.EXOFLAME_HEATABLE.registerForBlockEntity(
                ((blockEntity, unit) -> new BlazeBurnerExoflameHeatable(blockEntity)),
                AllBlockEntityTypes.HEATER.get()
        );
    }
}
