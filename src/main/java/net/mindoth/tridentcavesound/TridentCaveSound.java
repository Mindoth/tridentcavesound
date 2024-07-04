package net.mindoth.tridentcavesound;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TridentCaveSound.MOD_ID)
public class TridentCaveSound {
    public static final String MOD_ID = "tridentcavesound";


    public TridentCaveSound() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }
}
