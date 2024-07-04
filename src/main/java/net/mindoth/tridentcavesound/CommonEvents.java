package net.mindoth.tridentcavesound;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TridentCaveSound.MOD_ID)
public class CommonEvents {

    @SubscribeEvent
    public static void playCaveSound(EntityLeaveLevelEvent event) {
        Level level = event.getLevel();
        if ( level.isClientSide ) return;
        if ( level.dimension() == Level.END ) {
            if ( event.getEntity() instanceof ThrownTrident trident && trident.getOwner() != null && trident.getY() < level.getMinBuildHeight() ) {
                Entity owner = trident.getOwner();
                Vec3 vec = new Vec3(trident.getX() - owner.getX(), trident.getY() - owner.getY(), trident.getZ() - owner.getZ()).normalize();
                vec = new Vec3(owner.getX() + vec.x * 3, owner.getY(), owner.getZ() + vec.z * 3);
                BlockPos blockPos = new BlockPos((int)vec.x, (int)vec.y, (int)vec.z);
                level.playSound(null, blockPos, SoundEvents.AMBIENT_CAVE.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }
    }
}
