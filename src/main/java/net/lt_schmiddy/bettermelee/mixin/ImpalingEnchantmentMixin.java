package net.lt_schmiddy.bettermelee.mixin;

// import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.lt_schmiddy.bettermelee.config.ConfigHandler;
// import net.lt_schmiddy.bettermelee.ModEntry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

@Mixin( net.minecraft.enchantment.ImpalingEnchantment.class)
public class ImpalingEnchantmentMixin extends Enchantment {
	protected ImpalingEnchantmentMixin(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
		super(weight, type, slotTypes);
		//TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		
		return super.isAcceptableItem(stack) && (
			EnchantmentHelper.getLevel(Enchantments.SHARPNESS, stack) == 0
			&& EnchantmentHelper.getLevel(Enchantments.SMITE, stack) == 0
			&& EnchantmentHelper.getLevel(Enchantments.BANE_OF_ARTHROPODS, stack) == 0
		);
	}

	@Inject(at = @At("RETURN"), method = "getAttackDamage", cancellable = true)
	private void increaseDamage(int level, EntityGroup group, CallbackInfoReturnable<Object> info) {
		
		info.setReturnValue(info.getReturnValueF() * ConfigHandler.config.enchantDamageMult);
	}
}


