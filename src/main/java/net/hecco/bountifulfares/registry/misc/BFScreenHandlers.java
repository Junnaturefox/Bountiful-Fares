package net.hecco.bountifulfares.registry.misc;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.network.GristmillPayload;
import net.hecco.bountifulfares.screen.GristmillScreenHandler;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class BFScreenHandlers {
    public static final ScreenHandlerType<GristmillScreenHandler> GRISTMILL_SCREEN_HANDLER =
            register("gristmill_screen_handler", GristmillScreenHandler::new, GristmillPayload.PACKET_CODEC);

    public static <T extends ScreenHandler, D extends GristmillPayload> ExtendedScreenHandlerType<T, D> register (String name, ExtendedScreenHandlerType.ExtendedFactory<T, D> factory, PacketCodec<? super RegistryByteBuf, D> codec) {
        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BountifulFares.MOD_ID, name), new ExtendedScreenHandlerType<>(factory, codec));
    }

    public static void registerScreenHandlers() {
    }
}
