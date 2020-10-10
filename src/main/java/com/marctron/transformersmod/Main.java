package com.marctron.transformersmod;

import java.io.File;

import org.apache.logging.log4j.Logger;

import com.marctron.transformersmod.commands.CommandDimensionTeleport;
import com.marctron.transformersmod.init.CybertronWorldGen;
import com.marctron.transformersmod.init.GunEntities;
import com.marctron.transformersmod.init.ModRecipes;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.proxy.IProxy;
import com.marctron.transformersmod.resize.potions.PotionGrowth;
import com.marctron.transformersmod.resize.potions.PotionShrinking;
//import com.marctron.transformersmod.sounds.DetectDriving;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.handlers.CapabilityHandler;
import com.marctron.transformersmod.util.handlers.GuiHandler;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import com.marctron.transformersmod.world.generators.ModWorldGen;
import com.marctron.transformersmod.world.generators.WorldGenCustomStructures;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	public static EntityLivingBase entity ;
	
	public static final Potion SHRINKING = new PotionShrinking("shrinking", entity);
	public static final Potion GROWTH = new PotionGrowth("growth");

    @Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;


    public static File config;
        

    
    public static CreativeTabs tabTransformers = new CreativeTabs("tabTransformersMod") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(RegistryHandler.ModItems.ENERGON_SHARD);
        }

        ;

        @Override
        public boolean hasSearchBar() {
            return true;
        }

    }.setBackgroundImageName("item_search.png");
    
    public static CreativeTabs tabWeapons = new CreativeTabs("tabWeapons") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(RegistryHandler.ModItems.AMMO);
        };

        @Override
        public boolean hasSearchBar() {
            return false;
        }

    };
    public static CreativeTabs tabDecepticon = new CreativeTabs("tabDecepticon") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(RegistryHandler.ModItems.D_I);
        };

        @Override
        public boolean hasSearchBar() {
            return false;
        }

    };
    
    public static CreativeTabs tabTFBlocks = new CreativeTabs("tabTFBlocks") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(RegistryHandler.ModBlocks.LOCK_BLOCK);
        };

        @Override
        public boolean hasSearchBar() {
            return false;
        }

    };
    
    public static Logger logger;
    
    public static CreativeTabs tabAutobot = new CreativeTabs("tabAutobot") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(RegistryHandler.ModItems.A_I);
        };

        @Override
        public boolean hasSearchBar() {
            return false;
        }

    };
    public static CreativeTabs tabFisk = new CreativeTabs("tabFisk") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(RegistryHandler.ModItems.ENERGON_CRYSTAL);
        };

        @Override
        public boolean hasSearchBar() {
            return false;
        }

    };

	
    public static SimpleNetworkWrapper network;
    
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
    	
    	CapabilityHandler.registerCaps();
       
    	GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
        
        logger = event.getModLog();

        CybertronWorldGen.registerDimensions();

        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);

        //ModBiomes.registerBiomes();

//        EntityInit.registerEntities();

        //GunEntities.regEntities();
        
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
//        
//        network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
//        network.registerMessage(new PacketInventory.Handler(), PacketInventory.class, 2, Side.SERVER);
        
       
        TFNetworkManager.registerPackets();
    

        
        

//		network.registerMessage(new PacketUpdatePedestal.Handler(), PacketUpdatePedestal.class, 0, Side.CLIENT);
//		network.registerMessage(new PacketRequestUpdatePedestal.Handler(), PacketRequestUpdatePedestal.class, 1, Side.SERVER);
        

        
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
    	
        ModRecipes.init();
        // TODO: Should be instantiated in Forge related event RegistryEvent.Register<SoundEvent> -Toma
        SoundsHandler.init();
        GunEntities.regEntities();
//        MinecraftForge.EVENT_BUS.register(new DetectDriving());
        
        proxy.init(event);
    }

    @EventHandler
    public static void preInitRegistries() {
//        EntityInit.registerEntities();
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
        
      
    }

    @EventHandler
    public static void serverInit(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandDimensionTeleport());
    }
    
    
    
    
    
	//HELPER FUNCTIONS
	
	public static int sign(double x) {
		return (int) (Math.abs(x)/x);
	}
	
	public static double invLerp(double a, double b, double c) {
		return (c - a) / (b - a);
	}
	
	public static double lerp(double a, double b, double k) {
		return (1 - k)*a + k*b;
	}

    public static RayTraceResult rayTraceEntity(Vec3d vec3d1, Vec3d vec3d2, Entity entity) {
		
		double x1 = vec3d1.x;
		double x2 = vec3d2.x;
		double y1 = vec3d1.y;
		double y2 = vec3d2.y;
		double z1 = vec3d1.z;
		double z2 = vec3d2.z;
		
		double x;
		double y;
		double z;
		
		double k = 0;
		
		AxisAlignedBB entityAABB = entity.getEntityBoundingBox();
		
		if (entityAABB == null) {
			logger.error("AABB is NULL");
			return null;
		}
		
		double dx = x2 - x1;
		double dy = y2 - y1;
		double dz = z2 - z1;
		
		if (dx >= 0) {
			k = invLerp(x1, x2, entityAABB.minX);
			x = entityAABB.minX;
			y = lerp(y1, y2, k);
			z = lerp(z1, z2, k);
			if (y >= entityAABB.maxY) {
				if (dy > 0) {
					//LOGGER.error("Ray Not in EntityAABB");
					return null;
				}
				if (z >= entityAABB.maxZ) {
					if (dz > 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.maxY);
					x = lerp(x1, x2, k);
					y = entityAABB.maxY;
					z = lerp(z1, z2, k);
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z >= entityAABB.maxZ) {
						k = invLerp(z1, z2, entityAABB.maxZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.maxZ;
						if (x > entityAABB.maxX || y < entityAABB.minY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						//LOGGER.info("Created Ray Trace Result");
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z < entityAABB.minZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					//LOGGER.info("Created Ray Trace Result");
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z < entityAABB.minZ) {
					if (dz < 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.maxY);
					x = lerp(x1, x2, k);
					y = entityAABB.maxY;
					z = lerp(z1, z2, k);
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ) {
						k = invLerp(z1, z2, entityAABB.minZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.minZ;
						if (x > entityAABB.maxX || y < entityAABB.minY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z >= entityAABB.minZ && z < entityAABB.maxZ) {
					k = invLerp(y1, y2, entityAABB.maxY);
					x = lerp(x1, x2, k);
					y = entityAABB.maxY;
					z = lerp(z1, z2, k);
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ || z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
			}
			if (y < entityAABB.minY) {
				if (dy < 0) {
					//LOGGER.error("Ray Not in EntityAABB");
					return null;
				}
				if (z >= entityAABB.maxZ) {
					if (dz > 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.minY);
					x = lerp(x1, x2, k);
					y = entityAABB.minY;
					z = lerp(z1, z2, k);
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z >= entityAABB.maxZ) {
						k = invLerp(z1, z2, entityAABB.maxZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.maxZ;
						if (x > entityAABB.maxX || y > entityAABB.maxY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z < entityAABB.minZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z < entityAABB.minZ) {
					if (dz < 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.minY);
					x = lerp(x1, x2, k);
					y = entityAABB.minY;
					z = lerp(z1, z2, k);
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ) {
						k = invLerp(z1, z2, entityAABB.minZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.minZ;
						if (x > entityAABB.maxX || y > entityAABB.maxY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z >= entityAABB.minZ && z < entityAABB.maxZ) {
					k = invLerp(y1, y2, entityAABB.minY);
					x = lerp(x1, x2, k);
					y = entityAABB.minY;
					z = lerp(z1, z2, k);
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ || z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
			}
			if (y >= entityAABB.minY && y < entityAABB.maxY) {
				if (z < entityAABB.minZ) {
					if (dz < 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(z1, z2, entityAABB.minZ);
					x = lerp(x1, x2, k);
					y = lerp(y1, y2, k);
					z = entityAABB.minZ;
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (y < entityAABB.minY || y > entityAABB.maxY) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z >= entityAABB.maxZ) {
					if (dz > 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(z1, z2, entityAABB.maxZ);
					x = lerp(x1, x2, k);
					y = lerp(y1, y2, k);
					z = entityAABB.maxZ;
					if (x > entityAABB.maxX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (y < entityAABB.minY || y > entityAABB.maxY) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				return new RayTraceResult(entity, new Vec3d(x, y, z));
			}
		}
		if (dx < 0) {
			k = invLerp(x1, x2, entityAABB.maxX);
			x = entityAABB.maxX;
			y = lerp(y1, y2, k);
			z = lerp(z1, z2, k);
			if (y >= entityAABB.maxY) {
				if (dy > 0) {
					//LOGGER.error("Ray Not in EntityAABB");
					return null;
				}
				if (z >= entityAABB.maxZ) {
					if (dz > 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.maxY);
					x = lerp(x1, x2, k);
					y = entityAABB.maxY;
					z = lerp(z1, z2, k);
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z >= entityAABB.maxZ) {
						k = invLerp(z1, z2, entityAABB.maxZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.maxZ;
						if (x < entityAABB.minX || y < entityAABB.minY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z < entityAABB.minZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z < entityAABB.minZ) {
					if (dz < 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.maxY);
					x = lerp(x1, x2, k);
					y = entityAABB.maxY;
					z = lerp(z1, z2, k);
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ) {
						k = invLerp(z1, z2, entityAABB.minZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.minZ;
						if (x < entityAABB.minX || y < entityAABB.minY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z >= entityAABB.minZ && z < entityAABB.maxZ) {
					k = invLerp(y1, y2, entityAABB.maxY);
					x = lerp(x1, x2, k);
					y = entityAABB.maxY;
					z = lerp(z1, z2, k);
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ || z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
			}
			if (y < entityAABB.minY) {
				if (dy < 0) {
					//LOGGER.error("Ray Not in EntityAABB");
					return null;
				}
				if (z >= entityAABB.maxZ) {
					if (dz > 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.minY);
					x = lerp(x1, x2, k);
					y = entityAABB.minY;
					z = lerp(z1, z2, k);
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z >= entityAABB.maxZ) {
						k = invLerp(z1, z2, entityAABB.maxZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.maxZ;
						if (x < entityAABB.minX || y > entityAABB.maxY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z < entityAABB.minZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z < entityAABB.minZ) {
					if (dz < 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(y1, y2, entityAABB.minY);
					x = lerp(x1, x2, k);
					y = entityAABB.minY;
					z = lerp(z1, z2, k);
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ) {
						k = invLerp(z1, z2, entityAABB.minZ);
						x = lerp(x1, x2, k);
						y = lerp(y1, y2, k);
						z = entityAABB.minZ;
						if (x < entityAABB.minX || y > entityAABB.maxY) {
							//LOGGER.error("Ray Not in EntityAABB");
							return null;
						}
						return new RayTraceResult(entity, new Vec3d(x, y, z));
					}
					if (z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z >= entityAABB.minZ && z < entityAABB.maxZ) {
					k = invLerp(y1, y2, entityAABB.minY);
					x = lerp(x1, x2, k);
					y = entityAABB.minY;
					z = lerp(z1, z2, k);
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (z < entityAABB.minZ || z > entityAABB.maxZ) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
			}
			if (y >= entityAABB.minY && y < entityAABB.maxY) {
				if (z < entityAABB.minZ) {
					if (dz < 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(z1, z2, entityAABB.minZ);
					x = lerp(x1, x2, k);
					y = lerp(y1, y2, k);
					z = entityAABB.minZ;
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (y < entityAABB.minY || y > entityAABB.maxY) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				if (z >= entityAABB.maxZ) {
					if (dz > 0) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					k = invLerp(z1, z2, entityAABB.maxZ);
					x = lerp(x1, x2, k);
					y = lerp(y1, y2, k);
					z = entityAABB.maxZ;
					if (x < entityAABB.minX) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					if (y < entityAABB.minY || y > entityAABB.maxY) {
						//LOGGER.error("Ray Not in EntityAABB");
						return null;
					}
					return new RayTraceResult(entity, new Vec3d(x, y, z));
				}
				return new RayTraceResult(entity, new Vec3d(x, y, z));
			}
		}
		logger.error("Ray Not in EntityAABB catch");
		return null;
	}
    
}
