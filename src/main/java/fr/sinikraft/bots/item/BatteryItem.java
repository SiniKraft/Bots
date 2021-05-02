
package fr.sinikraft.bots.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

import fr.sinikraft.bots.procedures.BatteryItemInInventoryTickProcedure;
import fr.sinikraft.bots.itemgroup.BotsItemGroup;
import fr.sinikraft.bots.BotsModElements;

@BotsModElements.ModElement.Tag
public class BatteryItem extends BotsModElements.ModElement {
	@ObjectHolder("bots:battery")
	public static final Item block = null;
	public BatteryItem(BotsModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(BotsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("battery");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("itemstack", itemstack);
				BatteryItemInInventoryTickProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
