package com.djlaser.betterallays.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;

public class TemplateBuddingBlock extends BuddingAmethystBlock  {
    protected static final Direction[] DIRECTIONS = Direction.values();

    private final Block[] clusters;
    public TemplateBuddingBlock(Properties props, Supplier<Block[]> clusterList) {
        super(props);
        clusters = clusterList.get();
    }

    @Override
    public void randomTick(@NotNull BlockState p_220898_, @NotNull ServerLevel p_220899_, @NotNull BlockPos p_220900_, RandomSource p_220901_) {
        if (p_220901_.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[p_220901_.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = p_220900_.relative(direction);
            BlockState blockstate = p_220899_.getBlockState(blockpos);
            Block block = null;

            for (int i = 0; i < clusters.length; i++){
                if(i == 0) {
                    if(canClusterGrowAtState(blockstate)){
                        block = clusters[i];
                    }
                } else {
                    if(blockstate.is(clusters[i-1]) &&
                            blockstate.getValue(AmethystClusterBlock.FACING) == direction)
                    {
                        block = clusters[i];
                    }
                }
            }


            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction).setValue(AmethystClusterBlock.WATERLOGGED, blockstate.getFluidState().getType() == Fluids.WATER);
                p_220899_.setBlockAndUpdate(blockpos, blockstate1);
            }

        }
    }

}
