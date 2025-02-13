package gay.menkissing.exoflame_blaze.config;

import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class ExoflameBlazeConfig {
    public ExoflameBlazeConfig() {

    }

    public static ForgeConfigSpec.ConfigValue<Integer> EXOFLAME_BOOST_RATE;
    public static ForgeConfigSpec.ConfigValue<Integer> EXOFLAME_SEETHING_BOOST_RATE;

    public static void registerCommonConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("Exoflame blaze burner parameters").push("exoflame_parameters");

        EXOFLAME_BOOST_RATE = builder.comment("Maximum number of burners exoflame can provide heat to sustainably.").define("boost_rate", 9);
        EXOFLAME_SEETHING_BOOST_RATE = builder.comment("Maximum number of burners exoflame can provide heat to sustainably when superheated.").define("seething_boost_rate", 1);

        builder.pop();

        ForgeConfigRegistry.INSTANCE.register("exoflame-blaze", ModConfig.Type.COMMON, builder.build());

    }
}
