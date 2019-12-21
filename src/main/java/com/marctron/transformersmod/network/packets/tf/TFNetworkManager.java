package com.marctron.transformersmod.network.packets.tf;

import com.marctron.transformersmod.network.packets.PacketInventory;
import com.marctron.transformersmod.network.packets.PacketInventoryHandler;
import com.marctron.transformersmod.util.Reference;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class TFNetworkManager {
public static SimpleNetworkWrapper networkWrapper;
private static int packetId = 0;

public static void registerPackets(String channelName)
{
    networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

//    registerPacket(MessageSetPlayerData.Handler.class, MessageSetPlayerData.class);
//    registerPacket(MessagePlayerData.Handler.class, MessagePlayerData.class);
//    registerPacket(MessagePlayerJoin.Handler.class, MessagePlayerJoin.class);
//    registerPacket(MessageBroadcastState.Handler.class, MessageBroadcastState.class);
//    registerPacket(MessageVehicleShoot.Handler.class, MessageVehicleShoot.class);
//    registerPacket(MessageCloudtrapJetpack.Handler.class, MessageCloudtrapJetpack.class);
//    registerPacket(MessageLaserShoot.Handler.class, MessageLaserShoot.class);
//    registerPacket(MessageSendFlying.Handler.class, MessageSendFlying.class);
//    registerPacket(MessageColorArmor.Handler.class, MessageColorArmor.class);
//    registerPacket(MessageControlPanelSetConfig.Handler.class, MessageControlPanelSetConfig.class);
//    registerPacket(MessageGroundBridgeTeleport.Handler.class, MessageGroundBridgeTeleport.class);
//    registerPacket(MessageClosePortal.Handler.class, MessageClosePortal.class);
//    registerPacket(MessageOpenGui.Handler.class, MessageOpenGui.class);
//    registerPacket(MessageTileTrigger.Handler.class, MessageTileTrigger.class);
//    registerPacket(MessageSetTileData.Handler.class, MessageSetTileData.class);
//    registerPacket(MessageConnectReceiver.Handler.class, MessageConnectReceiver.class);
    registerPacket(MessageUpdateArmor.Handler.class, MessageUpdateArmor.class);
    registerPacket(PacketInventoryHandler.class, PacketInventory.class);
}

private static <REQ extends IMessage, REPLY extends IMessage> void registerPacket(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType)
{
    networkWrapper.registerMessage(messageHandler, requestMessageType, packetId++, Side.CLIENT);
    networkWrapper.registerMessage(messageHandler, requestMessageType, packetId++, Side.SERVER);
}
}