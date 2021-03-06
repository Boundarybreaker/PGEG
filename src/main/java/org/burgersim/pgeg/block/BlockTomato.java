package org.burgersim.pgeg.block;

import net.minecraft.block.BlockCrops;
import org.burgersim.pgeg.listener.PgegRegistry;
import net.minecraft.util.IItemProvider;

public class BlockTomato extends BlockCrops {
    public BlockTomato(Builder builder) {
        super(builder);
    }

    @Override
    protected IItemProvider getSeedsItem(){
        return PgegRegistry.TOMATO_SEEDS;
    }

    @Override
    protected IItemProvider getCropsItem() {
        return PgegRegistry.TOMATO;
    }
}
