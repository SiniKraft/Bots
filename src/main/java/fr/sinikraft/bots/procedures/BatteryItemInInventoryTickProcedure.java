package fr.sinikraft.bots.procedures;

import net.minecraft.item.ItemStack;

import java.util.Random;
import java.util.Map;

import fr.sinikraft.bots.BotsModElements;
import fr.sinikraft.bots.BotsMod;

@BotsModElements.ModElement.Tag
public class BatteryItemInInventoryTickProcedure extends BotsModElements.ModElement {
	public BatteryItemInInventoryTickProcedure(BotsModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BotsMod.LOGGER.warn("Failed to load dependency itemstack for procedure BatteryItemInInventoryTick!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((!((((itemstack)).getDamage()) == (100 - ((itemstack).getOrCreateTag().getDouble("energy")))))) {
			((itemstack)).setDamage((int) 100);
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) (100 - ((itemstack).getOrCreateTag().getDouble("energy"))), new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
	}
}
