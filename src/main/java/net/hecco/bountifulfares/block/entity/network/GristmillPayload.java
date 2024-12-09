package net.hecco.bountifulfares.block.entity.network;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record GristmillPayload(BlockPos pos) implements CustomPayload {
    public static final Id<GristmillPayload> ID = new Id<>(Identifier.of(BountifulFares.MOD_ID, "gristmill"));
    public static final PacketCodec<RegistryByteBuf, GristmillPayload> PACKET_CODEC = PacketCodec.tuple(
            BlockPos.PACKET_CODEC, GristmillPayload::pos, GristmillPayload::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
