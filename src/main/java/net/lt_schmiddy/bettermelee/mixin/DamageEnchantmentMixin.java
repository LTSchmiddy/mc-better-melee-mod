package net.lt_schmiddy.bettermelee.mixin;

// import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
// import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// import net.lt_schmiddy.bettermelee.ModEntry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;

import net.lt_schmiddy.bettermelee.config.ConfigHandler;

@Mixin( net.minecraft.enchantment.DamageEnchantment.class)
public class DamageEnchantmentMixin extends Enchantment {
	protected DamageEnchantmentMixin(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
		super(weight, type, slotTypes);
		//TODO Auto-generated constructor stub
	}

	@Inject(at = @At("RETURN"), method = "isAcceptableItem", cancellable = true)
	private void isAcceptableItem_trident(ItemStack stack, CallbackInfoReturnable<Object> info) {
		
		info.setReturnValue(info.getReturnValueZ() || (
			stack.getItem() instanceof TridentItem
			&& EnchantmentHelper.getLevel(Enchantments.IMPALING, stack) == 0
		));
	}

	@Inject(at = @At("RETURN"), method = "getAttackDamage", cancellable = true)
	private void increaseDamage(int level, EntityGroup group, CallbackInfoReturnable<Object> info) {
		
		info.setReturnValue(info.getReturnValueF() * ConfigHandler.config.enchantDamageMult);
	}
}

