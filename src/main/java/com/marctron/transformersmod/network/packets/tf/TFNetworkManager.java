package com.marctron.transformersmod.network.packets.tf;

import com.marctron.transformersmod.network.packets.PacketDrivingSound;
import com.marctron.transformersmod.network.packets.PacketShootRocket;
import com.marctron.transformersmod.network.packets.motormaster.PacketMotormaster;
import com.marctron.transformersmod.network.packets.movieop.PacketMovieOptimusPrime;
import com.marctron.transformersmod.network.packets.movieop.PacketMovieOptimusPrimeStealth;
import com.marctron.transformersmod.network.packets.tfp.magnus.PacketTFPMagnus;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class TFNetworkManager {
public static SimpleNetworkWrapper networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
private static int packetId = 0;




public static void registerPackets()
{
    
    

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
    registerPacket(PacketMovieOptimusPrime.Handler.class, PacketMovieOptimusPrime.class);
    registerPacket(PacketMotormaster.Handler.class, PacketMotormaster.class);
    registerPacket(PacketTFPMagnus.Handler.class, PacketTFPMagnus.class);
    registerPacket(PacketMovieOptimusPrimeStealth.Handler.class, PacketMovieOptimusPrimeStealth.class);
    registerPacket(PacketShootRocket.Handler.class, PacketShootRocket.class);
    registerPacket(PacketDrivingSound.Handler.class, PacketDrivingSound.class);
   
}



private static <REQ extends IMessage, REPLY extends IMessage> void registerPacket(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType)
{
//    networkWrapper.registerMessage(messageHandler, requestMessageType, packetId++, Side.CLIENT);
    networkWrapper.registerMessage(messageHandler, requestMessageType, packetId++, Side.SERVER);
    
}


public static void sendToServer(IMessage message){
	networkWrapper.sendToServer(message);
}

public static void sendTo(IMessage message, EntityPlayerMP player){
	networkWrapper.sendTo(message, player);
}

public static void sendToAllAround(IMessage message, TargetPoint point){
	networkWrapper.sendToAllAround(message, point);
}

/**
 * Will send the given packet to every player within 64 blocks of the XYZ of the XYZ packet.
 * @param message
 * @param world
 */


public static void sendToAll(IMessage message){
	networkWrapper.sendToAll(message);
}

public static void sendToDimension(IMessage message, int dimensionId){
	networkWrapper.sendToDimension(message, dimensionId);
}

public static void init()
{

}

}