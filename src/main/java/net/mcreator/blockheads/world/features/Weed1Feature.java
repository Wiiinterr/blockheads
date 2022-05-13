
package net.mcreator.blockheads.world.features;

public class Weed1Feature extends Feature<NoneFeatureConfiguration> {

	public static Weed1Feature FEATURE = null;
	public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new Weed1Feature();
		CONFIGURED_FEATURE = FeatureUtils.register("blockheads:weed_1", FEATURE, FeatureConfiguration.NONE);
		PLACED_FEATURE = PlacementUtils.register("blockheads:weed_1", CONFIGURED_FEATURE, List.of(BiomeFilter.biome()));
		return FEATURE;
	}

	public static Holder<PlacedFeature> placedFeature() {
		return PLACED_FEATURE;
	}

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	private final List<Block> base_blocks;

	private StructureTemplate template = null;

	public Weed1Feature() {
		super(NoneFeatureConfiguration.CODEC);

		base_blocks = List.of(Blocks.GRASS_BLOCK, Blocks.BIRCH_PLANKS, Blocks.MOSS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		if (!generate_dimensions.contains(context.level().getLevel().dimension()))
			return false;

		if (template == null)
			template = context.level().getLevel().getStructureManager().getOrCreate(new ResourceLocation("blockheads", "weed1"));

		if (template == null)
			return false;

		boolean anyPlaced = false;
		if ((context.random().nextInt(1000000) + 1) <= 100000) {
			int count = context.random().nextInt(5) + 1;
			for (int a = 0; a < count; a++) {
				int i = context.origin().getX() + context.random().nextInt(16);
				int k = context.origin().getZ() + context.random().nextInt(16);

				int j = context.level().getHeight(Heightmap.Types.OCEAN_FLOOR_WG, i, k) - 1;

				if (!base_blocks.contains(context.level().getBlockState(new BlockPos(i, j, k)).getBlock()))
					continue;

				BlockPos spawnTo = new BlockPos(i + 0, j + 0, k + 0);

				if (template.placeInWorld(context.level(), spawnTo, spawnTo,
						new StructurePlaceSettings().setMirror(Mirror.values()[context.random().nextInt(2)])
								.setRotation(Rotation.values()[context.random().nextInt(3)]).setRandom(context.random())
								.addProcessor(BlockIgnoreProcessor.AIR).setIgnoreEntities(false),
						context.random(), 2)) {

					anyPlaced = true;
				}
			}
		}

		return anyPlaced;
	}

}
