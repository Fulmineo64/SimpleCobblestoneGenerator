package dev.fulmineo.simple_cobblestone_generator.block.entity;

import dev.fulmineo.simple_cobblestone_generator.SimpleCobblestoneGenerator;
import dev.fulmineo.simple_cobblestone_generator.init.CobblestoneGeneratorsInit;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class CobblestoneGeneratorTier4BlockEntity extends AbstractCobblestoneGeneratorBlockEntity {
	public CobblestoneGeneratorTier4BlockEntity(BlockPos pos, BlockState state) {
		super(CobblestoneGeneratorsInit.COBBLE_GEN_TIER4_ENTITY, pos, state, "cobble_gen_tier4", (short)SimpleCobblestoneGenerator.TIERS[3]);
	}
}
