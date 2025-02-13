package gay.menkissing.exoflame_blaze.config;

import net.fabricmc.loader.api.FabricLoader;

public class ExoflameBlazeConfig {
    public static final IExoflameBlazeConfig INSTANCE;

    static {
        if (FabricLoader.getInstance().isModLoaded("forgeconfigapiport")) {
            INSTANCE = ExoflameBlazeConfigForge.INSTANCE;
        } else {
            INSTANCE = new IExoflameBlazeConfig() {};
        }
    }
}
