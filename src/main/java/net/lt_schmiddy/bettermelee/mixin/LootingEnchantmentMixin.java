package net.lt_schmiddy.bettermelee.mixin;

// import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;

// import net.lt_schmiddy.bettermelee.ModEntry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;


@Mixin( net.minecraft.enchantment.LuckEnchantment.class)
public class LootingEnchantmentMixin extends Enchantment {
	protected LootingEnchantmentMixin(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
		super(weight, type, slotTypes);
		//TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		
		return super.isAcceptableItem(stack) || (
			this.type == EnchantmentTarget.WEAPON && (
				stack.getItem() instanceof TridentItem
				|| stack.getItem() instanceof AxeItem
			)
		);
	}
}

