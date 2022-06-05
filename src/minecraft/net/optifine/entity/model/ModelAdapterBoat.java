package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.src.Reflector;
import net.minecraft.src.ReflectorField;

public class ModelAdapterBoat extends ModelAdapter
{
    public ModelAdapterBoat()
    {
        super(EntityBoat.class, "boat", 0.5F);
    }

    public ModelBase makeModel()
    {
        return new ModelBoat();
    }

    public ModelRenderer getModelRenderer(ModelBase model, String modelPart)
    {
        if (!(model instanceof ModelBoat))
        {
            return null;
        }
        else
        {
            ModelBoat modelboat = (ModelBoat)model;
            return modelPart.equals("bottom") ? modelboat.boatSides[0] : (modelPart.equals("back") ? modelboat.boatSides[1] : (modelPart.equals("front") ? modelboat.boatSides[2] : (modelPart.equals("right") ? modelboat.boatSides[3] : (modelPart.equals("left") ? modelboat.boatSides[4] : (modelPart.equals("paddle_left") ? modelboat.paddles[0] : (modelPart.equals("paddle_right") ? modelboat.paddles[1] : (modelPart.equals("bottom_no_water") ? modelboat.noWater : null)))))));
        }
    }

    public IEntityRenderer makeEntityRender(ModelBase modelBase, float shadowSize)
    {
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        RenderBoat renderboat = new RenderBoat(rendermanager);
        ReflectorField reflectorfield = Reflector.getReflectorField(RenderBoat.class, ModelBase.class);

        if (reflectorfield != null && reflectorfield.exists())
        {
            Reflector.setFieldValue(renderboat, reflectorfield, modelBase);
            renderboat.shadowSize = shadowSize;
            return renderboat;
        }
        else
        {
            return null;
        }
    }
}
