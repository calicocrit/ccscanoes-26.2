package calico.crit.canoes.client.model;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.Identifier;

public class OakCanoe extends CanoeModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath("ccscanoes", "oakcanoe"), "main");

	private static final CanoeTextureOffsets OAK_OFFSETS = new CanoeTextureOffsets(
		88, 84,   // bone2 box1
		0, 0,     // bone2 box2
		88, 97,   // r1
		0, 49,    // r2 box1
		44, 84,   // r2 box2
		74, 49,   // r3 box1
		0, 84,    // r3 box2
		0, 101,   // r4
		38, 101,  // r5
		32, 101   // r6
	);

	public OakCanoe(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		return createCanoeLayer(OAK_OFFSETS);
	}
}
