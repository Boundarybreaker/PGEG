package org.burgersim.pgeg.block;

import com.github.ondee.snowflake.block.BlockWaterlogged;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ShapeUtils;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.burgersim.pgeg.item.ItemRune;
import org.burgersim.pgeg.tileentity.TileEntityRunePedestal;

import javax.annotation.Nullable;

public class BlockRunePedestal extends BlockWaterlogged implements ITileEntityProvider {
    final static private VoxelShape SHAPE = ShapeUtils.create(.1, 0, .1, .9, .1, .9);

    public BlockRunePedestal(Builder builder) {
        super(builder);
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World world, BlockPos blockPos, EntityPlayer player, EnumHand hand, EnumFacing facing, float p_onBlockActivated_7_, float p_onBlockActivated_8_, float p_onBlockActivated_9_) {
        if (player.getHeldItem(hand).getItem() instanceof ItemRune) {
            ItemRune itemRune = (ItemRune) player.getHeldItem(hand).getItem();
            TileEntity tileEntity = world.getTileEntity(blockPos);
            if (tileEntity instanceof TileEntityRunePedestal) {
                ((TileEntityRunePedestal) tileEntity).setRune(itemRune.getRune());
                player.getHeldItem(hand).shrink(1);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public VoxelShape getShape(IBlockState p_getShape_1_, IBlockReader p_getShape_2_, BlockPos p_getShape_3_) {
        return SHAPE;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader iBlockReader) {
        return new TileEntityRunePedestal();
    }

    @Override
    public void onReplaced(IBlockState state, World world, BlockPos pos, IBlockState state1, boolean p_beforeReplacingBlock_5_) {
        world.removeTileEntity(pos);
    }

    @Override
    public boolean isSolid(IBlockState p_isSolid_1_) {
        return false;
    }
}
