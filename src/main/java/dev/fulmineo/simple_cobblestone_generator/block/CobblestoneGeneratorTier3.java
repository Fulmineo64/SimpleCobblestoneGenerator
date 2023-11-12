package dev.fulmineo.simple_cobblestone_generator.block;

import org.jetbrains.annotations.Nullable;

import dev.fulmineo.simple_cobblestone_generator.block.entity.CobblestoneGeneratorTier3BlockEntity;
import dev.fulmineo.simple_cobblestone_generator.init.CobblestoneGeneratorsInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CobblestoneGeneratorTier3 extends AbstractCobblestoneGenerator {
	public CobblestoneGeneratorTier3(){
		super(3);
	}

	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new CobblestoneGeneratorTier3BlockEntity(pos, state);
	}

	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
	   return validateTicker(world, type, CobblestoneGeneratorsInit.COBBLE_GEN_TIER3_ENTITY);
	}
}
