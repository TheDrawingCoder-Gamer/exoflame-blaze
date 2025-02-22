package gay.menkissing.exoflame_blaze;

import com.simibubi.create.content.processing.burner.BlazeBurnerBlockEntity;
import gay.menkissing.exoflame_blaze.config.ExoflameBlazeConfigForge;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vazkii.botania.api.BotaniaFabricCapabilities;

import java.util.Optional;

public class ExoflameBlaze implements ModInitializer {

    public static Logger LOGGER = LoggerFactory.getLogger("exoflame-blaze");

    @Override
    public void onInitialize() {
        LOGGER.info("Hello exoflame-blaze!");
        if (FabricLoader.getInstance().isModLoaded("forgeconfigapiport")) {
            ExoflameBlazeConfigForge.registerCommonConfig();
        }


        ResourceLocation blazeburnerid = new ResourceLocation("create", "blaze_heater");

        Optional<BlockEntityType<?>> be = BuiltInRegistries.BLOCK_ENTITY_TYPE.getOptional(blazeburnerid);

        if (be.isPresent()) {
            registerLookup((BlockEntityType<BlazeBurnerBlockEntity>) be.get());
        } else {
            RegistryEntryAddedCallback.event(BuiltInRegistries.BLOCK_ENTITY_TYPE).register((rawId, id, object) -> {
                if (id.equals(blazeburnerid)) {
                    registerLookup((BlockEntityType<BlazeBurnerBlockEntity>) object);
                }
            });
        }

    }

    public void registerLookup(BlockEntityType<BlazeBurnerBlockEntity> be) {
        LOGGER.info("Found blaze burner!");
        BotaniaFabricCapabilities.EXOFLAME_HEATABLE.registerForBlockEntity(
                ((blockEntity, unit) -> new BlazeBurnerExoflameHeatable(blockEntity)),
                be
        );
    }
}
