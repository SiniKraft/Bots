package fr.sinikraft.bots.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import java.util.Map;

import fr.sinikraft.bots.BotsModElements;
import fr.sinikraft.bots.BotsMod;

@BotsModElements.ModElement.Tag
public class BotStationParticleSpawningConditionProcedure extends BotsModElements.ModElement {
	public BotStationParticleSpawningConditionProcedure(BotsModElements instance) {
		super(instance, 2);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BotsMod.LOGGER.warn("Failed to load dependency x for procedure BotStationParticleSpawningCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BotsMod.LOGGER.warn("Failed to load dependency y for procedure BotStationParticleSpawningCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BotsMod.LOGGER.warn("Failed to load dependency z for procedure BotStationParticleSpawningCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BotsMod.LOGGER.warn("Failed to load dependency world for procedure BotStationParticleSpawningCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "showParticles"))) {
			return (true);
		}
		return (false);
	}
}
