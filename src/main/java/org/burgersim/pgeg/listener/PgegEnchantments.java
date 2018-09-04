package org.burgersim.pgeg.listener;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.enchantment.EnchantmentCursePain;
import org.burgersim.pgeg.enchantment.EnchantmentPoisonous;
import org.burgersim.pgeg.enchantment.EnchantmentVampirism;
import org.dimdev.rift.listener.EnchantmentAdder;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegEnchantments implements EnchantmentAdder {
    public static Enchantment VAMPIRISM;
    public static Enchantment POISONOUS;
    public static Enchantment CURSE_PAIN;

    @Override
    public void registerEnchantments() {
        VAMPIRISM = registerEnchantment(new ResourceLocation(MOD_ID, "vampirism"), new EnchantmentVampirism());
        POISONOUS = registerEnchantment(new ResourceLocation(MOD_ID, "poisonous"), new EnchantmentPoisonous());
        CURSE_PAIN = registerEnchantment(new ResourceLocation(MOD_ID, "curse_pain"), new EnchantmentCursePain());
    }

    private Enchantment registerEnchantment(ResourceLocation location, Enchantment enchantment) {
        Enchantment.registerEnchantment(location.toString(), enchantment);
        return Enchantment.REGISTRY.get(location);
    }
}
