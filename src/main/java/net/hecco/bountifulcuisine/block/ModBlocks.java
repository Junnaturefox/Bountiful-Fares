package net.hecco.bountifulcuisine.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.custom.*;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.item.custom.DyeableCeramicBlockItem;
import net.hecco.bountifulcuisine.item.custom.PlantBlockItem;
import net.hecco.bountifulcuisine.util.ModBlockSetTypes;
import net.hecco.bountifulcuisine.util.ModWoodTypes;
import net.hecco.bountifulcuisine.world.tree.*;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block APPLE_LOG = registerBlock("apple_log", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.BLOSSOMING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.BLOSSOMING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block APPLE_WOOD = registerBlock("apple_wood", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.BLOSSOMING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.BLOSSOMING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block APPLE_LEAVES = registerBlock("apple_leaves", new AppleLeavesBlock(ModBlocks.HANGING_APPLE, FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block BLOSSOMING_APPLE_LEAVES = registerBlock("blossoming_apple_leaves", new AppleLeavesBlock(ModBlocks.HANGING_APPLE, FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block HANGING_APPLE = registerBlockNoItem("hanging_apple", new HangingAppleBlock(FabricBlockSettings.create().mapColor(MapColor.RED).noCollision().sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY).ticksRandomly().offset(AbstractBlock.OffsetType.XZ)));
    public static final Block APPLE_SAPLING = registerBlock("apple_sapling", new SaplingBlock(new AppleSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).sounds(BlockSoundGroup.CHERRY_SAPLING)));
    public static final Block POTTED_APPLE_SAPLING = registerBlockNoItem("potted_apple_sapling", new FlowerPotBlock(ModBlocks.APPLE_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
    public static final Block ORANGE_LOG = registerBlock("orange_log", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.BLOSSOMING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_LOG)));
    public static final Block STRIPPED_ORANGE_LOG = registerBlock("stripped_orange_log", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.BLOSSOMING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_LOG)));
    public static final Block ORANGE_WOOD = registerBlock("orange_wood", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.BLOSSOMING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_ORANGE_WOOD = registerBlock("stripped_orange_wood", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.BLOSSOMING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block ORANGE_LEAVES = registerBlock("orange_leaves", new OrangeLeavesBlock(ModBlocks.HANGING_ORANGE, FabricBlockSettings.copyOf(ModBlocks.APPLE_LEAVES)));
    public static final Block BLOSSOMING_ORANGE_LEAVES = registerBlock("blossoming_orange_leaves", new OrangeLeavesBlock(ModBlocks.HANGING_ORANGE, FabricBlockSettings.copyOf(ModBlocks.BLOSSOMING_APPLE_LEAVES)));
    public static final Block HANGING_ORANGE = registerBlockNoItem("hanging_orange", new HangingOrangeBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));
    public static final Block ORANGE_SAPLING = registerBlock("orange_sapling", new SaplingBlock(new OrangeSaplingGenerator(), FabricBlockSettings.copyOf(ModBlocks.APPLE_SAPLING)));
    public static final Block POTTED_ORANGE_SAPLING = registerBlockNoItem("potted_orange_sapling", new FlowerPotBlock(ModBlocks.ORANGE_SAPLING, FabricBlockSettings.copyOf(ModBlocks.POTTED_APPLE_SAPLING)));
    public static final Block LEMON_LOG = registerBlock("lemon_log", new LemonLogBlock(ModBlocks.LEMON_LEAVES, ModBlocks.BLOSSOMING_LEMON_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_LOG)));
    public static final Block STRIPPED_LEMON_LOG = registerBlock("stripped_lemon_log", new LemonLogBlock(ModBlocks.LEMON_LEAVES, ModBlocks.BLOSSOMING_LEMON_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_LOG)));
    public static final Block LEMON_WOOD = registerBlock("lemon_wood", new LemonLogBlock(ModBlocks.LEMON_LEAVES, ModBlocks.BLOSSOMING_LEMON_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_LEMON_WOOD = registerBlock("stripped_lemon_wood", new LemonLogBlock(ModBlocks.LEMON_LEAVES, ModBlocks.BLOSSOMING_LEMON_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block LEMON_LEAVES = registerBlock("lemon_leaves", new LemonLeavesBlock(ModBlocks.HANGING_LEMON, FabricBlockSettings.copyOf(ModBlocks.APPLE_LEAVES)));
    public static final Block BLOSSOMING_LEMON_LEAVES = registerBlock("blossoming_lemon_leaves", new LemonLeavesBlock(ModBlocks.HANGING_LEMON, FabricBlockSettings.copyOf(ModBlocks.BLOSSOMING_APPLE_LEAVES)));
    public static final Block HANGING_LEMON = registerBlockNoItem("hanging_lemon", new HangingLemonBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));
    public static final Block LEMON_SAPLING = registerBlock("lemon_sapling", new SaplingBlock(new LemonSaplingGenerator(), FabricBlockSettings.copyOf(ModBlocks.APPLE_SAPLING)));
    public static final Block POTTED_LEMON_SAPLING = registerBlockNoItem("potted_lemon_sapling", new FlowerPotBlock(ModBlocks.LEMON_SAPLING, FabricBlockSettings.copyOf(ModBlocks.POTTED_APPLE_SAPLING)));
    public static final Block PLUM_LOG = registerBlock("plum_log", new PlumLogBlock(ModBlocks.PLUM_LEAVES, ModBlocks.BLOSSOMING_PLUM_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_LOG)));
    public static final Block STRIPPED_PLUM_LOG = registerBlock("stripped_plum_log", new PlumLogBlock(ModBlocks.PLUM_LEAVES, ModBlocks.BLOSSOMING_PLUM_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_LOG)));
    public static final Block PLUM_WOOD = registerBlock("plum_wood", new PlumLogBlock(ModBlocks.PLUM_LEAVES, ModBlocks.BLOSSOMING_PLUM_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_PLUM_WOOD = registerBlock("stripped_plum_wood", new PlumLogBlock(ModBlocks.PLUM_LEAVES, ModBlocks.BLOSSOMING_PLUM_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block PLUM_LEAVES = registerBlock("plum_leaves", new PlumLeavesBlock(ModBlocks.HANGING_PLUM, FabricBlockSettings.copyOf(ModBlocks.APPLE_LEAVES)));
    public static final Block BLOSSOMING_PLUM_LEAVES = registerBlock("blossoming_plum_leaves", new PlumLeavesBlock(ModBlocks.HANGING_PLUM, FabricBlockSettings.copyOf(ModBlocks.BLOSSOMING_APPLE_LEAVES)));
    public static final Block HANGING_PLUM = registerBlockNoItem("hanging_plum", new HangingPlumBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));
    public static final Block PLUM_SAPLING = registerBlock("plum_sapling", new SaplingBlock(new PlumSaplingGenerator(), FabricBlockSettings.copyOf(ModBlocks.APPLE_SAPLING)));
    public static final Block POTTED_PLUM_SAPLING = registerBlockNoItem("potted_plum_sapling", new FlowerPotBlock(ModBlocks.PLUM_SAPLING, FabricBlockSettings.copyOf(ModBlocks.POTTED_APPLE_SAPLING)));
    public static final Block HOARY_APPLE_SAPLING_CROP = registerBlockNoItem("hoary_apple_sapling_crop", new HoaryFigSaplingCropBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HOARY_APPLE_SAPLING = registerBlock("hoary_apple_sapling", new SaplingBlock(new HoarySaplingGenerator(), FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.CHERRY_SAPLING).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_HOARY_APPLE_SAPLING = registerBlockNoItem("potted_hoary_apple_sapling", new FlowerPotBlock(ModBlocks.HOARY_APPLE_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
    public static final Block HOARY_LOG = registerBlock("hoary_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_WOOD = registerBlock("hoary_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block STRIPPED_HOARY_LOG = registerBlock("stripped_hoary_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GRAY)));
    public static final Block STRIPPED_HOARY_WOOD = registerBlock("stripped_hoary_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GRAY)));
    public static final Block HOARY_PLANKS = registerBlock("hoary_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2.0f, 5.0f).mapColor(MapColor.GRAY)));
    public static final Block HOARY_STAIRS = registerBlock("hoary_stairs", new ModStairsBlock(ModBlocks.HOARY_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.HOARY_PLANKS)));
    public static final Block HOARY_SLAB = registerBlock("hoary_slab", new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.HOARY_PLANKS)));
    public static final Block HOARY_FENCE = registerBlock("hoary_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).strength(2.0f, 5.0f).mapColor(MapColor.GRAY)));
    public static final Block HOARY_FENCE_GATE = registerBlock("hoary_fence_gate", new ModFenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).strength(2.0f, 5.0f).mapColor(MapColor.GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_DOOR = registerBlock("hoary_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(2.0f, 5.0f).mapColor(MapColor.GRAY), ModBlockSetTypes.HOARY));
    public static final Block HOARY_TRAPDOOR = registerBlock("hoary_trapdoor", new ModTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).strength(2.0f, 5.0f).mapColor(MapColor.GRAY), ModBlockSetTypes.HOARY));
    public static final Block HOARY_PRESSURE_PLATE = registerBlock("hoary_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).strength(0.5f, 5.0f), ModBlockSetTypes.HOARY));
    public static final Block HOARY_BUTTON = registerBlock("hoary_button", new ButtonBlock(AbstractBlock.Settings.copy(ModBlocks.HOARY_PLANKS).noCollision().strength(0.5f, 5f), ModBlockSetTypes.HOARY, 30, true));
    public static final Block HOARY_SIGN = registerBlockNoItem("hoary_sign", new ModStandingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_WALL_SIGN = registerBlockNoItem("hoary_wall_sign", new ModWallSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_HANGING_SIGN = registerBlockNoItem("hoary_hanging_sign", new ModHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_WALL_HANGING_SIGN = registerBlockNoItem("hoary_wall_hanging_sign", new ModWallHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_LEAVES = registerBlock("hoary_leaves", new HoaryLeavesBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    public static final Block HANGING_HOARY_APPLE = registerBlockNoItem("hanging_hoary_apple", new HangingHoaryAppleBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));
    public static final Block TRELLIS = registerBlock("trellis", new TrellisBlock(FabricBlockSettings.create().strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).nonOpaque()));
    public static final Block PASSION_FRUIT_TRELLIS = registerBlockNoItem("passion_fruit_trellis", new PassionFruitTrellisBlock(ModItems.PASSION_FRUIT, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly()));
    public static final Block ELDERBERRY_TRELLIS = registerBlockNoItem("elderberry_trellis", new ElderberryTrellisBlock(ModItems.ELDERBERRIES, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly()));
    public static final Block GLOW_BERRY_TRELLIS = registerBlockNoItem("glow_berry_trellis", new GlowBerryTrellisBlock(Items.GLOW_BERRIES, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly()));
    public static final Block LAPISBERRY_TRELLIS = registerBlockNoItem("lapisberry_trellis", new LapisberryTrellisBlock(ModItems.LAPISBERRY_SEEDS, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly()));
    public static final Block FLOWER_TRELLIS = registerBlockNoItem("flower_trellis", new FlowerTrellisBlock(FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly()));
    public static final Block WILD_CARROTS = registerPlantBlock("wild_carrots", new WildCropBlock(ModItems.WILD_CARROT, FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_POTATOES = registerPlantBlock("wild_potatoes", new WildCropBlock(ModItems.WILD_POTATO, FabricBlockSettings.create().mapColor(MapColor.DULL_PINK).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_WHEAT = registerPlantBlock("wild_wheat", new WildCropBlock(ModItems.WILD_WHEAT_SEEDS, FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_BEETROOTS = registerPlantBlock("wild_beetroots", new WildCropBlock(ModItems.WILD_BEETROOT_SEEDS, FabricBlockSettings.create().mapColor(MapColor.DULL_PINK).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FELDSPAR_BLOCK = registerBlock("feldspar_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.BASEDRUM).strength(1.5f).sounds(BlockSoundGroup.CALCITE)));
    public static final Block CERAMIC_CLAY_BLOCK = registerBlock("ceramic_clay_block", new Block(FabricBlockSettings.copyOf(Blocks.CLAY).instrument(Instrument.FLUTE).mapColor(MapColor.WHITE)));
    public static final Block CERAMIC_TILES = registerDyeableCeramicBlock("ceramic_tiles", new CeramicTilesBlock(FabricBlockSettings.copyOf(Blocks.BRICKS).strength(2f, 16f).sounds(BlockSoundGroup.DEEPSLATE_TILES).instrument(Instrument.BASEDRUM).mapColor(MapColor.OFF_WHITE)));
    public static final Block CERAMIC_TILE_STAIRS = registerDyeableCeramicBlock("ceramic_tile_stairs", new CeramicTileStairsBlock(ModBlocks.CERAMIC_TILES.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.CERAMIC_TILES)));
    public static final Block CERAMIC_TILE_SLAB = registerDyeableCeramicBlock("ceramic_tile_slab", new CeramicTileSlabBlock(FabricBlockSettings.copyOf(ModBlocks.CERAMIC_TILES)));
    public static final Block FERMENTATION_VESSEL = registerBlock("fermentation_vessel", new FermentationVesselBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).strength(2, 5).instrument(Instrument.BASEDRUM).requiresTool().nonOpaque().sounds(BlockSoundGroup.DECORATED_POT)));
    public static final Block FULL_FERMENTATION_VESSEL = registerBlockNoItem("full_fermentation_vessel", new FullFermentationVesselBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).strength(2, 5).instrument(Instrument.BASEDRUM).requiresTool().nonOpaque().ticksRandomly().sounds(BlockSoundGroup.DECORATED_POT)));
    public static final Block APPLE_BLOCK = registerPlantBlock("apple_block", new AppleBlock(FabricBlockSettings.create().mapColor(MapColor.RED).strength(1f).instrument(Instrument.DIDGERIDOO).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block EATEN_APPLE_BLOCK = registerBlockNoItem("eaten_apple_block", new EatenAppleBlock(FabricBlockSettings.copyOf(ModBlocks.APPLE_BLOCK)));
    public static final Block ORANGE_BLOCK = registerPlantBlock("orange_block", new OrangeBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).strength(0.5f).instrument(Instrument.DIDGERIDOO).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block EATEN_ORANGE_BLOCK = registerBlockNoItem("eaten_orange_block", new EatenOrangeBlock(FabricBlockSettings.copyOf(ModBlocks.ORANGE_BLOCK)));
    public static final Block LEMON_BLOCK = registerPlantBlock("lemon_block", new LemonBlock(FabricBlockSettings.create().mapColor(MapColor.YELLOW).strength(0.5f).instrument(Instrument.DIDGERIDOO).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block EATEN_LEMON_BLOCK = registerBlockNoItem("eaten_lemon_block", new EatenLemonBlock(FabricBlockSettings.copyOf(ModBlocks.LEMON_BLOCK)));
    public static final Block PLUM_BLOCK = registerPlantBlock("plum_block", new PlumBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_DULL_PINK).strength(0.5f).instrument(Instrument.DIDGERIDOO).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block EATEN_PLUM_BLOCK = registerBlockNoItem("eaten_plum_block", new EatenPlumBlock(FabricBlockSettings.copyOf(ModBlocks.PLUM_BLOCK)));
    public static final Block HOARY_APPLE_BLOCK = registerPlantBlock("hoary_apple_block", new HoaryAppleBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_GRAY).strength(0.5f).instrument(Instrument.DIDGERIDOO).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block EATEN_HOARY_APPLE_BLOCK = registerBlockNoItem("eaten_hoary_apple_block", new EatenHoaryAppleBlock(FabricBlockSettings.copyOf(ModBlocks.HOARY_APPLE_BLOCK)));
    public static final Block TEA_SHRUB = registerBlockNoItem("tea_shrub", new TeaShrubBlock(FabricBlockSettings.create().nonOpaque().strength(0.5f).ticksRandomly().noCollision().mapColor(MapColor.GREEN).sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CHAMOMILE_FLOWERS = registerPlantBlock("chamomile_flowers", new ChamomileFlowersBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).noCollision().sounds(BlockSoundGroup.PINK_PETALS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HONEYSUCKLE = registerPlantBlock("honeysuckle", new FlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.copyOf(Blocks.POPPY)));
    public static final Block POTTED_HONEYSUCKLE = registerBlockNoItem("potted_honeysuckle", new FlowerPotBlock(ModBlocks.HONEYSUCKLE, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY)));
    public static final Block VIOLET_BELLFLOWER = registerPlantBlock("violet_bellflower", new FlowerBlock(StatusEffects.INVISIBILITY, 5, FabricBlockSettings.copyOf(Blocks.POPPY)));
    public static final Block POTTED_VIOLET_BELLFLOWER = registerBlockNoItem("potted_violet_bellflower", new FlowerPotBlock(ModBlocks.VIOLET_BELLFLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY)));
    public static final Block RED_JACK_O_STRAW = registerBlock("red_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ORANGE_JACK_O_STRAW = registerBlock("orange_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block YELLOW_JACK_O_STRAW = registerBlock("yellow_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIME_JACK_O_STRAW = registerBlock("lime_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GREEN_JACK_O_STRAW = registerBlock("green_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CYAN_JACK_O_STRAW = registerBlock("cyan_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIGHT_BLUE_JACK_O_STRAW = registerBlock("light_blue_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLUE_JACK_O_STRAW = registerBlock("blue_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PURPLE_JACK_O_STRAW = registerBlock("purple_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MAGENTA_JACK_O_STRAW = registerBlock("magenta_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PINK_JACK_O_STRAW = registerBlock("pink_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WHITE_JACK_O_STRAW = registerBlock("white_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIGHT_GRAY_JACK_O_STRAW = registerBlock("light_gray_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GRAY_JACK_O_STRAW = registerBlock("gray_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLACK_JACK_O_STRAW = registerBlock("black_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BROWN_JACK_O_STRAW = registerBlock("brown_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }

    private static Block registerPlantBlock(String name, Block block) {
        registerPlantBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }
    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static void registerPlantBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), new PlantBlockItem(block, new FabricItemSettings()));
    }

    private static Block registerDyeableCeramicBlock(String name, Block block) {
        registerDyeableCeramicBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }
    private static void registerDyeableCeramicBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), new DyeableCeramicBlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        BountifulCuisine.LOGGER.debug("Registering ModBlocks for " + BountifulCuisine.MOD_ID);
    }
}
