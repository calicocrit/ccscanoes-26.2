package calico.crit.canoes;

import calico.crit.canoes.client.model.OakCanoe;
import calico.crit.canoes.client.model.SpruceCanoe;
import calico.crit.canoes.client.renderer.CanoeRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = CCsCanoes.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = CCsCanoes.MODID, value = Dist.CLIENT)
public class CCsCanoesClient {
    public CCsCanoesClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        CCsCanoes.LOGGER.info("HELLO FROM CLIENT SETUP");
        CCsCanoes.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CCsCanoes.OAK_CANOE.get(), ctx -> new CanoeRenderer(ctx, OakCanoe.LAYER_LOCATION, Identifier.fromNamespaceAndPath(CCsCanoes.MODID, "textures/entity/oakcanoet.png"), OakCanoe::new));
        event.registerEntityRenderer(CCsCanoes.SPRUCE_CANOE.get(), ctx -> new CanoeRenderer(ctx, SpruceCanoe.LAYER_LOCATION, Identifier.fromNamespaceAndPath(CCsCanoes.MODID, "textures/entity/sprucecanoet.png"), SpruceCanoe::new));
    }

    @SubscribeEvent
    static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(OakCanoe.LAYER_LOCATION, OakCanoe::createBodyLayer);
        event.registerLayerDefinition(SpruceCanoe.LAYER_LOCATION, SpruceCanoe::createBodyLayer);
    }
}
