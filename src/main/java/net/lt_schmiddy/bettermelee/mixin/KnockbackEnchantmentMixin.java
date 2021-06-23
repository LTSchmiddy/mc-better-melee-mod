package net.lt_schmiddy.bettermelee.mixin;

// import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;

// import net.lt_schmiddy.bettermelee.ModEntry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
// import net.minecraft.item.BowItem;
// import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;


@Mixin( net.minecraft.enchantment.KnockbackEnchantment.class)
public class KnockbackEnchantmentMixin extends Enchantment {
	protected KnockbackEnchantmentMixin(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
		super(weight, type, slotTypes);
		//TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		
		return super.isAcceptableItem(stack) || (
			stack.getItem() instanceof AxeItem
			|| stack.getItem() instanceof TridentItem
			// || stack.getItem() instanceof BowItem
			// || stack.getItem() instanceof CrossbowItem
		);
	}
}

