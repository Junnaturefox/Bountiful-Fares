package net.hecco.bountifulfares.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.block.custom.CoconutBlock;
import net.hecco.bountifulfares.block.custom.FruitLogBlock;
import net.hecco.bountifulfares.block.custom.PalmFrondParentBlock;
import net.hecco.bountifulfares.block.custom.WallPalmFrondBlock;
import net.hecco.bountifulfares.world.tree.BFTrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class GoldenAppleTrunkPlacer extends TrunkPlacer {
    protected final int height;
    public static final MapCodec<GoldenAppleTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            (instance) -> instance.group(
                    Codec.intRange(0, 32)
                            .fieldOf("height")
                            .forGetter((placer) -> placer.height)
            ).apply(instance, GoldenAppleTrunkPlacer::new));

    public GoldenAppleTrunkPlacer(int height) {
        super(0, 0, 0);
        this.height = height;
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return BFTrunkPlacerTypes.GOLDEN_APPLE_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        List<FoliagePlacer.TreeNode> nodes = new ArrayList<>();
        int baseHeight = this.height + random.nextBetween(0, 1);
        int secondHeight = random.nextBetween(2, 2);
        Direction firstBranchDir = Direction.Type.HORIZONTAL.random(random);
        for (int i = 0; i <= baseHeight; i++) {
            replacer.accept(startPos.up(i), BFBlocks.GOLDEN_APPLE_LOG.getDefaultState()
                    .with(FruitLogBlock.AXIS, Direction.Axis.Y)
                    .with(FruitLogBlock.UP, true)
                    .with(FruitLogBlock.DOWN, true)
                    .with(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir), true));
        }
        replacer.accept(startPos.up(baseHeight).offset(firstBranchDir), BFBlocks.GOLDEN_APPLE_LOG.getDefaultState()
                .with(FruitLogBlock.AXIS, firstBranchDir.getAxis())
                .with(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir), true)
                .with(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir.getOpposite()), true));
        replacer.accept(startPos.up(baseHeight).offset(firstBranchDir, 2), BFBlocks.GOLDEN_APPLE_LOG.getDefaultState()
                .with(FruitLogBlock.AXIS, Direction.Axis.Y)
                .with(FruitLogBlock.UP, true)
                .with(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir), true));
        replacer.accept(startPos.up(baseHeight + 1).offset(firstBranchDir, 2), BFBlocks.GOLDEN_APPLE_LOG.getDefaultState()
                .with(FruitLogBlock.AXIS, Direction.Axis.Y)
                .with(FruitLogBlock.UP, true)
                .with(FruitLogBlock.DOWN, true));
        nodes.add(new FoliagePlacer.TreeNode(startPos.up(baseHeight + 1).offset(firstBranchDir, 2), 2, false));
        for (int i = 1; i < secondHeight; i++) {
            replacer.accept(startPos.up(baseHeight + i), BFBlocks.GOLDEN_APPLE_LOG.getDefaultState()
                    .with(FruitLogBlock.AXIS, Direction.Axis.Y)
                    .with(FruitLogBlock.UP, true)
                    .with(FruitLogBlock.DOWN, true)
                    .with(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir), true));
        }
        replacer.accept(startPos.up(baseHeight + secondHeight-1).offset(firstBranchDir.getOpposite()), BFBlocks.GOLDEN_APPLE_LOG.getDefaultState()
                .with(FruitLogBlock.AXIS, firstBranchDir.getAxis())
                .with(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir), true)
                .with(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir.getOpposite()), true));
        replacer.accept(startPos.up(baseHeight + secondHeight-1).offset(firstBranchDir.getOpposite(), 2), BFBlocks.GOLDEN_APPLE_LOG.getDefaultState()
                .with(FruitLogBlock.AXIS, Direction.Axis.Y)
                .with(FruitLogBlock.UP, true)
                .with(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir.getOpposite()), true));
        replacer.accept(startPos.up(baseHeight + secondHeight).offset(firstBranchDir.getOpposite(), 2), BFBlocks.GOLDEN_APPLE_LOG.getDefaultState()
                .with(FruitLogBlock.AXIS, Direction.Axis.Y)
                .with(FruitLogBlock.UP, true)
                .with(FruitLogBlock.DOWN, true));
        nodes.add(new FoliagePlacer.TreeNode(startPos.up(baseHeight + secondHeight).offset(firstBranchDir.getOpposite(), 2), 2, false));
        return nodes;
    }
}