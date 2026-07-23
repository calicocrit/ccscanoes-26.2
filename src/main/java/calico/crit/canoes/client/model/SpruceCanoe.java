package calico.crit.canoes.client.model;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.Identifier;

public class SpruceCanoe extends CanoeModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath("ccscanoes", "sprucecanoe"), "main");

	private static final CanoeTextureOffsets SPRUCE_OFFSETS = new CanoeTextureOffsets(
		2, 88,    // bone2 box1
		3, 2,     // bone2 box2
		0, 101,   // r1
		0, 51,    // r2 box1
		98, 86,   // r2 box2
		74, 51,   // r3 box1
		50, 86,   // r3 box2
		38, 103,  // r4
		78, 103,  // r5
		71, 104   // r6
	);

	public SpruceCanoe(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		return createCanoeLayer(SPRUCE_OFFSETS);
	}
}
