package gay.menkissing.exoflame_blaze;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlockEntity;
import gay.menkissing.exoflame_blaze.config.ExoflameBlazeConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import vazkii.botania.api.BotaniaFabricCapabilities;

public class ExoflameBlaze implements ModInitializer {

    @Override
    public void onInitialize() {
        ExoflameBlazeConfig.registerCommonConfig();

        ResourceLocation blazeburnerid = new ResourceLocation("create", "blaze_heater");
        RegistryEntryAddedCallback.event(BuiltInRegistries.BLOCK_ENTITY_TYPE).register((rawId, id, object) -> {
           if (id.equals(blazeburnerid)) {
               System.out.println("Hello everybody my name is mikeiplier");
               BotaniaFabricCapabilities.EXOFLAME_HEATABLE.registerForBlockEntity(
                       ((blockEntity, unit) -> new BlazeBurnerExoflameHeatable(blockEntity)),
                       (BlockEntityType<BlazeBurnerBlockEntity>)object
               );
           }
        });


    }
}
