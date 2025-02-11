package net.hecco.bountifulfares.world.wild_vine_feature;

import com.mojang.serialization.Codec;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.lang.reflect.Array;
import java.util.Collection;

public class WildVineFeature extends Feature<WildVineFeatureConfig> {
    public WildVineFeature(Codec<WildVineFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<WildVineFeatureConfig> context) {
        Random random = context.getRandom();
        StructureWorldAccess world = context.getWorld();
        BlockPos startPos = context.getOrigin();
        int patchSize = context.getConfig().patchSize;

        for (int i = -patchSize; i <= patchSize; i++) {
            for (int j = -patchSize; j <= patchSize; j++) {
                for (int k = -patchSize; k <= patchSize; k++) {
                    if (random.nextBoolean()) {
                        placeVine(random, world, startPos.add(i, j, k), context);
                    }
                }
            }
        }
        
        return true;
    }

    private void placeVine(Random random, StructureWorldAccess world, BlockPos pos, FeatureContext<WildVineFeatureConfig> context) {
        Collection<Direction> dirs = Direction.shuffle(random);
        dirs.remove(Direction.UP);
        dirs.remove(Direction.DOWN);
        if (world.isAir(pos)) {
            for (Direction direction : dirs) {
                if (world.getBlockState(pos.offset(direction)).isIn(context.getConfig().canPlaceOn)) {
                    world.setBlockState(pos, context.getConfig().block.with(Properties.HORIZONTAL_FACING, direction), 2);
                }
            }
        }
    }
}
