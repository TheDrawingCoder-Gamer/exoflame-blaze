package gay.menkissing.exoflame_blaze;

import com.simibubi.create.content.processing.burner.BlazeBurnerBlockEntity;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlockEntity.FuelType;
import gay.menkissing.exoflame_blaze.config.ExoflameBlazeConfig;
import gay.menkissing.exoflame_blaze.mixin.BlazeBurnerBlockEntityAccessor;
import vazkii.botania.api.block.ExoflameHeatable;

public class BlazeBurnerExoflameHeatable  implements ExoflameHeatable {
    private final BlazeBurnerBlockEntity burner;

    public BlazeBurnerExoflameHeatable(BlazeBurnerBlockEntity burner) {
        this.burner = burner;
    }
    @Override
    public boolean canSmelt() {
        if (this.burner.isCreative()) {
            return false;
        }
        FuelType fuel = this.burner.getActiveFuel();
        return switch (fuel){
            case NONE -> true;
            case NORMAL, SPECIAL -> this.getBurnTime() < BlazeBurnerBlockEntity.MAX_HEAT_CAPACITY;
        };
    }

    @Override
    public int getBurnTime() {
        return this.burner.getRemainingBurnTime();
    }

    @Override
    public void boostBurnTime() {
        FuelType fuel = this.burner.getActiveFuel();
        if (fuel == FuelType.NONE) {
            ((BlazeBurnerBlockEntityAccessor) this.burner).setActiveFuel(FuelType.NORMAL);
            fuel = FuelType.NORMAL;
        }

        int rate = fuel == FuelType.NORMAL ? ExoflameBlazeConfig.INSTANCE.boostRate() : ExoflameBlazeConfig.INSTANCE.seethingBoostRate();
        ((BlazeBurnerBlockEntityAccessor) this.burner).setRemainingBurnTime(this.getBurnTime() + rate);
        this.burner.updateBlockState();
    }

    @Override
    public void boostCookTime() {

    }
}
