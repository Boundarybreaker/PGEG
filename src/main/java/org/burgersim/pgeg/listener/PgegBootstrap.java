package org.burgersim.pgeg.listener;

import net.minecraft.item.Item;
import net.minecraft.item.crafting.RecipeSerializers;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.recipe.RecipesSpellCauldron;
import org.burgersim.pgeg.recipe.RecipesWand;
import org.dimdev.rift.listener.BootstrapListener;

public class PgegBootstrap implements BootstrapListener {
    public static final Tag<Item> wands = new ItemTags.Wrapper(new ResourceLocation("pgeg", "wands"));

    @Override
    public void afterVanillaBootstrap() {
        RecipeSerializers.register(RecipesWand.Serializer.INSTANCE);
        RecipeSerializers.register(RecipesSpellCauldron.Serializer.INSTANCE);
    }
}