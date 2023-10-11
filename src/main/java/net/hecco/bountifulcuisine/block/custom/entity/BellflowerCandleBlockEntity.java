package net.hecco.bountifulcuisine.block.custom.entity;

import net.hecco.bountifulcuisine.block.custom.BellflowerCandleBlock;
import net.hecco.bountifulcuisine.block.custom.GreenTeaCandleBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class BellflowerCandleBlockEntity extends BlockEntity {
    private static BooleanProperty isLit;
    public BellflowerCandleBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BELLFLOWER_CANDLE_BLOCK_ENTITY, pos, state);
        isLit = ((BellflowerCandleBlock)state.getBlock()).getLit();
    }
    public static void tick(World world, BlockPos pos, BlockState state, BellflowerCandleBlockEntity blockEntity) {
        Box box = new Box(pos).expand(5).stretch(0.0, 0.0, 0.0);
        List<PlayerEntity> list = world.getNonSpectatingEntities(PlayerEntity.class, box);
        if (state.get(isLit)) {
            if (!world.isClient() && !list.isEmpty()) {
                for (PlayerEntity playerEntity : list) {
                    playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 50, 0, true, false));
                }
            }
        }
    }
}
